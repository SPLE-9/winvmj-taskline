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
    
    // Konstanta untuk mencegah loop tak terbatas
    private static final int MAX_ITERATIONS = 52; // Maksimum 52 minggu (1 tahun)

    public AnalyticServiceImpl(AnalyticServiceComponent record) {
        super(record);
    }

    public Analytic getAnalyticByMember(String email) {
        Member member = memberService.getMemberByEmail(email);
		List<Analytic> analyticList = repository.getListObject("analytic_burndownbymember", "member_memberid", member.getMemberId());
        if (analyticList == null || analyticList.isEmpty()) {
            return null;
        }
        Analytic analyticMember = analyticList.get(0);
        Analytic analytic = repository.getObject(analyticMember.getAnalyticId());
        return analytic;
    }

    public List<HashMap<String, Object>> getPlannedWork(HashMap<String, Object> requestBody) {
        String email = (String) requestBody.get("email");
        Member member = memberService.getMemberByEmail(email);
        Analytic analytic = calculateBurndownData(member);
        
        if (analytic == null) {
            return new ArrayList<>();
        }
    
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
        
        if (analytic == null) {
            return new ArrayList<>();
        }
    
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
        if (taskList == null || taskList.isEmpty()) return null;
    
        // Tentukan startDate = earliest task start date
        Date startDate = taskList.stream()
            .map(Task::getCreatedAt)
            .min(Date::compareTo)
            .orElse(new Date());

        // Tentukan endDate sebagai completedAt terlama atau hari ini jika ada yang belum selesai
        Date endDate = new Date(); // Default hari ini
        for (Task task : taskList) {
            Date completedAt = task.getCompletedAt();
            if (completedAt != null && completedAt.after(endDate)) {
                endDate = completedAt;
            }
        }
        
        // Pastikan endDate paling tidak 7 hari (1 minggu) dari startDate untuk burndown
        Calendar minEndCal = Calendar.getInstance();
        minEndCal.setTime(startDate);
        minEndCal.add(Calendar.DATE, 7);
        if (endDate.before(minEndCal.getTime())) {
            endDate = minEndCal.getTime();
        }
        
        // Batasi rentang waktu ke maksimum 1 tahun untuk mencegah OOM
        Calendar maxEndCal = Calendar.getInstance();
        maxEndCal.setTime(startDate);
        maxEndCal.add(Calendar.YEAR, 1);
        if (endDate.after(maxEndCal.getTime())) {
            endDate = maxEndCal.getTime();
        }

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
        int iterations = 0;
        Date currentDay;
        
        // Tetapkan durasi burndown menjadi tepat 7 hari (1 minggu)
        int totalDays = 7;
        
        System.out.println("DEBUG: Total hari periode burndown: " + totalDays);
        
        // Tetapkan titik awal dan akhir ideal burndown
        int startTasks = totalTasks;
        int endTasks = 0;
        
        // Total hari pada periode burndown
        int elapsedDays = 0;
        
        // Loop selama 7 hari saja (1 minggu)
        // Hanya akan melakukan 1 iterasi karena kita hanya perlu 7 hari
        iterations = 1;
        
        // hitung 7 hari dari calendar (mingguan)
        for (int i = 0; i < 7; i++) {
            currentDay = calendar.getTime();
            
            // Jika melewati endDate, hentikan loop
            if (currentDay.after(endDate)) {
                allDone = true;
                break;
            }

            // Planned work: Ideal burndown menurun linear dari totalTasks ke 0
            elapsedDays++;
            
            // Debuging
            System.out.println("DEBUG: elapsedDays=" + elapsedDays + ", totalDays=" + totalDays + 
                ", totalTasks=" + totalTasks + ", startDate=" + startDate + ", endDate=" + endDate);
            
            // Perhitungan ideal burndown yang lebih konsisten: 
            // Linear dari startTasks ke endTasks selama totalDays
            double progress = Math.min((double) elapsedDays / totalDays, 1.0);
            int idealRemaining = startTasks - (int) Math.round(progress * (startTasks - endTasks));
            
            // Pastikan nilai tidak pernah negatif
            idealRemaining = Math.max(0, idealRemaining);
            
            System.out.println("DEBUG: progress=" + progress + ", idealRemaining=" + idealRemaining);
            
            plannedWork.put(currentDay, idealRemaining);

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
    
        // Build Analytic
        try {
            Analytic analytic = getAnalyticByMember(member.getEmail());
            if (analytic == null) {
                try {
                    analytic = analyticFactory.createAnalytic(
                        "taskline.analytic.core.AnalyticImpl", 
                        startDate, 
                        calendar.getTime(), 
                        totalTasks, 
                        plannedWork, 
                        actualWork
                    );
                    
                    Analytic analyticMember = analyticFactory.createAnalytic(
                        "taskline.analytic.burndownbymember.AnalyticImpl", 
                        analytic, 
                        member
                    );
                    
                    repository.saveObject(analytic);
                    repository.saveObject(analyticMember);
                    
                    // Verifikasi bahwa analytic benar-benar disimpan
                    UUID analyticId = analytic.getAnalyticId();
                    if (analyticId != null) {
                        return repository.getObject(analyticId);
                    } else {
                        System.err.println("Error: Analytic ID is null after saving");
                        return analytic; // Kembalikan objek yang baru dibuat
                    }
                } catch (Exception innerEx) {
                    System.err.println("Error creating new analytic: " + innerEx.getMessage());
                    // Jika gagal membuat, buat objek sederhana untuk dikembalikan
                    Analytic simpleAnalytic = analyticFactory.createAnalytic(
                        "taskline.analytic.core.AnalyticImpl",
                        startDate, 
                        calendar.getTime(),
                        totalTasks,
                        plannedWork,
                        actualWork
                    );
                    return simpleAnalytic; // Kembalikan objek tanpa menyimpan
                }
            } else {
                try {
                    analytic.setPlannedWork(plannedWork);
                    analytic.setActualWork(actualWork);
                    analytic.setTotalTasks(totalTasks);
                    analytic.setStartDate(startDate);
                    analytic.setEndDate(calendar.getTime());
                    repository.updateObject(analytic);
                    return analytic; // Kembalikan objek yang telah diperbarui
                } catch (Exception updateEx) {
                    System.err.println("Error updating analytic: " + updateEx.getMessage());
                    // Tetap kembalikan objek meskipun gagal diperbarui
                    return analytic;
                }
            }
        } catch (Exception e) {
            // Log error dan buat objek sederhana untuk dikembalikan
            System.err.println("Error creating/updating analytic: " + e.getMessage());
            // Buat objek Analytic baru yang tidak perlu disimpan ke repository
            try {
                Analytic simpleAnalytic = analyticFactory.createAnalytic(
                    "taskline.analytic.core.AnalyticImpl",
                    startDate, 
                    calendar.getTime(),
                    totalTasks,
                    plannedWork,
                    actualWork
                );
                return simpleAnalytic;
            } catch (Exception finalEx) {
                System.err.println("Final fallback failed: " + finalEx.getMessage());
                return null;
            }
        }
    }
}
