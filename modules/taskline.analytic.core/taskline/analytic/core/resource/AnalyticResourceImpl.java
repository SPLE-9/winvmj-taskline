package taskline.analytic.core;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import vmj.routing.route.exceptions.*;
import taskline.analytic.AnalyticFactory;
//import prices.auth.vmj.annotations.Restricted;
//add other required packages

public class AnalyticResourceImpl extends AnalyticResourceComponent{
	
	private AnalyticServiceImpl analyticServiceImpl = new AnalyticServiceImpl();

	// @Restriced(permission = "")
    @Route(url="call/analytic")
    public HashMap<String,Object> createanalytic(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			Analytic result = analyticServiceImpl.createAnalytic(requestBody);
			return result.toHashMap();
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

    // @Restriced(permission = "")
    @Route(url="call/analytic/update")
    public HashMap<String, Object> updateAnalytic(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")){
			return null;
		}
		return analyticServiceImpl.updateAnalytic(requestBody);
		
	}

	// @Restriced(permission = "")
    @Route(url="call/analytic/detail")
    public HashMap<String, Object> getAnalytic(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		return analyticServiceImpl.getAnalytic(requestBody);
	}

	// @Restriced(permission = "")
    @Route(url="call/analytic/list")
    public List<HashMap<String,Object>> getAllAnalytic(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		return analyticServiceImpl.getAllAnalytic(requestBody);
	}

    
	// @Restriced(permission = "")
    @Route(url="call/analytic/delete")
    public List<HashMap<String,Object>> deleteAnalytic(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		return analyticServiceImpl.deleteAnalytic(requestBody);
	}

}
