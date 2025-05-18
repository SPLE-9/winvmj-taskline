package taskline.task.core;
import java.util.*;

import taskline.task.core.Task;
import vmj.routing.route.VMJExchange;

public abstract class TaskServiceDecorator extends TaskServiceComponent{
	protected TaskServiceComponent record;

    public TaskServiceDecorator(TaskServiceComponent record) {
        this.record = record;
    }

	public HashMap<String, Object> getTaskById(String taskId){
		return record.getTaskById(taskId);
	}

	public List<HashMap<String,Object>> getAllTask(){
		return record.getAllTask();
	}

    public HashMap<String,Object> saveTask(Map<String, Object> requestBody){
		return record.saveTask(requestBody);
	}

    public HashMap<String, Object> updateTask(Map<String, Object> requestBody){
		return record.updateTask(requestBody);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<Task> taskList){
		return record.transformListToHashMap(taskList);
	}

    public HashMap<String,Object> deleteTask(Map<String, Object> requestBody){
		return record.deleteTask(requestBody);
	}

	public List<HashMap<String, Object>> getTaskByProjectId(String projectId){
        return record.getTaskByProjectId(projectId);
    }

	public List<Task> getTaskByMemberId(UUID memberId){
        return record.getTaskByMemberId(memberId);
    }

}
