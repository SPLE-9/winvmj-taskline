package taskline.analytic.burndownbyproject;
import java.util.*;
import java.util.logging.Logger;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import taskline.analytic.core.*;

public class AnalyticResourceImpl extends AnalyticResourceDecorator {
	private AnalyticService analyticService;
	private static final Logger LOGGER = Logger.getLogger(AnalyticResourceImpl.class.getName());

    public AnalyticResourceImpl(AnalyticResourceComponent recordController, AnalyticServiceComponent recordService) {
        super(recordController);
		this.analyticService = new AnalyticServiceImpl(recordService);
    }

	@Route(url="call/burndownbyproject/planned")
	public List<HashMap<String, Object>> getPlannedWork(VMJExchange vmjExchange){
		String projectIdStr = vmjExchange.getGETParam("projectId");
		HashMap<String, Object> requestBody = new HashMap<>();
		requestBody.put("projectId", projectIdStr);
		return analyticService.getPlannedWork(requestBody);
	}

	@Route(url="call/burndownbyproject/actual")
	public List<HashMap<String, Object>> getActualWork(VMJExchange vmjExchange){
		String projectIdStr = vmjExchange.getGETParam("projectId");
		HashMap<String, Object> requestBody = new HashMap<>();
		requestBody.put("projectId", projectIdStr);
		return analyticService.getActualWork(requestBody);
	}
}
