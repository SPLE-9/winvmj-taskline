package taskline.analytic.core;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

public abstract class AnalyticResourceDecorator extends AnalyticResourceComponent{
	protected AnalyticResourceComponent record;

    public AnalyticResourceDecorator(AnalyticResourceComponent record) {
        this.record = record;
    }

    public Analytic createAnalytic(VMJExchange vmjExchange){
		return record.createAnalytic(vmjExchange);
	}

    public HashMap<String, Object> updateAnalytic(VMJExchange vmjExchange){
		return record.updateAnalytic(vmjExchange);
	}

    public HashMap<String, Object> getAnalytic(VMJExchange vmjExchange){
		return record.getAnalytic(vmjExchange);
	}

    public List<HashMap<String,Object>> getAllAnalytic(VMJExchange vmjExchange){
		return record.getAllAnalytic(vmjExchange);
	}

    public List<HashMap<String,Object>> deleteAnalytic(VMJExchange vmjExchange){
		return record.deleteAnalytic(vmjExchange);
	}

}
