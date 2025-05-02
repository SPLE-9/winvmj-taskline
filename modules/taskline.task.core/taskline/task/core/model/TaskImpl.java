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


@Entity(name="_impl")
@Table(name="_impl")
public class TaskImpl extends TaskComponent {

	public TaskImpl(UUID taskId, String title, String description, status status, EDate createdAt, EDate completedAt, UserImpl userimpl, ProjectImpl projectimpl) {
		this.taskId = taskId;
		this.title = title;
		this.description = description;
		this.status = status;
		this.createdAt = createdAt;
		this.completedAt = completedAt;
		this.userimpl = userimpl;
		this.projectimpl = projectimpl;
	}

	public TaskImpl(UUID taskId, String title, String description, status status, EDate createdAt, EDate completedAt, UserImpl userimpl, ProjectImpl projectimpl) {
		this.taskId =  taskId.randomUUID();;
		this.taskId = taskId;
		this.title = title;
		this.description = description;
		this.status = status;
		this.createdAt = createdAt;
		this.completedAt = completedAt;
		this.userimpl = userimpl;
		this.projectimpl = projectimpl;
	}

	public TaskImpl() { }

	public UUID getTaskId() {
		return this.taskId;
	}

	public void setTaskId(UUID taskId) {
		this.taskId = taskId;
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
