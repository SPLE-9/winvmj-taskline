package taskline.analytic.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="analytic_comp")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class AnalyticComponent implements Analytic{
	@Id
	protected UUID analyticId; 
	protected UUID analyticId;
	protected EDate startDate;
	protected EDate endDate;
	protected int totalTasks;
	protected EMap plannedWork;
	protected EMap actualWork;
	protected String objectName = AnalyticComponent.class.getName();

	public AnalyticComponent() {

	} 

	public AnalyticComponent(
        UUID analyticId, EDate startDate, EDate endDate, int totalTasks, EMap plannedWork, EMap actualWork
    ) {
        this.analyticId = analyticId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.totalTasks = totalTasks;
        this.plannedWork = plannedWork;
        this.actualWork = actualWork;
    }

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
 

	@Override
    public String toString() {
        return "{" +
            " analyticId='" + getAnalyticId() + "'" +
            " startDate='" + getStartDate() + "'" +
            " endDate='" + getEndDate() + "'" +
            " totalTasks='" + getTotalTasks() + "'" +
            " plannedWork='" + getPlannedWork() + "'" +
            " actualWork='" + getActualWork() + "'" +
            "}";
    }
	
}
