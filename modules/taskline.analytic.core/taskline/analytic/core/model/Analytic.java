package taskline.analytic.core;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import java.util.*;

public interface Analytic {
	public UUID getAnalyticId();
	public void setAnalyticId(UUID analyticId);
	public EDate getStartDate();
	public void setStartDate(EDate startDate);
	public EDate getEndDate();
	public void setEndDate(EDate endDate);
	public int getTotalTasks();
	public void setTotalTasks(int totalTasks);
	public EMap getPlannedWork();
	public void setPlannedWork(EMap plannedWork);
	public EMap getActualWork();
	public void setActualWork(EMap actualWork);
	HashMap<String, Object> toHashMap();
}
