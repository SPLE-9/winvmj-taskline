package MProject.project.core;

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

	public ProjectDecorator () {
		super();
		this.record = record;
		this.projectId =  projectId.randomUUID();
		
	public ProjectDecorator (ProjectComponent record) {
		this.projectId =  projectId.randomUUID();
		this.record = record;
	}

	public ProjectDecorator (UUID projectId, ProjectComponent record) {
		this.projectId =  projectId;
		this.record = record;
	}
	
	public ProjectDecorator (ProjectComponent record, String objectName) {
		this.projectId =  projectId.randomUUID();
		this.record = record;	
		this.objectName=objectName;
	}

	public ProjectDecorator() { }



	public HashMap<String, Object> toHashMap() {
        return this.record.toHashMap();
    }

}
