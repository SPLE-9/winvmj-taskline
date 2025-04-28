package taskline.task.taskwithcomment;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;

import taskline.task.core.TaskDecorator;
import taskline.task.core.Task;
import taskline.task.core.TaskComponent;

@Entity(name="task_taskwithcomment")
@Table(name="task_taskwithcomment")
public class TaskImpl extends TaskDecorator {

	public TaskImpl(
        super();
        this.objectName = TaskImpl.class.getName();
    }
    
    public TaskImpl() {
    	super();
		this.objectName = TaskImpl.class.getName();
    }
	
	public TaskImpl(TaskComponent record, ) {
		super(record);
		this.objectName = TaskImpl.class.getName();
	}


	public void getTaskComments() {
		// TODO: implement this method
	}

}
