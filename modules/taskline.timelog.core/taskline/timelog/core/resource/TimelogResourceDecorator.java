package taskline.timelog.core;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

public abstract class TimelogResourceDecorator extends TimelogResourceComponent{
	protected TimelogResourceComponent record;

    public TimelogResourceDecorator(TimelogResourceComponent record) {
        this.record = record;
    }

    public Timelog createTimelog(VMJExchange vmjExchange){
		return record.createTimelog(vmjExchange);
	}

    public HashMap<String, Object> updateTimelog(VMJExchange vmjExchange){
		return record.updateTimelog(vmjExchange);
	}

    public HashMap<String, Object> getTimelog(VMJExchange vmjExchange){
		return record.getTimelog(vmjExchange);
	}

    public List<HashMap<String,Object>> getAllTimelog(VMJExchange vmjExchange){
		return record.getAllTimelog(vmjExchange);
	}

    public List<HashMap<String,Object>> deleteTimelog(VMJExchange vmjExchange){
		return record.deleteTimelog(vmjExchange);
	}

	public void getTimelogDetail() {
		return record.getTimelogDetail();
	}

	public void validateTimelog() {
		return record.validateTimelog();
	}
}
