package taskline.timelog.timelogduration;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import vmj.auth.annotations.Restricted;
import vmj.routing.route.exceptions.*;

import taskline.timelog.TimelogFactory;
import taskline.timelog.core.Timelog;
import taskline.timelog.core.TimelogResourceDecorator;
import taskline.timelog.core.TimelogResourceComponent;
import taskline.timelog.core.TimelogServiceComponent;
import taskline.timelog.core.TimelogService;

public class TimelogResourceImpl extends TimelogResourceDecorator {
	private TimelogService timelogService;

    public TimelogResourceImpl (TimelogResourceComponent record, TimelogServiceComponent recordService) {
        super(record);
		this.timelogService = new TimelogServiceImpl(recordService);
    }

	@Restricted(permissionName = "member")
    @Route(url="call/timelog-duration/save")
    public HashMap<String,Object> saveTimelog(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload();
		    String memberEmail = vmjExchange.getAuthPayload().getEmail();
			requestBody.put("memberEmail", memberEmail);
			return timelogService.saveTimelog(requestBody);
		}
		
		throw new NotFoundException("Route tidak ditemukan");
		
	}

	@Restricted(permissionName = "member")
    @Route(url="call/timelog-duration/update")
    public HashMap<String, Object> updateTimelog(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("PUT")){
			Map<String, Object> requestBody = vmjExchange.getPayload(); 
			String memberEmail = vmjExchange.getAuthPayload().getEmail();
			requestBody.put("memberEmail", memberEmail);
			return timelogService.updateTimelog(requestBody);
		}

		throw new NotFoundException("Route tidak ditemukan");
		
	}

	@Restricted(permissionName = "member")
    @Route(url="call/timelog-duration/list/me")
    public List<HashMap<String,Object>> getMyTimelog(VMJExchange vmjExchange){		
    	if (vmjExchange.getHttpMethod().equals("GET")) {
		    String memberEmail = vmjExchange.getAuthPayload().getEmail(); 
			return timelogService.getMyTimelog(memberEmail);
		}
		throw new NotFoundException("Route tidak ditemukan");

	}
    @Route(url="call/timelog-duration/list/all")
    public List<HashMap<String,Object>> getAllTimelog(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("GET")) {
		    return timelogService.getAllTimelog();
		}
		throw new NotFoundException("Route tidak ditemukan");
	}


    @Route(url="call/timelog-duration/delete")
    public List<HashMap<String,Object>> deleteTimelog(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("DELETE")) {
			Map<String, Object> requestBody = vmjExchange.getPayload(); 
			return timelogService.deleteTimelog(requestBody);
		}
		throw new NotFoundException("Route tidak ditemukan");
		
	}
}
