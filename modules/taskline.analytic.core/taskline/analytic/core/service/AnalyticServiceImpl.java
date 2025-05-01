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

    public List<HashMap<String,Object>> saveAnalytic(HashMap<String, Object> requestBody){
		String idStr = (String) requestBody.get("id");
		UUID id = UUID.fromString(idStr);

		EDate startDate = new EDate((String) requestBody.get("startDate"));
		EDate endDate = new EDate((String) requestBody.get("endDate"));

		Analytic analytic = AnalyticFactory.createAnalytic("taskline.analytic.core.AnalyticImpl", id, startDate, endDate);
		analyticRepository.saveObject(analytic);
		return getAllAnalytic();
	}

    public Analytic updateAnalytic(HashMap<String, Object> requestBody){
		String idStr = (String) requestBody.get("id");
		UUID id = UUID.fromString(idStr);
		Analytic analytic = analyticRepository.getObject(id);

		if (analytic == null) {
			throw new NotFoundException("Analytic not found");
		}
		
		String totalTasksStr = (String) requestBody.get("totalTasks");
		analytic.setTotalTasks(Integer.parseInt(totalTasksStr));
		
		analyticRepository.updateObject(analytic);
		
		return analytic;
		
	}

    public Analytic getAnalytic(UUID id){
		Analytic analytic = analyticRepository.getObject(id);
		if (analytic == null) {
			throw new NotFoundException("Analytic not found");
		}
		return analytic;
	}

    public List<Analytic> getAllAnalytic(){
		List<Analytic> List = analyticRepository.getAllObject();
		return List;
	}

    public List<HashMap<String,Object>> transformAnalyticListToHashMap(List<Analytic> List){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < List.size(); i++) {
            resultList.add(List.get(i).toHashMap());
        }

        return resultList;
	}

    public List<Analytic> deleteAnalytic(UUID id){
		Analytic analytic = analyticRepository.getObject(id);
		if (analytic == null) {
			throw new NotFoundException("Analytic not found");
		}
		analyticRepository.deleteObject(id);
		return getAllAnalytic();
	}

}
