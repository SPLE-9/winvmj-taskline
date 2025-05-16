package taskline.timelog.core;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import vmj.routing.route.exceptions.*;
import taskline.timelog.TimelogFactory;
import prices.auth.vmj.annotations.Restricted;
//add other required packages
import taskline.timelog.TimelogService;


public class TimelogResourceImpl extends TimelogResourceComponent{
	
	private TimelogService timelogService = new TimelogServiceImpl();

	// @Restriced(permission = "")
    @Route(url="call/timelog/save")
    public List<HashMap<String,Object>> saveTimelog(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload();
			return timelogService.saveTimelog(requestBody);
		}
		
		throw new NotFoundException("Route tidak ditemukan");
		
	}

	// @Restriced(permission = "")
    @Route(url="call/timelog/update")
    public HashMap<String, Object> updateTimelog(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("PUT")){
			Map<String, Object> requestBody = vmjExchange.getPayload(); 
			return timelogService.updateTimelog(requestBody);;
		}

		throw new NotFoundException("Route tidak ditemukan");
		
	}

	// @Restriced(permission = "")
    @Route(url="call/timelog/detail")
    public HashMap<String, Object> getTimelog(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("GET")) {
		    String idStr = vmjExchange.getGETParam("id");
			if (idStr == null) {
				throw new IllegalArgumentException("Invalid id");
			}
			return timelogService.getTimelog(idStr);
		}

		throw new NotFoundException("Route tidak ditemukan");

	}

	// @Restriced(permission = "")
    @Route(url="call/timelog/list")
    public List<HashMap<String,Object>> getAllTimelog(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("GET")) {
		    return timelogService.getAllTimelog();
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

	// @Restriced(permission = "")
    @Route(url="call/timelog/delete")
    public List<HashMap<String,Object>> deleteTimelog(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("DELETE")) {
			Map<String, Object> requestBody = vmjExchange.getPayload(); 
			return timelogService.deleteTimelog(requestBody);
		}
		
		return timelogServiceImpl.deleteTimelog(requestBody);
	}
}
