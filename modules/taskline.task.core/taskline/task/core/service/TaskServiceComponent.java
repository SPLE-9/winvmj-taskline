package taskline.task.core;
import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;
import taskline.task.core.Task;
//add other required packages

public abstract class TaskServiceComponent implements TaskService {
	protected RepositoryUtil<Task> taskRepository;

    public TaskServiceComponent(){
        this.taskRepository = new RepositoryUtil<Task>(taskline.task.core.TaskComponent.class);
    }	

    public abstract HashMap<String,Object> saveTask(Map<String, Object> requestBody); 
    public abstract HashMap<String,Object> deleteTask(Map<String, Object> requestBody);
	public abstract HashMap<String, Object> updateTask(Map<String, Object> requestBody);
    public abstract List<HashMap<String,Object>> getAllTask();
    public abstract List<HashMap<String,Object>> getTaskByProjectId(String projectId);
    public abstract HashMap<String, Object> getTaskById(String taskId);
    public abstract List<Task> getTaskByMemberId(UUID memberId);
    public abstract List<HashMap<String,Object>> transformListToHashMap(List<Task> taskList);
    
}
