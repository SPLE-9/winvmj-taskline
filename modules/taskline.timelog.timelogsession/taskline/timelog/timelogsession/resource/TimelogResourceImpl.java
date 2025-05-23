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
		if (vmjExchange.getHttpMethod().equals("POST")) {
			TimelogTimelogSession timelogtimelogsession = createTimelogTimelogSession(vmjExchange);
			timelogtimelogsessionRepository.saveObject(timelogtimelogsession);
			return getAllTimelogTimelogSession(vmjExchange);
		}
		
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
	
}
