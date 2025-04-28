package taskline.analytic.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public interface AnalyticService {
	Analytic createAnalytic(Map<String, Object> requestBody);
	Analytic createAnalytic(Map<String, Object> requestBody, Map<String, Object> response);
	HashMap<String, Object> getAnalytic(Map<String, Object> requestBody);
    List<HashMap<String,Object>> saveAnalytic(Map<String, Object> requestBody);
    HashMap<String, Object> updateAnalytic(Map<String, Object> requestBody);
    HashMap<String, Object> getAnalyticById(int id);
    List<HashMap<String,Object>> getAllAnalytic(Map<String, Object> requestBody);
    List<HashMap<String,Object>> deleteAnalytic(Map<String, Object> requestBody);
	List<HashMap<String, Object>> transformListToHashMap(List<Disbursement> List);
}
