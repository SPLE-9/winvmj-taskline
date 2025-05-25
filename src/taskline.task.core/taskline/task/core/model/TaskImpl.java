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
import taskline.member.core.MemberImpl;
import taskline.project.core.ProjectImpl;
import taskline.member.core.Member;
import taskline.project.core.Project;



@Entity(name="task_impl")
@Table(name="task_impl")
public class TaskImpl extends TaskComponent {

	public TaskImpl(String title, String description, Status status, Date createdAt, Date completedAt, Member memberimpl, Project projectimpl) {
		this.taskId =  UUID.randomUUID();
		this.title = title;
		this.description = description;
		this.status = status;
		this.createdAt = createdAt;
		this.completedAt = completedAt;
		this.memberimpl = memberimpl;
		this.projectimpl = projectimpl;
	}

	public TaskImpl(String title, String description, Member memberimpl, Project projectimpl) {
		this.taskId =  UUID.randomUUID();
		this.title = title;
		this.description = description;
		this.status = Status.TODO;
		this.createdAt = new Date();
		this.completedAt = null;
		this.memberimpl = memberimpl;
		this.projectimpl = projectimpl;
	}

	public TaskImpl() {
		this.taskId = UUID.randomUUID();
		this.title = "";
		this.description = "";
		this.status = Status.TODO;
		this.createdAt = new Date();
		this.completedAt = null;
		this.memberimpl = null;
		this.projectimpl = null;
	}

	
	public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> Map = new HashMap<String,Object>();
		Map.put("taskId",getTaskId());
		Map.put("title",getTitle());
		Map.put("description",getDescription());
		Map.put("status",getStatus());
		Map.put("createdAt",getCreatedAt());
		Map.put("completedAt",getCompletedAt());
		Map.put("memberimpl",getMemberimpl());
		Map.put("projectimpl",getProjectimpl());

        return Map;
    }

}
