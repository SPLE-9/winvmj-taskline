package taskline.task.core;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

public abstract class TaskResourceDecorator extends TaskResourceComponent{
	protected TaskResourceComponent record;

    public TaskResourceDecorator(TaskResourceComponent record) {
        this.record = record;
    }

    public List<HashMap<String,Object>> save(VMJExchange vmjExchange){
		return record.save(vmjExchange);
	}

    public  create(VMJExchange vmjExchange){
		return record.create(vmjExchange);
	}

    public  create(VMJExchange vmjExchange, int id){
		return record.create(vmjExchange, id);
	}

    public HashMap<String, Object> update(VMJExchange vmjExchange){
		return record.update(vmjExchange);
	}

    public HashMap<String, Object> get(VMJExchange vmjExchange){
		return record.get(vmjExchange);
	}

    public List<HashMap<String,Object>> getAll(VMJExchange vmjExchange){
		return record.getAll(vmjExchange);
	}

    public List<HashMap<String,Object>> delete(VMJExchange vmjExchange){
		return record.delete(vmjExchange);
	}

	public void getTasksByProject() {
		return record.getTasksByProject();
	}
}
