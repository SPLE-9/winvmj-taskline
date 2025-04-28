package taskline.analytic.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public interface AnalyticResource {
    List<HashMap<String,Object>> saveAnalytic(VMJExchange vmjExchange);
    HashMap<String, Object> updateAnalytic(VMJExchange vmjExchange);
    HashMap<String, Object> getAnalytic(VMJExchange vmjExchange);
    List<HashMap<String,Object>> getAllAnalytic(VMJExchange vmjExchange);
    List<HashMap<String,Object>> deleteAnalytic(VMJExchange vmjExchange);
	HashMap<String, Object> Analytic(VMJExchange vmjExhange);
}
