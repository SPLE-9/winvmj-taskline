package taskline.task.core;
import java.util.*;

import taskline.task.core.model.Task;
import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;
//add other required packages

public abstract class TaskResourceComponent implements TaskResource {
	
	protected RepositoryUtil<Task> taskRepository;

    public TaskServiceComponent(){
        this.taskRepository = new RepositoryUtil<Task>(taskline.task.core.TaskComponent.class);
    }	
 
    public abstract HashMap<String,Object> saveTask(VMJExchange vmjExchange);
    public abstract HashMap<String, Object> updateTask(VMJExchange vmjExchange);
    public abstract HashMap<String, Object> getTaskById(VMJExchange vmjExchange);
    public abstract HashMap<String,Object> deleteTask(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> getAllTask(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> getTaskByProjectId(VMJExchange vmjExchange);
}
