package taskline.task.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="_comp")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class TaskComponent implements {
	@Id
	protected UUID taskId; 
	protected UUID taskId;
	public String title;
	public String description;
	public status status;
	public EDate createdAt;
	public EDate completedAt;
	@ManyToOne(targetEntity=taskline.user.core.UserComponent.class)
	public User userimpl;
	@ManyToOne(targetEntity=taskline.project.core.ProjectComponent.class)
	public Project projectimpl;
	protected String objectName = TaskComponent.class.getName();

	public TaskComponent() {

	} 

	public TaskComponent(
        UUID taskId, String title, String description, status status, EDate createdAt, EDate completedAt, UserImpl userimpl, ProjectImpl projectimpl
    ) {
        this.taskId = taskId;
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
	public abstract String getTitle();
	public abstract void setTitle(String title);
	
	public abstract String getDescription();
	public abstract void setDescription(String description);
	
	public abstract status getStatus();
	public abstract void setStatus(status status);
	
	public abstract EDate getCreatedAt();
	public abstract void setCreatedAt(EDate createdAt);
	
	public abstract EDate getCompletedAt();
	public abstract void setCompletedAt(EDate completedAt);
	
	public abstract UserImpl getUserimpl();
	public abstract void setUserimpl(UserImpl userimpl);
	
	public abstract ProjectImpl getProjectimpl();
	public abstract void setProjectimpl(ProjectImpl projectimpl);
	
 
	public abstract void getTasksByProject();

	@Override
    public String toString() {
        return "{" +
            " taskId='" + getTaskId() + "'" +
            " title='" + getTitle() + "'" +
            " description='" + getDescription() + "'" +
            " status='" + getStatus() + "'" +
            " createdAt='" + getCreatedAt() + "'" +
            " completedAt='" + getCompletedAt() + "'" +
            " userimpl='" + getUserimpl() + "'" +
            " projectimpl='" + getProjectimpl() + "'" +
            "}";
    }
	
}
