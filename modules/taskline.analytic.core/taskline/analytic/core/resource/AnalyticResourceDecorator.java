package taskline.analytic.core;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

public abstract class AnalyticResourceDecorator extends AnalyticResourceComponent{
	protected AnalyticResourceComponent record;

    public AnalyticResourceDecorator(AnalyticResourceComponent record) {
        this.record = record;
    }

    public List<HashMap<String, Object>> getPlannedWork(VMJExchange vmjExchange){
		return record.getPlannedWork(vmjExchange);
	}

	public List<HashMap<String, Object>> getActualWork(VMJExchange vmjExchange){
		return record.getActualWork(vmjExchange);
	}

}
