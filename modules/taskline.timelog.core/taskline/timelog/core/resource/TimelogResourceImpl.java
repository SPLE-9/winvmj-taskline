package taskline.timelog.core;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import vmj.routing.route.exceptions.*;
import taskline.timelog.TimelogFactory;
import prices.auth.vmj.annotations.Restricted;
//add other required packages


public class TimelogResourceImpl extends TimelogResourceComponent{
	
	private TimelogService timelogService = new TimelogServiceImpl();

	// @Restriced(permission = "")
    @Route(url="call/timelog/save")
    public HashMap<String,Object> saveTimelog(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload();
		    String memberEmail = vmjExchange.getAuthPayload().getEmail();
			requestBody.put("memberEmail", memberEmail);
			return timelogService.saveTimelog(requestBody);
		}
		
		throw new NotFoundException("Route tidak ditemukan");
		
	}

	// @Restriced(permission = "")
    @Route(url="call/timelog/update")
    public HashMap<String, Object> updateTimelog(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("PUT")){
			Map<String, Object> requestBody = vmjExchange.getPayload(); 
			return timelogService.updateTimelog(requestBody);
		}

		throw new NotFoundException("Route tidak ditemukan");
		
	}

	// @Restriced(permission = "")
    @Route(url="call/timelog/list/me")
    public List<HashMap<String,Object>> getMyTimelog(VMJExchange vmjExchange){		
    	if (vmjExchange.getHttpMethod().equals("GET")) {
		    String memberEmail = vmjExchange.getAuthPayload().getEmail(); 
			return timelogService.getMyTimelog(memberEmail);
		}
		throw new NotFoundException("Route tidak ditemukan");

	}

	// @Restriced(permission = "")
    @Route(url="call/timelog/list/all")
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
		throw new NotFoundException("Route tidak ditemukan");
		
	}
}
