package taskline.analytic.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public abstract class AnalyticServiceDecorator extends AnalyticServiceComponent{
	protected AnalyticServiceComponent record;

    public AnalyticServiceDecorator(AnalyticServiceComponent record) {
        this.record = record;
    }

	public List<HashMap<String, Object>> getPlannedWork(Map<String, Object> requestBody){
		return record.getPlannedWork(requestBody);
	}

	public List<HashMap<String, Object>> getActualWork(Map<String, Object> requestBody){
		return record.getActualWork(requestBody);
	}

}
