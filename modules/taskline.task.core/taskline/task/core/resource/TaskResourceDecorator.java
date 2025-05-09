package taskline.task.core;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

public abstract class TaskResourceDecorator extends TaskResourceComponent{
	protected TaskResourceComponent record;

    public TaskResourceDecorator(TaskResourceComponent record) {
        this.record = record;
    }

    public HashMap<String,Object> saveTask(VMJExchange vmjExchange) {
		return record.saveTask(vmjExchange);
	}

    public HashMap<String, Object> updateTask(VMJExchange vmjExchange) {
		return record.updateTask(vmjExchange);
	}

    public HashMap<String, Object> getTaskById(VMJExchange vmjExchange) {
		return record.getTaskById(vmjExchange);
	}

    public HashMap<String,Object> deleteTask(VMJExchange vmjExchange) {
		return record.deleteTask(vmjExchange);
	}

    public List<HashMap<String,Object>> getAllTask(VMJExchange vmjExchange) {
		return record.getAllTask(vmjExchange);
	}

    public List<HashMap<String,Object>> getTaskByProjectId(VMJExchange vmjExchange) {
		return record.getAllTask(vmjExchange);
	}
}
