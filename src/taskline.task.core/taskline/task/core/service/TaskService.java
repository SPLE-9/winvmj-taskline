package taskline.task.core;

import java.util.*;
import vmj.routing.route.VMJExchange;

public interface TaskService {
    HashMap<String,Object> saveTask(Map<String, Object> requestBody); 
    HashMap<String,Object> deleteTask(Map<String, Object> requestBody);
	HashMap<String, Object> updateTask(Map<String, Object> requestBody);
    List<HashMap<String,Object>> getAllTask();
    List<HashMap<String,Object>> getTaskByProjectId(String projectId);
    HashMap<String, Object> getTaskById(String taskId);
    List<Task> getTaskByMemberId(UUID memberId);
    List<HashMap<String,Object>> transformListToHashMap(List<Task> taskList);
}
