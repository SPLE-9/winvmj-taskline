package taskline.analytic.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.OneToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.CascadeType;
//add other required packages

@MappedSuperclass
public abstract class AnalyticDecorator extends AnalyticComponent{
    @OneToOne(cascade=CascadeType.ALL)
	protected AnalyticComponent record;

	public AnalyticDecorator() {
		super();
		this.record = record;
		this.analyticId =  analyticId.randomUUID();
	}

	public AnalyticDecorator (AnalyticComponent record) {
		this.analyticId =  analyticId.randomUUID();
		this.record = record;
	}

	public AnalyticDecorator (UUID analyticId, AnalyticComponent record) {
		this.analyticId =  analyticId;
		this.record = record;
	}
	
	public AnalyticDecorator (AnalyticComponent record, String objectName) {
		this.analyticId =  analyticId.randomUUID();
		this.record = record;	
		this.objectName=objectName;
	}

	public AnalyticComponent getRecord() {
		return this.record;
	}

	public void setRecord(AnalyticComponent record) {
		this.record = record;
	}
	public UUID getAnalyticId() {
		return this.analyticId;
	}
	public void setAnalyticId(UUID analyticId) {
		this.analyticId = analyticId;
	}
	public Date getStartDate() {
		return record.getStartDate();
	}
	public void setStartDate(Date startDate) {
		record.setStartDate(startDate);
	}
	public Date getEndDate() {
		return record.getEndDate();
	}
	public void setEndDate(Date endDate) {
		record.setEndDate(endDate);
	}
	public int getTotalTasks() {
		return record.getTotalTasks();
	}
	public void setTotalTasks(int totalTasks) {
		record.setTotalTasks(totalTasks);
	}
	public HashMap<Date, Integer> getPlannedWork() {
		return record.getPlannedWork();
	}
	public void setPlannedWork(HashMap<Date, Integer> plannedWork) {
		record.setPlannedWork(plannedWork);
	}
	public HashMap<Date, Integer> getActualWork() {
		return record.getActualWork();
	}
	public void setActualWork(HashMap<Date, Integer> actualWork) {
		record.setActualWork(actualWork);
	}

	public HashMap<String, Object> toHashMap() {
        return this.record.toHashMap();
    }

}
