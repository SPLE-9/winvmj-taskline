package taskline.timelog.timelogduration;
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
    @Route(url="call/timelogduration/save")
    public List<HashMap<String,Object>> save(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("POST")) {
			TimelogTimelogDuration timelogtimelogduration = createTimelogTimelogDuration(vmjExchange);
			timelogtimelogdurationRepository.saveObject(timelogtimelogduration);
			return getAllTimelogTimelogDuration(vmjExchange);
		}
		
	}

	// @Restriced(permission = "")
    @Route(url="call/timelogduration/update")
    public HashMap<String, Object> updateTimelogTimelogDuration(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("PUT")) {
			String idStr = (String) vmjExchange.getRequestBodyForm("timelogIdtaskIduserId");
			int id = Integer.parseInt(idStr);
			
			TimelogTimelogDuration timelogtimelogduration = timelogtimelogdurationRepository.getObject(id);
			timelogtimelogduration = createTimelogTimelogDuration(vmjExchange, id);
			
			timelogtimelogdurationRepository.updateObject(timelogtimelogduration);
			timelogtimelogduration = timelogtimelogdurationRepository.getObject(id);
			//to do: fix association attributes
			
			return timelogtimelogduration.toHashMap();
		}
		
		
	}

	// @Restriced(permission = "")
    @Route(url="call/timelogduration/detail")
    public HashMap<String, Object> getTimelogTimelogDuration(VMJExchange vmjExchange){
		return record.getTimelogTimelogDuration(vmjExchange);
	}

	// @Restriced(permission = "")
    @Route(url="call/timelogduration/list")
    public List<HashMap<String,Object>> getAllTimelogTimelogDuration(VMJExchange vmjExchange){
		List<TimelogTimelogDuration> timelogtimelogdurationList = timelogtimelogdurationRepository.getAllObject("timelogtimelogduration_impl");
		return transformTimelogTimelogDurationListToHashMap(timelogtimelogdurationList);
	}

    public List<HashMap<String,Object>> transformTimelogTimelogDurationListToHashMap(List<TimelogTimelogDuration> TimelogTimelogDurationList){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < TimelogTimelogDurationList.size(); i++) {
            resultList.add(TimelogTimelogDurationList.get(i).toHashMap());
        }

        return resultList;
	}

	// @Restriced(permission = "")
    @Route(url="call/timelogduration/delete")
    public List<HashMap<String,Object>> deleteTimelogTimelogDuration(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("DELETE")) {
			String idStr = (String) vmjExchange.getRequestBodyForm("timelogIdtaskIduserId");
			int id = Integer.parseInt(idStr);
			timelogtimelogdurationRepository.deleteObject(id);
			return getAllTimelogTimelogDuration(vmjExchange);
		}
		
		
	}

}
