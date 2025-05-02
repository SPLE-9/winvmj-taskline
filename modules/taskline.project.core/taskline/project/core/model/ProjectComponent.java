package taskline.project.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="project_comp", uniqueConstraints = @UniqueConstraint(columnNames = { "title" }))
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class ProjectComponent implements Project{
	@Id
	public UUID projectId;
	public String title;
	public String description;
	public double completion;
	protected String objectName = ProjectComponent.class.getName();

	public ProjectComponent() {

	} 

	public ProjectComponent(UUID projectId, String title, String description, double completion) {
        this.projectId = projectId;
        this.title = title;
        this.description = description;
        this.completion = completion;
    }

	public UUID getProjectId() {
		return this.projectId;
	}

	public void setProjectId(UUID projectId) {
		this.projectId = projectId;
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
	
	public double getCompletion() {
		return this.completion;
	}

	public void setCompletion(double completion) {
		this.completion = completion;
	}
	
 

	@Override
    public String toString() {
        return "{" +
            " projectId='" + getProjectId() + "'" +
            " title='" + getTitle() + "'" +
            " description='" + getDescription() + "'" +
            " completion='" + getCompletion() + "'" +
            "}";
    }

	public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> projectMap = new HashMap<String,Object>();
		projectMap.put("projectId", getProjectId());
		projectMap.put("title", getTitle());
		projectMap.put("description", getDescription());
		projectMap.put("completion", getCompletion());

        return projectMap;
    }
	
}
