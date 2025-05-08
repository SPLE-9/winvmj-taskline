package taskline.task.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public abstract class TaskServiceDecorator extends TaskServiceComponent{
	protected TaskServiceComponent record;

    public TaskServiceDecorator(TaskServiceComponent record) {
        this.record = record;
    }

	public TaskImpl create(Map<String, Object> requestBody){
		return record.create(requestBody);
	}

    public  create(Map<String, Object> requestBody, Map<String, Object> response){
		return record.create(requestBody, response);
	}

	public HashMap<String, Object> get(Map<String, Object> requestBody){
		return record.get(requestBody);
	}

	public List<HashMap<String,Object>> getAll(Map<String, Object> requestBody){
		return record.getAll(requestBody);
	}

    public List<HashMap<String,Object>> save(VMJExchange vmjExchange){
		return record.save(vmjExchange);
	}

    public HashMap<String, Object> update(Map<String, Object> requestBody){
		return record.update(requestBody);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<> List){
		return record.transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> delete(Map<String, Object> requestBody){
		return record.delete(requestBody);
	}

	public HashMap<String, Object> getById(int id){
        return record.getById(id);
    }

	public void getTasksByProject() {
		return record.getTasksByProject();
	}
}
