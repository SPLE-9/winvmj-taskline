package taskline.task.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public interface TaskService {
	Task createTask(Map<String, Object> requestBody);
	Task createTask(Map<String, Object> requestBody, Map<String, Object> response);
	HashMap<String, Object> getTask(Map<String, Object> requestBody);
    List<HashMap<String,Object>> saveTask(Map<String, Object> requestBody);
    HashMap<String, Object> updateTask(Map<String, Object> requestBody);
    HashMap<String, Object> getTaskById(int id);
    List<HashMap<String,Object>> getAllTask(Map<String, Object> requestBody);
    List<HashMap<String,Object>> deleteTask(Map<String, Object> requestBody);
	List<HashMap<String, Object>> transformListToHashMap(List<Disbursement> List);
}
