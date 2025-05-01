package taskline.analytic.burndownbymember;
import java.util.*;
import java.util.logging.Logger;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import taskline.analytic.core.AnalyticResourceDecorator;
import taskline.analytic.core.AnalyticImpl;
import taskline.analytic.core.AnalyticResourceComponent;

public class AnalyticResourceImpl extends AnalyticResourceDecorator {
	private AnalyticService analyticService;
	private static final Logger LOGGER = Logger.getLogger(AnalyticResourceImpl.class.getName());

    public AnalyticResourceImpl(AnalyticResourceComponent recordController, AnalyticServiceComponent recordService) {
        super(recordController);
		this.analyticService = new AnalyticServiceImpl(recordService);
    }

    // @Restricted(permission = "")
    @Route(url="call/burndownbymember/save")
    public List<HashMap<String,Object>> saveAnalytic(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		String email = vmjExchange.getAuthPayload().getEmail();
		HashMap<String, Object> requestBody = (HashMap<String, Object>) vmjExchange.getPayload();
		requestBody.put("email", email);
		List<Analytic> analyticList = analyticService.saveAnalytic(requestBody);
		return analyticService.transformAnalyticListToHashMap(analyticList);
	}

	// @Restricted(permission = "")
    @Route(url="call/burndownbymember/update")
    public HashMap<String, Object> updateAnalytic(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		HashMap<String, Object> requestBody = (HashMap<String, Object>) vmjExchange.getPayload();
		Analytic analytic = analyticService.updateAnalytic(requestBody);
		return analytic.toHashMap();
		
	}

	// @Restricted(permission = "")
    @Route(url="call/burndownbymember/detail")
    public HashMap<String, Object> getAnalytic(VMJExchange vmjExchange){
		String idStr = vmjExchange.getGETParam("id");
		if (idStr == null) {
			throw new IllegalArgumentException("Invalid id");
		}
		UUID id = UUID.fromString(idStr);
		Analytic analytic = analyticService.getAnalytic(id);
		return analytic.toHashMap();
	}

	// @Restriced(permission = "")
    @Route(url="call/burndownbymember/list")
    public List<HashMap<String,Object>> getAllAnalyticByUser(VMJExchange vmjExchange){
		String email = vmjExchange.getAuthPayload().getEmail();
		List<Analytic> analyticList = analyticService.getAllAnalyticByUser(email);
		return analyticService.transformAnalyticListToHashMap(analyticList);
	}

	@Route(url="call/burndownbymember/plannedwork")
	public List<HashMap<String, Object>> getPlannedWork(VMJExchange vmjExchange){
		String email = vmjExchange.getAuthPayload().getEmail();
		return analyticService.getPlannedWork(email);
	}

	@Route(url="call/burndownbymember/actualwork")
	public List<HashMap<String, Object>> getActualWork(VMJExchange vmjExchange){
		String email = vmjExchange.getAuthPayload().getEmail();
		return analyticService.getActualWork(email);
	}

	// @Restricted(permission = "")
    @Route(url="call/burndownbymember/delete")
    public List<HashMap<String,Object>> deleteAnalyticBurndownByMember(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		String idStr = vmjExchange.getGETParam("id");
		if (idStr == null) {
			throw new IllegalArgumentException("Invalid id");
		}
		UUID id = UUID.fromString(idStr);
		Analytic analytic = analyticService.deleteAnalytic(id);
		return analytic.toHashMap();
	}	
}
