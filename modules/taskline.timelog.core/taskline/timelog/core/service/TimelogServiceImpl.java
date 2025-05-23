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
import java.time.LocalDate;
import java.util.stream.Collectors;
import taskline.member.core.*;

public class TimelogServiceImpl extends TimelogServiceComponent{

	private TimelogFactory timelogFactory = new TimelogFactory();
	MemberService memberService = new MemberServiceImpl();
	
	public HashMap<String, Object> saveTimelog(Map<String, Object> requestBody) {
		
		String timelogDateString = (String) requestBody.get("timelogDate");
		LocalDate timelogDate = LocalDate.parse(timelogDateString);
        String timelogType = (String) requestBody.get("timelogType");
        UUID timelogId = UUID.randomUUID();
        UUID taskId = UUID.fromString((String) requestBody.get("taskId"));
        UUID memberId = UUID.fromString((String) requestBody.get("memberId"));
        String timelogNotes = (String) requestBody.getOrDefault("timelogNotes", "");
        
        validateTimelog(taskId, timelogDate, timelogType);

        Timelog timelog = TimelogFactory.createTimelog(
            "taskline.timelog.core.TimelogImpl",
            timelogId,
            taskId,
            memberId,
            timelogDate,
            timelogType,
            timelogNotes
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
		if (requestBody.containsKey("timelogDate")) {
			timelog.setTimelogDate((LocalDate) requestBody.get("timelogDate"));
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

    public List<HashMap<String,Object>> getMyTimelog(String memberEmail){
    	Member member = memberService.getMemberByEmail(memberEmail);
    	UUID memberId = member.getMemberId();
		List<Timelog> allTimelogList = timelogRepository.getAllObject("timelog_impl");

		List<Timelog> myTimelogList = new ArrayList<Timelog>();
		for (Timelog timelog : allTimelogList) {
			if (timelog.getMemberId().equals(memberId)) {
				myTimelogList.add(timelog);
			}
		}

		return transformListToHashMap(myTimelogList);
	}

    public List<HashMap<String,Object>> getAllTimelog(){
		List<Timelog> timelogList = timelogRepository.getAllObject("timelog_impl");
		return transformListToHashMap(timelogList);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<Timelog> timelogList){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(Timelog t : timelogList){ 
        	resultList.add(t.toHashMap());
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
		timelogRepository.deleteObject(id);
		return getAllTimelog();
	}

	public void validateTimelog(UUID taskId, LocalDate timelogDate, String timelogType) {
		// TODO: implement this method
		if (taskId == null) {
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
