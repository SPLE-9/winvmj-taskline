package taskline.timelog.core;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import vmj.routing.route.exceptions.*;
import taskline.timelog.TimelogFactory;
//import prices.auth.vmj.annotations.Restricted;
//add other required packages

public class TimelogResourceImpl extends TimelogResourceComponent{
	
	private TimelogServiceImpl timelogServiceImpl = new TimelogServiceImpl();

	// @Restriced(permission = "")
    @Route(url="call/timelog")
    public HashMap<String,Object> createtimelog(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			Timelog result = timelogServiceImpl.createTimelog(requestBody);
			return result.toHashMap();
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

    // @Restriced(permission = "")
    @Route(url="call/timelog/update")
    public HashMap<String, Object> updateTimelog(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")){
			return null;
		}
		return timelogServiceImpl.updateTimelog(requestBody);
		
	}

	// @Restriced(permission = "")
    @Route(url="call/timelog/detail")
    public HashMap<String, Object> getTimelog(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		return timelogServiceImpl.getTimelog(requestBody);
	}

	// @Restriced(permission = "")
    @Route(url="call/timelog/list")
    public List<HashMap<String,Object>> getAllTimelog(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		return timelogServiceImpl.getAllTimelog(requestBody);
	}

    
	// @Restriced(permission = "")
    @Route(url="call/timelog/delete")
    public List<HashMap<String,Object>> deleteTimelog(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		return timelogServiceImpl.deleteTimelog(requestBody);
	}

	public void getTimelogDetail() {
		// TODO: implement this method
	}

	public void validateTimelog() {
		// TODO: implement this method
	}
}
