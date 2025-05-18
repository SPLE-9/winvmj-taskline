package taskline.timelog.core;
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
import taskline.timelog.TimelogFactory;
import prices.auth.vmj.annotations.Restricted;
//add other required packages

public class TimelogServiceImpl extends TimelogServiceComponent{

    public List<HashMap<String,Object>> saveTimelog(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		Timelog timelog = createTimelog(vmjExchange);
		timelogRepository.saveObject(timelog);
		return getAllTimelog(vmjExchange);
	}

    public Timelog createTimelog(Map<String, Object> requestBody){
		
		//to do: fix association attributes
		Timelog Timelog = TimelogFactory.createTimelog(
			"taskline.timelog.core.TimelogImpl",
		timelogId
		, taskId
		, memberId
		, timelogDate
		, timelogType
		, timelogNotes
		, memberimpl
		, taskimpl
		);
		Repository.saveObject(timelog);
		return timelog;
	}

    public Timelog createTimelog(Map<String, Object> requestBody, int id){
		
		//to do: fix association attributes
		
		Timelog timelog = TimelogFactory.createTimelog("taskline.timelog.core.TimelogImpl", timelogId, taskId, memberId, timelogDate, timelogType, timelogNotes, memberimpl, taskimpl);
		return timelog;
	}

    public HashMap<String, Object> updateTimelog(Map<String, Object> requestBody){
		String idStr = (String) requestBody.get("timelogIdtaskIdmemberId");
		int id = Integer.parseInt(idStr);
		Timelog timelog = Repository.getObject(id);
		
		
		Repository.updateObject(timelog);
		
		//to do: fix association attributes
		
		return timelog.toHashMap();
		
	}

    public HashMap<String, Object> getTimelog(Map<String, Object> requestBody){
		List<HashMap<String, Object>> timelogList = getAllTimelog("timelog_impl");
		for (HashMap<String, Object> timelog : timelogList){
			int record_id = ((Double) timelog.get("record_id")).intValue();
			if (record_id == id){
				return timelog;
			}
		}
		return null;
	}

	public HashMap<String, Object> getTimelogById(int id){
		String idStr = vmjExchange.getGETParam("timelogIdtaskIdmemberId"); 
		int id = Integer.parseInt(idStr);
		Timelog timelog = timelogRepository.getObject(id);
		return timelog.toHashMap();
	}

    public List<HashMap<String,Object>> getAllTimelog(Map<String, Object> requestBody){
		String table = (String) requestBody.get("table_name");
		List<Timelog> List = Repository.getAllObject(table);
		return transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<Timelog> List){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < List.size(); i++) {
            resultList.add(List.get(i).toHashMap());
        }

        return resultList;
	}

    public List<HashMap<String,Object>> deleteTimelog(Map<String, Object> requestBody){
		String idStr = ((String) requestBody.get("id"));
		int id = Integer.parseInt(idStr);
		Repository.deleteObject(id);
		return getAllTimelog(requestBody);
	}

	public void getTimelogDetail() {
		// TODO: implement this method
	}

	public void validateTimelog() {
		// TODO: implement this method
	}
}
