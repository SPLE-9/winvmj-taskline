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

    public AnalyticServiceImpl(AnalyticServiceComponent record) {
        super(record);
    }

    public Analytic getAnalyticByProjectId(UUID projectId) {
		Project project = projectService.getProjectById(projectId);
		List<Analytic> analyticList = repository.getListObject("analytic_burndownbyproject", "project_projectid", project.getProjectId());
        Analytic analyticProject = analyticList.get(0);
        Analytic analytic = repository.getObject(analyticProject.getAnalyticId());
        return analytic;
    }

    public List<HashMap<String, Object>> getPlannedWork(HashMap<String, Object> requestBody) {
        String projectIdStr = (String) requestBody.get("projectId");
		UUID projectId = UUID.fromString(projectIdStr);
		Project project = projectService.getProjectById(projectId);
        Analytic analytic = calculateBurndownData(project);
    
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
        if (taskMapList.isEmpty()) return null;
        
        // Konversi HashMap ke objek Task
        List<Task> taskList = new ArrayList<>();
        for (HashMap<String, Object> taskMap : taskMapList) {
            String taskIdStr = (String) taskMap.get("taskId");
            HashMap<String, Object> taskObj = taskService.getTaskById(taskIdStr);
            
            // Ambil informasi yang diperlukan dari HashMap dan buat objek Task sederhana
            String title = (String) taskObj.get("title");
            String description = (String) taskObj.get("description");
            Date createdAt = null;
            Date completedAt = null;
            
            if (taskObj.get("createdAt") != null) {
                createdAt = new Date((Long) taskObj.get("createdAt"));
            }
            
            if (taskObj.get("completedAt") != null) {
                completedAt = new Date((Long) taskObj.get("completedAt"));
            }
            
            Task task = new TaskImpl();
            task.setTaskId(UUID.fromString(taskIdStr));
            task.setTitle(title);
            task.setDescription(description);
            task.setCreatedAt(createdAt);
            task.setCompletedAt(completedAt);
            taskList.add(task);
        }
        
        if (taskList.isEmpty()) return null;

         // Tentukan startDate = earliest task start date
         Date startDate = taskList.stream()
         .map(Task::getCreatedAt)
         .min(Date::compareTo)
         .orElse(new Date());

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
            for (int i = 0; i < 7; i++) {
                Date currentDay = calendar.getTime();

                // Planned: sisa ideal task
                int ideal = (int) Math.ceil((double) totalTasks * (7 - i) / 7.0);
                plannedWork.put(currentDay, ideal);

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

            allDone = remainingTasks.isEmpty();
        }

        // Build Analytic
        Analytic analytic = getAnalyticByProjectId(project.getProjectId());
        if (analytic == null) {
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
        } else {
            analytic.setPlannedWork(plannedWork);
            analytic.setActualWork(actualWork);
            analytic.setTotalTasks(totalTasks);
            analytic.setStartDate(startDate);
            analytic.setEndDate(calendar.getTime());
            repository.updateObject(analytic);
        }

        return repository.getObject(analytic.getAnalyticId());
    }

    
}
