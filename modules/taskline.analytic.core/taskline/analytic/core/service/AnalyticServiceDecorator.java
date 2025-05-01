package taskline.analytic.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public abstract class AnalyticServiceDecorator extends AnalyticServiceComponent{
	protected AnalyticServiceComponent record;

    public AnalyticServiceDecorator(AnalyticServiceComponent record) {
        this.record = record;
    }

	public AnalyticImpl createAnalytic(Map<String, Object> requestBody){
		return record.createAnalytic(requestBody);
	}

    public Analytic createAnalytic(Map<String, Object> requestBody, Map<String, Object> response){
		return record.createAnalytic(requestBody, response);
	}

	public HashMap<String, Object> getAnalytic(Map<String, Object> requestBody){
		return record.getAnalytic(requestBody);
	}

	public List<HashMap<String,Object>> getAllAnalytic(Map<String, Object> requestBody){
		return record.getAllAnalytic(requestBody);
	}

    public List<HashMap<String,Object>> saveAnalytic(VMJExchange vmjExchange){
		return record.saveAnalytic(vmjExchange);
	}

    public HashMap<String, Object> updateAnalytic(Map<String, Object> requestBody){
		return record.updateAnalytic(requestBody);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<Analytic> List){
		return record.transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> deleteAnalytic(Map<String, Object> requestBody){
		return record.deleteAnalytic(requestBody);
	}

	public HashMap<String, Object> getAnalyticById(int id){
        return record.getAnalyticById(id);
    }

}
