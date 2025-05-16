package taskline.timelog.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public interface TimelogService {
	HashMap<String, Object> getTimelog(String id);
    HashMap<String,Object> saveTimelog(Map<String, Object> requestBody);
    HashMap<String, Object> updateTimelog(Map<String, Object> requestBody);
    List<HashMap<String,Object>> getAllTimelog();
    List<HashMap<String,Object>> deleteTimelog(Map<String, Object> requestBody);
	List<HashMap<String, Object>> transformListToHashMap(List<Timelog> timelogList);
}
