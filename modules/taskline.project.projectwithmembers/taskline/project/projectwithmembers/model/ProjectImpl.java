package taskline.project.projectwithmembers;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;

import taskline.project.core.ProjectDecorator;
import taskline.project.core.Project;
import taskline.project.core.ProjectComponent;

@Entity(name="project_projectwithmembers")
@Table(name="project_projectwithmembers")
public class ProjectImpl extends ProjectDecorator {

	public ProjectImpl(
        super();
        this.objectName = ProjectImpl.class.getName();
    }
    
    public ProjectImpl(UserImpl userimpl) {
    	super();
		this.objectName = ProjectImpl.class.getName();
    }
	
	public ProjectImpl(ProjectComponent record, UserImpl userimpl) {
		super(record);
		this.objectName = ProjectImpl.class.getName();
	}


	public void getProjectsByUser(UUID userId) {
		// TODO: implement this method
	}

}
