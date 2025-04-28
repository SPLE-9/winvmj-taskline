package MProject.project.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="project_comp")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class ProjectComponent implements Project{
	@Id
	public UUID projectId; 
	public UUID projectId;
	public String title;
	public String description;
	public EDouble completion;
	protected String objectName = ProjectComponent.class.getName();

	public ProjectComponent() {

	} 

	public ProjectComponent(
        UUID projectId, String title, String description, EDouble completion
    ) {
        this.projectId = projectId;
        this.title = title;
        this.description = description;
        this.completion = completion;
    }

	public abstract UUID getProjectId();
	public abstract void setProjectId(UUID projectId);
	
	public abstract String getTitle();
	public abstract void setTitle(String title);
	
	public abstract String getDescription();
	public abstract void setDescription(String description);
	
	public abstract EDouble getCompletion();
	public abstract void setCompletion(EDouble completion);
	
 

	@Override
    public String toString() {
        return "{" +
            " projectId='" + getProjectId() + "'" +
            " title='" + getTitle() + "'" +
            " description='" + getDescription() + "'" +
            " completion='" + getCompletion() + "'" +
            "}";
    }
	
}
