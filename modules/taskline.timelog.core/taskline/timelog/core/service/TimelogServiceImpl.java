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
import java.time.LocalDateTime;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import vmj.routing.route.exceptions.*;
import taskline.timelog.TimelogFactory;
import prices.auth.vmj.annotations.Restricted;
//add other required packages

public class TimelogServiceImpl extends TimelogServiceComponent{

	private TimelogFactory timelogFactory = new TimelogFactory();

    public HashMap<String,Object> saveTimelog(HashMap<String, Object> requestBody){

		Task task = (Task) requestBody.get("task");
		LocalDateTime timelogDate = (LocalDateTime) requestBody.get("timelogDate");
		String timelogType = (String) requestBody.get("timelogType");

		validateTimelog(task, timelogType, timelogDate);

		UUID timelogId = UUID.randomUUID();
		
		//to do: fix association attributes
		Timelog timelog = TimelogFactory.createTimelog(
			"taskline.timelog.core.TimelogImpl"
			,timelogId
			, taskId
			, userId
			, timelogDate
			, timelogType
			, timelogNotes
			, userimpl
			, taskimpl
		);
		
		timelogRepository.saveObject(timelog);

		return timelogRepository.getObject(timelog.getTimelogId()).toHashMap();
	}

    public HashMap<String, Object> updateTimelog(Map<String, Object> requestBody){
		if (!requestBody.containsKey("timelogId")) {
			throw new IllegalArgumentException("Invalid id");
		}

		String idStr = (String) requestBody.get("timelogId");
		UUID id = UUID.fromString(idStr);

		Timelog timelog = timelogRepository.getObject(id);

		if (timelog == null) {
			throw new NotFoundException("Timelog not found with id: " + id);
		}
		if (requestBody.containsKey("taskId")) {
			timelog.setTaskId((UUID) requestBody.get("taskId"));
		}
		if (requestBody.containsKey("userId")) {
			timelog.setUserId((UUID) requestBody.get("userId"));
		}
		if (requestBody.containsKey("timelogDate")) {
			timelog.setTimelogDate((LocalDateTime) requestBody.get("timelogDate"));
		}
		if (requestBody.containsKey("timelogType")) {
			timelog.setTimelogType((String) requestBody.get("timelogType"));
		}
		if (requestBody.containsKey("timelogNotes")) {
			timelog.setTimelogNotes((String) requestBody.get("timelogNotes"));
		}

		timelogRepository.updateObject(timelog);
		
		return timelogRepository.getObject(id).toHashMap();
		
	}

    public HashMap<String, Object> getTimelog(String id){
		UUID timelogId = UUID.fromString(id);

		Timelog timelog = timelogRepository.getObject(timelogId);
		if (timelog == null) {
			throw new NotFoundException("Timelog not found with id: " + timelogId);
		}

		return timelog.toHashMap();
	}

    public List<HashMap<String,Object>> getAllTimelog(){
		List<Timelog> timelogList = timelogRepository.getAllObject("timelog_impl");
		return transformListToHashMap(timelogList);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<Timelog> timelogList){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(Timelog timelog : timelogList){ 
            resultList.add(timelogList.get(i).toHashMap());
        }

        return resultList;
	}

    public List<HashMap<String,Object>> deleteTimelog(Map<String, Object> requestBody){
		String idStr = ((String) requestBody.get("id"));
		UUID id = UUID.fromString(idStr);

		Timelog timelog = timelogRepository.getObject(id);
		if (timelog == null) {
			throw new NotFoundException("Timelog not found with id: " + id);
		}
		Repository.deleteObject(id);
		return getAllTimelog(requestBody);
	}

	// public void getTimelogDetail() {
	// 	// TODO: implement this method

	// }

	public void validateTimelog(Task task, LocalDateTime timelogDate, String timelogType) {
		// TODO: implement this method
		if (task == null || task.getTaskId() == null) {
			throw new IllegalArgumentException("Invalid task");
		}
		if (timelogDate == null) {
			throw new IllegalArgumentException("Invalid timelog date");
		}
		if (timelogType == null || timelogType.isEmpty()) {
			throw new IllegalArgumentException("Invalid timelog type");
		}
	}
}
