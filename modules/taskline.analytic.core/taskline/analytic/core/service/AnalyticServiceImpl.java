package taskline.analytic.core;
import java.util.*;
import com.google.gson.Gson;
import java.util.*;
import java.util.logging.Logger;
import java.io.File;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import vmj.routing.route.exceptions.*;
import taskline.analytic.AnalyticFactory;
import prices.auth.vmj.annotations.Restricted;
//add other required packages

public class AnalyticServiceImpl extends AnalyticServiceComponent{

    public List<HashMap<String,Object>> saveAnalytic(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		Analytic analytic = createAnalytic(vmjExchange);
		analyticRepository.saveObject(analytic);
		return getAllAnalytic(vmjExchange);
	}

    public Analytic createAnalytic(Map<String, Object> requestBody){
		String totalTasksStr = (String) requestBody.get("totalTasks");
		int totalTasks = Integer.parseInt(totalTasksStr);
		
		//to do: fix association attributes
		Analytic Analytic = AnalyticFactory.createAnalytic(
			"taskline.analytic.core.AnalyticImpl",
		analyticId
		, startDate
		, endDate
		, totalTasks
		, plannedWork
		, actualWork
		);
		Repository.saveObject(analytic);
		return analytic;
	}

    public Analytic createAnalytic(Map<String, Object> requestBody, int id){
		String totalTasksStr = (String) vmjExchange.getRequestBodyForm("totalTasks");
		int totalTasks = Integer.parseInt(totalTasksStr);
		
		//to do: fix association attributes
		
		Analytic analytic = AnalyticFactory.createAnalytic("taskline.analytic.core.AnalyticImpl", analyticId, startDate, endDate, totalTasks, plannedWork, actualWork);
		return analytic;
	}

    public HashMap<String, Object> updateAnalytic(Map<String, Object> requestBody){
		String idStr = (String) requestBody.get("analyticId");
		int id = Integer.parseInt(idStr);
		Analytic analytic = Repository.getObject(id);
		
		String totalTasksStr = (String) requestBody.get("totalTasks");
		analytic.setTotalTasks(Integer.parseInt(totalTasksStr));
		
		Repository.updateObject(analytic);
		
		//to do: fix association attributes
		
		return analytic.toHashMap();
		
	}

    public HashMap<String, Object> getAnalytic(Map<String, Object> requestBody){
		List<HashMap<String, Object>> analyticList = getAllAnalytic("analytic_impl");
		for (HashMap<String, Object> analytic : analyticList){
			int record_id = ((Double) analytic.get("record_id")).intValue();
			if (record_id == id){
				return analytic;
			}
		}
		return null;
	}

	public HashMap<String, Object> getAnalyticById(int id){
		String idStr = vmjExchange.getGETParam("analyticId"); 
		int id = Integer.parseInt(idStr);
		Analytic analytic = analyticRepository.getObject(id);
		return analytic.toHashMap();
	}

    public List<HashMap<String,Object>> getAllAnalytic(Map<String, Object> requestBody){
		String table = (String) requestBody.get("table_name");
		List<Analytic> List = Repository.getAllObject(table);
		return transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<Analytic> List){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < List.size(); i++) {
            resultList.add(List.get(i).toHashMap());
        }

        return resultList;
	}

    public List<HashMap<String,Object>> deleteAnalytic(Map<String, Object> requestBody){
		String idStr = ((String) requestBody.get("id"));
		int id = Integer.parseInt(idStr);
		Repository.deleteObject(id);
		return getAllAnalytic(requestBody);
	}

}
