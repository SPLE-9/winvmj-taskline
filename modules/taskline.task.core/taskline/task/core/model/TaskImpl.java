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

	public TaskImpl(String title, String description, ProjectImpl projectimpl) {
		this.taskId =  UUID.randomUUID();
		this.title = title;
		this.description = description;
		this.status = Status.TODO;
		this.createdAt = new EDate();
		this.completedAt = null;
		this.userimpl = null;
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
