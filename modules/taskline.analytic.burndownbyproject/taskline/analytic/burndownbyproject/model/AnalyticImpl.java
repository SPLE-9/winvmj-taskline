package taskline.analytic.burndownbyproject;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;

import taskline.analytic.core.AnalyticDecorator;
import taskline.analytic.core.Analytic;
import taskline.analytic.core.AnalyticComponent;

import taskline.project.core.*;

@Entity(name="analytic_burndownbyproject")
@Table(name="analytic_burndownbyproject")
public class AnalyticImpl extends AnalyticDecorator {
	@OneToOne(targetEntity = taskline.project.core.ProjectComponent.class)
	private Project project;

	public AnalyticImpl(){
        super();
        this.objectName = AnalyticImpl.class.getName();
    }
    
    public AnalyticImpl(Project project) {
    	super();
		this.project = project;
		this.objectName = AnalyticImpl.class.getName();
    }
	
	public AnalyticImpl(AnalyticComponent record, Project project) {
		super(record);
		this.project = project;
		this.objectName = AnalyticImpl.class.getName();
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	@Override
	public String toString() {
		return "{"
			+ "id=" + getId()
			+ ", record=" + getRecord()
			+ ", project=" + getProject()
			+ "}";
	}

	public HashMap<String, Object> toHashMap() {
		HashMap<String, Object> map = record.toHashMap();
		map.put("project", this.getProject());
		return map;
	}
}
