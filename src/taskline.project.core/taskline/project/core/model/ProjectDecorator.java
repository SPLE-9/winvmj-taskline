package taskline.project.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.OneToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.CascadeType;
//add other required packages

@MappedSuperclass
public abstract class ProjectDecorator extends ProjectComponent{
    @OneToOne(cascade=CascadeType.ALL)
	protected ProjectComponent record;

	public ProjectDecorator (ProjectComponent record) {
		this.record = record;
	}

	public ProjectDecorator (UUID projectId, ProjectComponent record) {
		this.projectId =  projectId;
		this.record = record;
	}

	public ProjectDecorator() {
		super();
		this.projectId =  UUID.randomUUID();
	}

	public UUID getProjectId() {
		return this.record.getProjectId();
	}

	public void setProjectId(UUID projectId) {
		this.record.setProjectId(projectId);
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
	
	public double getCompletion() {
		return this.record.getCompletion();
	}

	public void setCompletion(double completion) {
		this.record.setCompletion(completion);
	}


	public HashMap<String, Object> toHashMap() {
        return this.record.toHashMap();
    }

}
