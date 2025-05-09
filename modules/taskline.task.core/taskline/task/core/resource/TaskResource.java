package taskline.task.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public interface TaskResource {
    HashMap<String,Object> saveTask(VMJExchange vmjExchange);
    HashMap<String, Object> updateTask(VMJExchange vmjExchange);
    HashMap<String, Object> getTaskById(VMJExchange vmjExchange);
    HashMap<String,Object> deleteTask(VMJExchange vmjExchange);
    List<HashMap<String,Object>> getAllTask(VMJExchange vmjExchange);
    List<HashMap<String,Object>> getTaskByProjectId(VMJExchange vmjExchange);

}
