package taskline.analytic.burndownbymember;

import java.util.*;

import vmj.routing.route.VMJExchange;

import taskline.analytic.AnalyticFactory;
import taskline.analytic.core.*;
import taskline.task.core.*;
import taskline.member.core.*;

public class AnalyticServiceImpl extends AnalyticServiceDecorator {
    private AnalyticFactory analyticFactory = new AnalyticFactory();
    private MemberService memberService = new MemberServiceImpl();
    private TaskService taskService = new TaskServiceImpl();

    public AnalyticServiceImpl(AnalyticServiceComponent record) {
        super(record);
    }

    public Analytic getAnalyticByMember(String email) {
        Member member = memberService.getMemberByEmail(email);
		List<Analytic> analyticList = repository.getListObject("analytic_burndownbymember", "member_memberid", member.getMemberId());
        Analytic analyticMember = analyticList.get(0);
        Analytic analytic = repository.getObject(analyticMember.getAnalyticId());
        return analytic;
    }

    public List<HashMap<String, Object>> getPlannedWork(HashMap<String, Object> requestBody) {
        String email = (String) requestBody.get("email");
        Member member = memberService.getMemberByEmail(email);
        Analytic analytic = calculateBurndownData(member);
    
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

    public List<HashMap<String, Object>> getActualWork(HashMap<String, Object> requestBody) {
        String email = (String) requestBody.get("email");
        Member member = memberService.getMemberByEmail(email);
        Analytic analytic = calculateBurndownData(member);
    
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

	public Analytic calculateBurndownData(Member member) {
        List<Task> taskList = taskService.getTaskByMemberId(member.getMemberId());
        if (taskList.isEmpty()) return null;
    
        // Tentukan startDate = earliest task start date
        Date startDate = taskList.stream()
            .map(Task::getCreatedAt)
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
        Analytic analytic = getAnalyticByMember(member.getEmail());
        if (analytic == null) {
            analytic = analyticFactory.createAnalytic("taskline.analytic.core.AnalyticImpl", startDate, calendar.getTime(), totalTasks, plannedWork, actualWork);
            Analytic analyticMember = analyticFactory.createAnalytic("taskline.analytic.burndownbymember.AnalyticImpl", analytic, member);
            repository.saveObject(analytic);
            repository.saveObject(analyticMember);
        } else {
            analytic.setPlannedWork(plannedWork);
            analytic.setActualWork(actualWork);
            analytic.setTotalTasks(totalTasks);
            analytic.setStartDate(startDate);
            analytic.setEndDate(calendar.getTime());
            repository.updateObject(analytic);
        }
        analytic = repository.getObject(analytic.getAnalyticId());
        return analytic;
    }
    
}
