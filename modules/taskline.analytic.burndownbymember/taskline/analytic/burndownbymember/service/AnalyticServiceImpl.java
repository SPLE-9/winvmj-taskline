package taskline.analytic.burndownbymember;

import java.util.*;

import vmj.routing.route.VMJExchange;

import taskline.analytic.core.AnalyticServiceDecorator;
import taskline.analytic.core.AnalyticImpl;
import taskline.analytic.core.AnalyticServiceComponent;
import taskline.user.core.*;

public class AnalyticServiceImpl extends AnalyticServiceDecorator {
    private AnalyticFactory analyticFactory = new AnalyticFactory();
    private UserService userService = new UserServiceImpl();

    public AnalyticServiceImpl(AnalyticServiceComponent record) {
        super(record);
    }

    public List<Analytic> saveAnalytic(HashMap<String, Object> requestBody) {
        String email = (String) requestBody.get("email");
        User user = userService.getUserByEmail(email);

        calculateBurndownData(user);
        return getAllAnalyticByUser(email);
    }   

    public List<Analytic> getAllAnalyticByUser(String email) {
        User user = userService.getUserByEmail(email);
		List<Analytic> analyticList = repository.getListObject("analytic_comp", "user_userid", user.getUserId());
        return analyticList;
    }

    public List<HashMap<String, Object>> getPlannedWork(String email) {
        User user = userService.getUserByEmail(email);
        Analytic analytic = calculateBurndownData(user);
    
        HashMap<Date, Integer> plannedWork = analytic.getPlannedWork();
        List<HashMap<String, Object>> result = new ArrayList<>();
    
        for (Map.Entry<Date, Integer> entry : plannedWork.entrySet()) {
            HashMap<String, Object> day = new HashMap<>();
            day.put("date", entry.getKey().toString());
            day.put("totalTask", entry.getValue());
            result.add(day);
        }
    
        return result;
    }

    public List<HashMap<String, Object>> getActualWork(String email) {
        User user = userService.getUserByEmail(email);
        Analytic analytic = calculateBurndownData(user);
    
        HashMap<Date, Integer> actualWork = analytic.getActualWork();
        List<HashMap<String, Object>> result = new ArrayList<>();
    
        for (Map.Entry<Date, Integer> entry : actualWork.entrySet()) {
            HashMap<String, Object> day = new HashMap<>();
            day.put("date", entry.getKey().toString());
            day.put("totalTask", entry.getValue());
            result.add(day);
        }
    
        return result;
    }

	public Analytic calculateBurndownData(User user) {
        List<Task> taskList = taskService.getTaskListByUser(user.getUserId());
        if (taskList.isEmpty()) return null;
    
        // Tentukan startDate = earliest project start date
        Date startDate = taskList.stream()
            .map(t -> t.getProject().getCreatedAt())
            .min(Date::compareTo)
            .orElse(new Date());
    
        // Rolling weekly window: cari minggu aktif sampai semua task selesai
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startDate);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
    
        int totalTasks = taskList.size();
        HashMap<Date, Integer> plannedWork = new HashMap<>();
        HashMap<Date, Integer> actualWork = new HashMap<>();
    
        Set<Task> remainingTasks = new HashSet<>(taskList);
    
        boolean allDone = false;
        while (!allDone) {
            // hitung 7 hari dari calendar (mingguan)
            for (int i = 0; i < 7; i++) {
                Date currentDay = calendar.getTime();
    
                // Planned work = total task dikurang ideal per hari
                int ideal = (int) Math.ceil((double) totalTasks * (7 - i) / 7.0);
                plannedWork.put(currentDay, ideal);
    
                // Hitung sisa actual task
                int actual = 0;
                Iterator<Task> iterator = remainingTasks.iterator();
                while (iterator.hasNext()) {
                    Task task = iterator.next();
                    Date done = task.getCompletedAt();
                    if (done != null && !done.after(currentDay)) {
                        iterator.remove();
                    } else {
                        actual++;
                    }
                }
                actualWork.put(currentDay, actual);
    
                // Naik ke hari berikutnya
                calendar.add(Calendar.DATE, 1);
            }
    
            allDone = remainingTasks.isEmpty();
        }
    
        // Build Analytic
        Analytic analytic = analyticFactory.createAnalytic("taskline.analytic.core.AnalyticImpl", (new EDate(startDate)), (new EDate(calendar.getTime())), totalTasks, plannedWork, actualWork);
        Analytic analyticMember = analyticFactory.createAnalytic("taskline.analytic.burndownbymember.AnalyticImpl", analytic, user);
        repository.saveObject(analytic);
        repository.saveObject(analyticMember);
        return analyticMember;
    }
    
}
