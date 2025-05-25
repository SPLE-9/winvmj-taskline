package taskline.analytic.burndownbyproject;

import java.util.*;

import vmj.routing.route.VMJExchange;

import taskline.analytic.AnalyticFactory;
import taskline.analytic.core.*;
import taskline.project.core.*;
import taskline.task.core.*;
import taskline.task.core.TaskImpl;
public class AnalyticServiceImpl extends AnalyticServiceDecorator {
    private AnalyticFactory analyticFactory = new AnalyticFactory();
    private ProjectService projectService = new ProjectServiceImpl();
    private TaskService taskService = new TaskServiceImpl();

    // Konstanta untuk mencegah loop tak terbatas
    private static final int MAX_ITERATIONS = 52; // Maksimum 52 minggu (1 tahun)

    public AnalyticServiceImpl(AnalyticServiceComponent record) {
        super(record);
    }

    public Analytic getAnalyticByProjectId(UUID projectId) {
        Project project = projectService.getProjectById(projectId);
        List<Analytic> analyticList = repository.getListObject("analytic_burndownbyproject", "project_projectid", project.getProjectId());
        
        // Periksa apakah daftar kosong dan kembalikan null jika ya
        if (analyticList == null || analyticList.isEmpty()) {
            return null;
        }
        
        Analytic analyticProject = analyticList.get(0);
        Analytic analytic = repository.getObject(analyticProject.getAnalyticId());
        return analytic;
    }

    public List<HashMap<String, Object>> getPlannedWork(HashMap<String, Object> requestBody) {
        String projectIdStr = (String) requestBody.get("projectId");
		UUID projectId = UUID.fromString(projectIdStr);
		Project project = projectService.getProjectById(projectId);
        Analytic analytic = calculateBurndownData(project);
        
        // Cek apakah analytic null dan kembalikan list kosong jika ya
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
        String projectIdStr = (String) requestBody.get("projectId");
		UUID projectId = UUID.fromString(projectIdStr);
		Project project = projectService.getProjectById(projectId);
        Analytic analytic = calculateBurndownData(project);
        
        // Cek apakah analytic null dan kembalikan list kosong jika ya
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

    public Analytic calculateBurndownData(Project project) {
        List<HashMap<String, Object>> taskMapList = taskService.getTaskByProjectId(project.getProjectId().toString());
        if (taskMapList == null || taskMapList.isEmpty()) return null;
        
        // Konversi HashMap ke objek Task
        List<Task> taskList = new ArrayList<>();
        for (HashMap<String, Object> taskMap : taskMapList) {
            try {
                UUID taskIdStr = (UUID) taskMap.get("taskId");
                HashMap<String, Object> taskObj = taskService.getTaskById(taskIdStr.toString());
                
                // Ambil informasi yang diperlukan dari HashMap dan buat objek Task sederhana
                String title = (String) taskObj.get("title");
                String description = (String) taskObj.get("description");
                Date createdAt = null;
                Date completedAt = null;
                
                // Tangani berbagai tipe data untuk tanggal
                if (taskObj.get("createdAt") != null) {
                    Object createdAtObj = taskObj.get("createdAt");
                    if (createdAtObj instanceof Long) {
                        createdAt = new Date((Long) createdAtObj);
                    } else if (createdAtObj instanceof Date) {
                        createdAt = (Date) createdAtObj;
                    } else {
                        // Untuk tipe lain (termasuk Timestamp), coba konversi umum
                        try {
                            // Jika objek punya metode getTime(), gunakan reflection untuk memanggilnya
                            try {
                                java.lang.reflect.Method getTimeMethod = createdAtObj.getClass().getMethod("getTime");
                                Object timeValue = getTimeMethod.invoke(createdAtObj);
                                if (timeValue instanceof Long) {
                                    createdAt = new Date((Long) timeValue);
                                }
                            } catch (Exception reflectionEx) {
                                // Jika reflection gagal, coba parse dari string
                                createdAt = new Date(Long.parseLong(createdAtObj.toString()));
                            }
                        } catch (Exception e) {
                            System.err.println("Cannot convert createdAt to Date: " + e.getMessage());
                        }
                    }
                }
                
                if (taskObj.get("completedAt") != null) {
                    Object completedAtObj = taskObj.get("completedAt");
                    if (completedAtObj instanceof Long) {
                        completedAt = new Date((Long) completedAtObj);
                    } else if (completedAtObj instanceof Date) {
                        completedAt = (Date) completedAtObj;
                    } else {
                        // Untuk tipe lain (termasuk Timestamp), coba konversi umum
                        try {
                            // Jika objek punya metode getTime(), gunakan reflection untuk memanggilnya
                            try {
                                java.lang.reflect.Method getTimeMethod = completedAtObj.getClass().getMethod("getTime");
                                Object timeValue = getTimeMethod.invoke(completedAtObj);
                                if (timeValue instanceof Long) {
                                    completedAt = new Date((Long) timeValue);
                                }
                            } catch (Exception reflectionEx) {
                                // Jika reflection gagal, coba parse dari string
                                completedAt = new Date(Long.parseLong(completedAtObj.toString()));
                            }
                        } catch (Exception e) {
                            System.err.println("Cannot convert completedAt to Date: " + e.getMessage());
                        }
                    }
                }
                
                Task task = new TaskImpl();
                task.setTaskId(taskIdStr);
                task.setTitle(title);
                task.setDescription(description);
                task.setCreatedAt(createdAt);
                task.setCompletedAt(completedAt);
                taskList.add(task);
            } catch (Exception e) {
                System.err.println("Error processing task: " + e.getMessage());
                // Lanjutkan ke task berikutnya
            }
        }
        
        if (taskList.isEmpty()) return null;

        // Tentukan startDate = earliest task start date
        Date startDate = taskList.stream()
            .map(Task::getCreatedAt)
            .filter(date -> date != null)
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
        
        // Hitung 7 hari dari calendar (mingguan)
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

            // Actual: hitung task yang belum selesai sampai hari itu
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

            calendar.add(Calendar.DATE, 1);
        }
        
        try {
            // Build Analytic
            Analytic analytic = getAnalyticByProjectId(project.getProjectId());
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
        
                    Analytic analyticProject = analyticFactory.createAnalytic(
                        "taskline.analytic.burndownbyproject.AnalyticImpl",
                        analytic,
                        project
                    );
        
                    repository.saveObject(analytic);
                    repository.saveObject(analyticProject);
                    
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
            System.err.println("Error creating/updating project analytic: " + e.getMessage());
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
