package taskline.analytic.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public interface AnalyticResource {
    List<HashMap<String, Object>> getPlannedWork(VMJExchange vmjExchange);
    List<HashMap<String, Object>> getActualWork(VMJExchange vmjExchange);
}
