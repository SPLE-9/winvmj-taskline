package taskline.analytic.core;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import java.util.*;

public interface Analytic {
	public UUID getAnalyticId();
	public void setAnalyticId(UUID analyticId);
	public Date getStartDate();
	public void setStartDate(Date startDate);
	public Date getEndDate();
	public void setEndDate(Date endDate);
	public int getTotalTasks();
	public void setTotalTasks(int totalTasks);
	public HashMap<Date, Integer> getPlannedWork();
	public void setPlannedWork(HashMap<Date, Integer> plannedWork);
	public HashMap<Date, Integer> getActualWork();
	public void setActualWork(HashMap<Date, Integer> actualWork);
	public HashMap<String, Object> toHashMap();
}
