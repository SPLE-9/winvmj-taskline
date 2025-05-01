package taskline.analytic.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public interface AnalyticService {
    List<HashMap<String,Object>> saveAnalytic(HashMap<String, Object> requestBody);
    HashMap<String, Object> updateAnalytic(HashMap<String, Object> requestBody);
	HashMap<String, Object> getAnalytic(UUID id);
    List<HashMap<String,Object>> getAllAnalytic();
    List<HashMap<String,Object>> deleteAnalytic(UUID id);
	List<HashMap<String, Object>> transformAnalyticListToHashMap(List<Analytic> list);
}
