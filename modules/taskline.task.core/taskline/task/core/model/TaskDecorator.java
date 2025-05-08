package taskline.task.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.OneToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.CascadeType;
//add other required packages

@MappedSuperclass
public abstract class TaskDecorator extends TaskComponent{
    @OneToOne(cascade=CascadeType.ALL)
	protected TaskComponent record;

	public TaskDecorator () {
		super();
		this.record = record;
		this.taskId =  taskId.randomUUID();
	}
	
	public TaskDecorator (TaskComponent record) {
		this.taskId =  taskId.randomUUID();
		this.record = record;
	}

	public TaskDecorator (UUID taskId, TaskComponent record) {
		this.taskId =  taskId;
		this.record = record;
	}
	
	public TaskDecorator (TaskComponent record, String objectName) {
		this.taskId =  taskId.randomUUID();
		this.record = record;	
		this.objectName=objectName;
	}


	public UUID getTaskId() {
		return record.getTaskId();
	}
	public void setTaskId(UUID taskId) {
		record.setTaskId(taskId);
	}

	public void getTasksByProject() {
		return record.getTasksByProject();
	}

	public HashMap<String, Object> toHashMap() {
        return this.record.toHashMap();
    }

}
