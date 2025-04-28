package taskline.timelog.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public interface TimelogService {
	Timelog createTimelog(Map<String, Object> requestBody);
	Timelog createTimelog(Map<String, Object> requestBody, Map<String, Object> response);
	HashMap<String, Object> getTimelog(Map<String, Object> requestBody);
    List<HashMap<String,Object>> saveTimelog(Map<String, Object> requestBody);
    HashMap<String, Object> updateTimelog(Map<String, Object> requestBody);
    HashMap<String, Object> getTimelogById(int id);
    List<HashMap<String,Object>> getAllTimelog(Map<String, Object> requestBody);
    List<HashMap<String,Object>> deleteTimelog(Map<String, Object> requestBody);
	List<HashMap<String, Object>> transformListToHashMap(List<Disbursement> List);
}
