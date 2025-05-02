package taskline.timelog.timelogsession;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import taskline.timelog.core.TimelogResourceDecorator;
import taskline.timelog.core.TimelogImpl;
import taskline.timelog.core.TimelogResourceComponent;

public class TimelogResourceImpl extends TimelogResourceDecorator {
    public TimelogResourceImpl (TimelogResourceComponent record) {
        super(record);
    }

    // @Restriced(permission = "")
    @Route(url="call/timelogsession/save")
    public List<HashMap<String,Object>> save(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		TimelogTimelogSession timelogtimelogsession = createTimelogTimelogSession(vmjExchange);
		timelogtimelogsessionRepository.saveObject(timelogtimelogsession);
		return getAllTimelogTimelogSession(vmjExchange);
	}

    public Timelog createTimelogTimelogSession(VMJExchange vmjExchange){
		
		TimelogTimelogSession timelogtimelogsession = record.createTimelogTimelogSession(vmjExchange);
		TimelogTimelogSession timelogtimelogsessiondeco = TimelogTimelogSessionFactory.createTimelogTimelogSession("taskline.timelogsession.core.TimelogImpl", timelogtimelogsession, timelogId, taskId, userId, timelogDate, timelogType, timelogNotes, userimpl, taskimpl
		startTime, endTime
		);
			return timelogtimelogsessiondeco;
	}


    public Timelog createTimelogTimelogSession(VMJExchange vmjExchange, int id){
		TimelogTimelogSession timelogtimelogsession = timelogtimelogsessionRepository.getObject(id);
		int recordTimelogTimelogSessionId = (((TimelogTimelogSessionDecorator) savedTimelogTimelogSession.getRecord()).getId();
		
		TimelogTimelogSession timelogtimelogsession = record.createTimelogTimelogSession(vmjExchange);
		TimelogTimelogSession timelogtimelogsessiondeco = TimelogTimelogSessionFactory.createTimelogTimelogSession("taskline.timelogsession.core.TimelogImpl", id, timelogtimelogsession, timelogId, taskId, userId, timelogDate, timelogType, timelogNotes, userimpl, taskimpl
		startTime, endTime
		);
			return timelogtimelogsessiondeco;
	}

	// @Restriced(permission = "")
    @Route(url="call/timelogsession/update")
    public HashMap<String, Object> updateTimelogTimelogSession(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		String idStr = (String) vmjExchange.getRequestBodyForm("timelogIdtaskIduserId");
		int id = Integer.parseInt(idStr);
		
		TimelogTimelogSession timelogtimelogsession = timelogtimelogsessionRepository.getObject(id);
		timelogtimelogsession = createTimelogTimelogSession(vmjExchange, id);
		
		timelogtimelogsessionRepository.updateObject(timelogtimelogsession);
		timelogtimelogsession = timelogtimelogsessionRepository.getObject(id);
		//to do: fix association attributes
		
		return timelogtimelogsession.toHashMap();
		
	}

	// @Restriced(permission = "")
    @Route(url="call/timelogsession/detail")
    public HashMap<String, Object> getTimelogTimelogSession(VMJExchange vmjExchange){
		return record.getTimelogTimelogSession(vmjExchange);
	}

	// @Restriced(permission = "")
    @Route(url="call/timelogsession/list")
    public List<HashMap<String,Object>> getAllTimelogTimelogSession(VMJExchange vmjExchange){
		List<TimelogTimelogSession> timelogtimelogsessionList = timelogtimelogsessionRepository.getAllObject("timelogtimelogsession_impl");
		return transformTimelogTimelogSessionListToHashMap(timelogtimelogsessionList);
	}

    public List<HashMap<String,Object>> transformTimelogTimelogSessionListToHashMap(List<TimelogTimelogSession> TimelogTimelogSessionList){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < TimelogTimelogSessionList.size(); i++) {
            resultList.add(TimelogTimelogSessionList.get(i).toHashMap());
        }

        return resultList;
	}

	// @Restriced(permission = "")
    @Route(url="call/timelogsession/delete")
    public List<HashMap<String,Object>> deleteTimelogTimelogSession(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		String idStr = (String) vmjExchange.getRequestBodyForm("timelogIdtaskIduserId");
		int id = Integer.parseInt(idStr);
		timelogtimelogsessionRepository.deleteObject(id);
		return getAllTimelogTimelogSession(vmjExchange);
	}

	public void calculateTotalDuration() {
		// TODO: implement this method
		List<TimelogTimelogSession> sessions = timelogtimelogsessionRepository.getAllObject("timelogtimelogsession_impl");

        for (TimelogTimelogSession session : sessions) {
            if (session instanceof TimelogImpl) {
                TimelogImpl impl = (TimelogImpl) session;
                long duration = impl.calculateTotalDuration();
                System.out.println("Session ID: " + impl.getId() + " - Duration (minutes): " + duration);
            }
        }
	}

	public void getIsOnGoing() {
		// TODO: implement this method
		List<TimelogTimelogSession> sessions = timelogtimelogsessionRepository.getAllObject("timelogtimelogsession_impl");

        for (TimelogTimelogSession session : sessions) {
            if (session instanceof TimelogImpl) {
                TimelogImpl impl = (TimelogImpl) session;
                boolean isOngoing = impl.getIsOnGoing();
                System.out.println("Session ID: " + impl.getId() + " - Ongoing: " + isOngoing);
            }
        }
	}

	public void endSession() {
		// TODO: implement this method
		List<TimelogTimelogSession> sessions = timelogtimelogsessionRepository.getAllObject("timelogtimelogsession_impl");

        for (TimelogTimelogSession session : sessions) {
            if (session instanceof TimelogImpl) {
                TimelogImpl impl = (TimelogImpl) session;
                impl.endSession();
                timelogtimelogsessionRepository.updateObject(impl);
                System.out.println("Session ID: " + impl.getId() + " ended.");
            }
        }
	}
	
}
