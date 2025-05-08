package taskline.analytic.core;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import vmj.routing.route.exceptions.*;
import taskline.analytic.AnalyticFactory;
//import prices.auth.vmj.annotations.Restricted;
//add other required packages

public class AnalyticResourceImpl extends AnalyticResourceComponent{
	
	private AnalyticService analyticService = new AnalyticServiceImpl();

	// @Restricted(permission = "")
    @Route(url="call/analytic/save")
    public List<HashMap<String,Object>> saveAnalytic(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		HashMap<String, Object> requestBody = vmjExchange.getPayload(); 
		List<Analytic> analytics = analyticService.saveAnalytic(requestBody);
		return analyticService.transformAnalyticListToHashMap(analytics);
	}

	// @Restricted(permission = "")
    @Route(url="call/analytic/update")
    public HashMap<String, Object> updateAnalytic(VMJExchange vmjExchange){
		HashMap<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")){
			return null;
		}

		Analytic analytic = analyticService.updateAnalytic(requestBody);
		return analytic.toHashMap();
		
	}

	// @Restricted(permission = "")
    @Route(url="call/analytic/detail")
    public HashMap<String, Object> getAnalytic(VMJExchange vmjExchange){
		String idStr = vmjExchange.getGETParam("id");
		if (idStr == null) {
			throw new IllegalArgumentException("Invalid id");
		}
		UUID id = UUID.fromString(idStr);
		Analytic analytic = analyticService.getAnalytic(id);
		return analytic.toHashMap();
	}

	// @Restricted(permission = "")
    @Route(url="call/analytic/list")
    public List<HashMap<String,Object>> getAllAnalytic(VMJExchange vmjExchange){
		List<Analytic> analytics = analyticService.getAllAnalytic();
		return analyticService.transformAnalyticListToHashMap(analytics);
	}

    
	// @Restriced(permission = "")
    @Route(url="call/analytic/delete")
    public List<HashMap<String,Object>> deleteAnalytic(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		String idStr = vmjExchange.getGETParam("id");
		if (idStr == null) {
			throw new IllegalArgumentException("Invalid id");
		}
		UUID id = UUID.fromString(idStr);
		List<Analytic> analytics = analyticService.deleteAnalytic(id);
		return analyticService.transformAnalyticListToHashMap(analytics);
	}
}
