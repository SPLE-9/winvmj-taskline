package taskline.timelog.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public interface TimelogResource {
    HashMap<String,Object> saveTimelog(VMJExchange vmjExchange);
    HashMap<String, Object> updateTimelog(VMJExchange vmjExchange);
    List<HashMap<String,Object>> getMyTimelog(VMJExchange vmjExchange);
    List<HashMap<String,Object>> getAllTimelog(VMJExchange vmjExchange);
    List<HashMap<String,Object>> deleteTimelog(VMJExchange vmjExchange);
}
