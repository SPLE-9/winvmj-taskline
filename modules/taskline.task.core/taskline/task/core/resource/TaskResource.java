package taskline.task.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public interface TaskResource {
    List<HashMap<String,Object>> saveTask(VMJExchange vmjExchange);
    HashMap<String, Object> updateTask(VMJExchange vmjExchange);
    HashMap<String, Object> getTask(VMJExchange vmjExchange);
    List<HashMap<String,Object>> getAllTask(VMJExchange vmjExchange);
    List<HashMap<String,Object>> deleteTask(VMJExchange vmjExchange);
	HashMap<String, Object> createTask(VMJExchange vmjExhange);
}
