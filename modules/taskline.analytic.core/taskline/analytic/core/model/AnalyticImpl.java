package taskline.analytic.core;

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


@Entity(name="analytic_impl")
@Table(name="analytic_impl")
public class AnalyticImpl extends AnalyticComponent {

	public AnalyticImpl(UUID analyticId, EDate startDate, EDate endDate, int totalTasks, EMap plannedWork, EMap actualWork) {
		this.analyticId = analyticId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.totalTasks = totalTasks;
		this.plannedWork = plannedWork;
		this.actualWork = actualWork;
	}

	public AnalyticImpl(UUID analyticId, EDate startDate, EDate endDate, int totalTasks, EMap plannedWork, EMap actualWork) {
		this.analyticId =  analyticId.randomUUID();;
		this.analyticId = analyticId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.totalTasks = totalTasks;
		this.plannedWork = plannedWork;
		this.actualWork = actualWork;
	}

	public AnalyticImpl() { }

	public UUID getAnalyticId() {
		return this.analyticId;
	}

	public void setAnalyticId(UUID analyticId) {
		this.analyticId = analyticId;
	}
	public EDate getStartDate() {
		return this.startDate;
	}

	public void setStartDate(EDate startDate) {
		this.startDate = startDate;
	}
	public EDate getEndDate() {
		return this.endDate;
	}

	public void setEndDate(EDate endDate) {
		this.endDate = endDate;
	}
	public int getTotalTasks() {
		return this.totalTasks;
	}

	public void setTotalTasks(int totalTasks) {
		this.totalTasks = totalTasks;
	}
	public EMap getPlannedWork() {
		return this.plannedWork;
	}

	public void setPlannedWork(EMap plannedWork) {
		this.plannedWork = plannedWork;
	}
	public EMap getActualWork() {
		return this.actualWork;
	}

	public void setActualWork(EMap actualWork) {
		this.actualWork = actualWork;
	}

	
	public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> analyticMap = new HashMap<String,Object>();
		analyticMap.put("analyticId",getAnalyticId());
		analyticMap.put("startDate",getStartDate());
		analyticMap.put("endDate",getEndDate());
		analyticMap.put("totalTasks",getTotalTasks());
		analyticMap.put("plannedWork",getPlannedWork());
		analyticMap.put("actualWork",getActualWork());

        return analyticMap;
    }

}
