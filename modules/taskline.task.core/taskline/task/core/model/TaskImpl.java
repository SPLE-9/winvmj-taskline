package taskline.task.core;

import java.lang.Math;
import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import taskline.task.core.Status;



@Entity(name="task_impl")
@Table(name="task_impl")
public class TaskImpl extends TaskComponent {

	public TaskImpl(String title, String description, Status status, EDate createdAt, EDate completedAt, UserImpl userimpl, ProjectImpl projectimpl) {
		this.taskId =  UUID.randomUUID();;
		this.title = title;
		this.description = description;
		this.status = status;
		this.createdAt = createdAt;
		this.completedAt = completedAt;
		this.userimpl = userimpl;
		this.projectimpl = projectimpl;
	}


	public UUID getTaskId() {
		return this.taskId;
	}

	public void setTaskId(UUID taskId) {
		this.taskId = taskId;
	}

	public String getTitle() {
		return this.title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Status getStatus() {
		return this.status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	public EDate getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(EDate createdAt) {
		this.createdAt = createdAt;
	}
	public EDate getCompletedAt() {
		return this.completedAt;
	}

	public void setCompletedAt(EDate completedAt) {
		this.completedAt = completedAt;
	}
	public UserImpl getUserimpl() {
		return this.userimpl;
	}

	public void setUserimpl(UserImpl userimpl) {
		this.userimpl = userimpl;
	}
	public ProjectImpl getProjectimpl() {
		return this.projectimpl;
	}
	public void setProjectimpl(ProjectImpl projectimpl) {
		this.projectimpl = projectimpl;
	}
	
	public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> Map = new HashMap<String,Object>();
		Map.put("taskId",getTaskId());
		Map.put("title",getTitle());
		Map.put("description",getDescription());
		Map.put("status",getStatus());
		Map.put("createdAt",getCreatedAt());
		Map.put("completedAt",getCompletedAt());
		Map.put("userimpl",getUserimpl());
		Map.put("projectimpl",getProjectimpl());

        return Map;
    }

}
