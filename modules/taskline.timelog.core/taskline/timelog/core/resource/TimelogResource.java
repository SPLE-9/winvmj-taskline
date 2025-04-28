package taskline.timelog.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public interface TimelogResource {
    List<HashMap<String,Object>> saveTimelog(VMJExchange vmjExchange);
    HashMap<String, Object> updateTimelog(VMJExchange vmjExchange);
    HashMap<String, Object> getTimelog(VMJExchange vmjExchange);
    List<HashMap<String,Object>> getAllTimelog(VMJExchange vmjExchange);
    List<HashMap<String,Object>> deleteTimelog(VMJExchange vmjExchange);
	HashMap<String, Object> Timelog(VMJExchange vmjExhange);
}
