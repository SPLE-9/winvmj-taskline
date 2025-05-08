package taskline.timelog.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public abstract class TimelogServiceDecorator extends TimelogServiceComponent{
	protected TimelogServiceComponent record;

    public TimelogServiceDecorator(TimelogServiceComponent record) {
        this.record = record;
    }

	public TimelogImpl createTimelog(Map<String, Object> requestBody){
		return record.createTimelog(requestBody);
	}

    public Timelog createTimelog(Map<String, Object> requestBody, Map<String, Object> response){
		return record.createTimelog(requestBody, response);
	}

	public HashMap<String, Object> getTimelog(Map<String, Object> requestBody){
		return record.getTimelog(requestBody);
	}

	public List<HashMap<String,Object>> getAllTimelog(Map<String, Object> requestBody){
		return record.getAllTimelog(requestBody);
	}

    public List<HashMap<String,Object>> saveTimelog(VMJExchange vmjExchange){
		return record.saveTimelog(vmjExchange);
	}

    public HashMap<String, Object> updateTimelog(Map<String, Object> requestBody){
		return record.updateTimelog(requestBody);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<Timelog> List){
		return record.transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> deleteTimelog(Map<String, Object> requestBody){
		return record.deleteTimelog(requestBody);
	}

	public HashMap<String, Object> getTimelogById(int id){
        return record.getTimelogById(id);
    }

	public void getTimelogDetail() {
		return record.getTimelogDetail();
	}

	public void validateTimelog() {
		return record.validateTimelog();
	}
}
