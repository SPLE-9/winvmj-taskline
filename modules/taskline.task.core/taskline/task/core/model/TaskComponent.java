package taskline.task.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.CascadeType;
import javax.persistence.Table;

import taskline.member.core.MemberImpl;
import taskline.project.core.ProjectImpl;
import taskline.member.core.Member;
import taskline.project.core.Project;
import taskline.task.core.Status;

@Entity
@Table(name="task_comp")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class TaskComponent implements Task {
	@Id
	protected UUID taskId; 
	public String title;
	public String description;
	public Status status;
	public Date createdAt;
	public Date completedAt;
	@ManyToOne(targetEntity=taskline.member.core.MemberImpl.class)
	public Member memberimpl;
	@ManyToOne(targetEntity=taskline.project.core.ProjectImpl.class, cascade = CascadeType.REMOVE)
	public Project projectimpl;
	protected String objectName = TaskComponent.class.getName();

	public TaskComponent() {

	} 

	public TaskComponent(
        UUID taskId, String title, String description, Status status, Date createdAt, Date completedAt, Member memberimpl, Project projectimpl
    ) {
        this.taskId = taskId;
        this.title = title;
        this.description = description;
        this.status = status;
        this.createdAt = createdAt;
        this.completedAt = completedAt;
        this.memberimpl = memberimpl;
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
	public Date getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getCompletedAt() {
		return this.completedAt;
	}

	public void setCompletedAt(Date completedAt) {
		this.completedAt = completedAt;
	}
	public Member getMemberimpl() {
		return this.memberimpl;
	}

	public void setMemberimpl(MemberImpl memberimpl) {
		this.memberimpl = memberimpl;
	}
	public Project getProjectimpl() {
		return this.projectimpl;
	}
	public void setProjectimpl(ProjectImpl projectimpl) {
		this.projectimpl = projectimpl;
	}
	

	@Override
    public String toString() {
        return "{" +
            " taskId='" + getTaskId() + "'" +
            " title='" + getTitle() + "'" +
            " description='" + getDescription() + "'" +
            " status='" + getStatus() + "'" +
            " createdAt='" + getCreatedAt() + "'" +
            " completedAt='" + getCompletedAt() + "'" +
            " memberimpl='" + getMemberimpl() + "'" +
            " projectimpl='" + getProjectimpl() + "'" +
            "}";
    }
	
}
