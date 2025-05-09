package taskline.task.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.OneToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.CascadeType;
import taskline.user.core.UserImpl;
import taskline.project.core.ProjectImpl;
import taskline.user.core.User;
import taskline.project.core.Project;
//add other required packages

@MappedSuperclass
public abstract class TaskDecorator extends TaskComponent{
    @OneToOne(cascade=CascadeType.ALL)
	protected TaskComponent record;

	public TaskDecorator() {
		super();
		this.taskId = UUID.randomUUID();
	}
	
	public TaskDecorator(TaskComponent record) {
		this.taskId = UUID.randomUUID();
		this.record = record;
	}

	public TaskDecorator (UUID taskId, TaskComponent record) {
		this.taskId = taskId;
		this.record = record;
	}
	


	public UUID getTaskId() {
		return this.record.getTaskId();
	}

	public void setTaskId(UUID taskId) {
		this.record.setTaskId(taskId);
	}

	public String getTitle() {
		return this.record.getTitle();
	}
	public void setTitle(String title) {
		this.record.setTitle(title);
	}

	public String getDescription() {
		return this.record.getDescription();
	}

	public void setDescription(String description) {
		this.record.setDescription(description);
	}

	public Status getStatus() {
		return this.record.getStatus();
	}

	public void setStatus(Status status) {
		this.record.setStatus(status);
	}
	public Date getCreatedAt() {
		return this.record.getCreatedAt();
	}

	public void setCreatedAt(Date createdAt) {
		this.record.setCreatedAt(createdAt);
	}
	public Date getCompletedAt() {
		return this.record.getCompletedAt();
	}

	public void setCompletedAt(Date completedAt) {
		this.record.setCompletedAt(completedAt);
	}
	public User getUserimpl() {
		return this.record.getUserimpl();
	}

	public void setUserimpl(UserImpl userimpl) {
		this.record.setUserimpl(userimpl);
	}
	public Project getProjectimpl() {
		return this.record.getProjectimpl();
	}
	public void setProjectimpl(ProjectImpl projectimpl) {
		this.record.setProjectimpl(projectimpl);
	}

	public HashMap<String, Object> toHashMap() {
        return this.record.toHashMap();
    }

}
