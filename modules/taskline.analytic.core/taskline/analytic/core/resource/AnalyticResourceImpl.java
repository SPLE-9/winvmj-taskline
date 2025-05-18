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

    @Route(url="call/analytic/planned")
    public List<HashMap<String, Object>> getPlannedWork(VMJExchange vmjExchange){
		HashMap<String, Object> requestBody = (HashMap<String, Object>) vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")){
			return null;
		}

		return analyticService.getPlannedWork(requestBody);
		
	}

    @Route(url="call/analytic/actual")
    public List<HashMap<String, Object>> getActualWork(VMJExchange vmjExchange){
		HashMap<String, Object> requestBody = (HashMap<String, Object>) vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")){
			return null;
		}
		return analyticService.getActualWork(requestBody);
	}
}
