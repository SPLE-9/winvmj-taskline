package taskline.analytic.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public interface AnalyticService {
    List<HashMap<String, Object>> getPlannedWork(HashMap<String, Object> requestBody);
	List<HashMap<String, Object>> getActualWork(HashMap<String, Object> requestBody);
}
