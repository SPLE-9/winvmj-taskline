package taskline.analytic.burndownbymember;
import java.util.*;
import java.util.logging.Logger;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import vmj.auth.annotations.Restricted;

import taskline.analytic.core.*;

public class AnalyticResourceImpl extends AnalyticResourceDecorator {
	private AnalyticService analyticService;
	private static final Logger LOGGER = Logger.getLogger(AnalyticResourceImpl.class.getName());

    public AnalyticResourceImpl(AnalyticResourceComponent recordController, AnalyticServiceComponent recordService) {
        super(recordController);
		this.analyticService = new AnalyticServiceImpl(recordService);
    }

	@Restricted(permissionName = "member")
	@Route(url="call/burndownbymember/planned")
	public List<HashMap<String, Object>> getPlannedWork(VMJExchange vmjExchange){
		String email = vmjExchange.getAuthPayload().getEmail();
		HashMap<String, Object> requestBody = new HashMap<>();
		requestBody.put("email", email);
		return analyticService.getPlannedWork(requestBody);
	}

	@Restricted(permissionName = "member")
	@Route(url="call/burndownbymember/actual")
	public List<HashMap<String, Object>> getActualWork(VMJExchange vmjExchange){
		String email = vmjExchange.getAuthPayload().getEmail();
		HashMap<String, Object> requestBody = new HashMap<>();
		requestBody.put("email", email);
		return analyticService.getActualWork(requestBody);
	}
}
