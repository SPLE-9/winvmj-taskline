package taskline.timelog.timelogduration;

import java.util.*;

import vmj.routing.route.VMJExchange;

import taskline.timelog.core.TimelogServiceDecorator;
import taskline.timelog.core.TimelogImpl;
import taskline.timelog.core.TimelogServiceComponent;

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
import taskline.timelog.core.Timelog;

//add other required packages
import java.time.LocalDate;
import java.util.stream.Collectors;
import taskline.member.core.*;

public class TimelogServiceImpl extends TimelogServiceDecorator {
    private TimelogFactory timelogFactory = new TimelogFactory();
	MemberService memberService = new MemberServiceImpl();

    public TimelogServiceImpl (TimelogServiceComponent record) {
        super(record);
    }

    public HashMap<String, Object> saveTimelog(Map<String, Object> requestBody) {
		
		String timelogDateString = (String) requestBody.get("timelogDate");
		LocalDate timelogDate = LocalDate.parse(timelogDateString);
        UUID timelogId = UUID.randomUUID();
        UUID taskId = UUID.fromString((String) requestBody.get("taskId"));

		Member member = memberService.getMemberByEmail((String) requestBody.get("memberEmail"));
        UUID memberId = member.getMemberId();
        String timelogNotes = (String) requestBody.getOrDefault("timelogNotes", "");
        
        validateTimelog(taskId, timelogDate);

        String durationStr = (String) requestBody.get("timelogDuration");
		Float duration = Float.parseFloat((String) durationStr);

        Timelog timelog = TimelogFactory.createTimelog(
            "taskline.timelog.core.TimelogImpl",
            timelogId,
            taskId,
            memberId,
            timelogDate,
            timelogNotes
        );

        Timelog timelogDuration = TimelogFactory.createTimelog(
            "taskline.timelog.timelogduration.TimelogImpl",
            timelog,
            duration
        );

        timelogRepository.saveObject(timelog);
        timelogRepository.saveObject(timelogDuration);

        return timelogRepository.getObject(timelog.getTimelogId()).toHashMap();
    }

    public HashMap<String, Object> updateTimelog(Map<String, Object> requestBody){
        Float duration = null;

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
		if (requestBody.containsKey("timelogNotes")) {
			timelog.setTimelogNotes((String) requestBody.get("timelogNotes"));
		}
        if (requestBody.containsKey("timelogDuration")) {
			String durationStr = (String) requestBody.get("timelogDuration");
		    duration = Float.parseFloat((String) durationStr);
		}

        Timelog timelogUpdated = TimelogFactory.createTimelog(
            "taskline.timelog.core.TimelogImpl",
            id,
            timelog.getTaskId(),
            timelog.getMemberId(),
            timelog.getTimelogDate(),
            timelog.getTimelogNotes()
        );

        if (duration != null) {
            Timelog timelogDuration = TimelogFactory.createTimelog(
                "taskline.timelog.timelogduration.TimelogImpl",
                id,
                timelog,
                duration
            );

            timelogRepository.updateObject(timelogDuration);
        }

		timelogRepository.updateObject(timelogUpdated);
    
		
		return timelogRepository.getObject(id).toHashMap();
		
	}

    public List<HashMap<String,Object>> getMyTimelog(String memberEmail){
    	Member member = memberService.getMemberByEmail(memberEmail);
    	UUID memberId = member.getMemberId();
		List<Timelog> allTimelogList = timelogRepository.getAllObject("timelog_duration");

		List<Timelog> myTimelogList = new ArrayList<Timelog>();
		for (Timelog timelog : allTimelogList) {
			if (timelog.getMemberId().equals(memberId)) {
				myTimelogList.add(timelog);
			}
		}

		return transformListToHashMap(myTimelogList);
	}

    public List<HashMap<String,Object>> getAllTimelog(){
		List<Timelog> timelogList = timelogRepository.getAllObject("timelog_duration");
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

	public void validateTimelog(UUID taskId, LocalDate timelogDate) {
		// TODO: implement this method
		if (taskId == null) {
			throw new IllegalArgumentException("Invalid task");
		}
		if (timelogDate == null) {
			throw new IllegalArgumentException("Invalid timelog date");
		}
	}

}
