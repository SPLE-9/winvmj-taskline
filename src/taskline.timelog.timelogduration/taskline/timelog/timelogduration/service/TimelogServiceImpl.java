package taskline.timelog.timelogduration;

import java.util.*;

import vmj.routing.route.VMJExchange;

import taskline.timelog.core.TimelogServiceDecorator;
import taskline.timelog.core.TimelogImpl;
import taskline.timelog.core.TimelogServiceComponent;
import taskline.timelog.core.TimelogDecorator;

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
import taskline.task.core.*;

public class TimelogServiceImpl extends TimelogServiceDecorator {
    private TimelogFactory timelogFactory = new TimelogFactory();
	MemberService memberService = new MemberServiceImpl();
    TaskService taskService = new TaskServiceImpl();

    public TimelogServiceImpl (TimelogServiceComponent record) {
        super(record);
    }

    public HashMap<String, Object> saveTimelog(Map<String, Object> requestBody) {
		
		String timelogDateString = (String) requestBody.get("timelogDate");
		LocalDate timelogDate = LocalDate.parse(timelogDateString);
        UUID timelogId = UUID.randomUUID();
        UUID taskId = UUID.fromString((String) requestBody.get("taskId"));
        Task task = taskService.getTaskObjectById(taskId);

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
            timelogNotes,
            task,
            member
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

    	if (!requestBody.containsKey("timelogId")) {
            throw new IllegalArgumentException("No ID given");
        }

        UUID id = UUID.fromString((String) requestBody.get("timelogId"));
        Timelog savedTimelog = timelogRepository.getObject(id);

        if (savedTimelog == null) {
            throw new NotFoundException("Timelog not found with ID: " + id);
        }

        // Get original core TimelogImpl (base)
        Timelog coreTimelog = ((TimelogDecorator) savedTimelog).getRecord();

        // Parse updated fields
        UUID taskId = UUID.fromString((String) requestBody.get("taskId"));
        Task task = taskService.getTaskObjectById(taskId);

        String timelogDateStr = (String) requestBody.get("timelogDate");
        LocalDate timelogDate = LocalDate.parse(timelogDateStr);

        String timelogNotes = (String) requestBody.getOrDefault("timelogNotes", "");
        Float duration = Float.parseFloat((String) requestBody.get("timelogDuration"));

        Member member = memberService.getMemberByEmail((String) requestBody.get("memberEmail"));
        UUID memberId = member.getMemberId();

        // Recreate core TimelogImpl with updated values
        Timelog updatedCoreTimelog = TimelogFactory.createTimelog(
            "taskline.timelog.core.TimelogImpl",
            coreTimelog.getTimelogId(), // same ID
            taskId,
            memberId,
            timelogDate,
            timelogNotes,
            task,
            member
        );

        // Re-wrap it with updated duration
        Timelog updatedDurationTimelog = TimelogFactory.createTimelog(
            "taskline.timelog.timelogduration.TimelogImpl",
            id,
            updatedCoreTimelog,
            duration
        );

        // Update both layers (just in case they're stored separately)
        timelogRepository.updateObject(updatedCoreTimelog);
        timelogRepository.updateObject(updatedDurationTimelog);

        return updatedDurationTimelog.toHashMap();
		
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
