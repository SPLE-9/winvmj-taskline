package taskline..timelogduration;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import taskline..core.TimelogResourceDecorator;
import taskline..core.TimelogImpl;
import taskline..core.TimelogResourceComponent;

public class TimelogResourceImpl extends TimelogResourceDecorator {
    public TimelogResourceImpl (TimelogResourceComponent record) {
        super(record);
    }

    // @Restriced(permission = "")
    @Route(url="call/timelogduration/save")
    public List<HashMap<String,Object>> save(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		invalidTimelogDuration invalidtimelogduration = createinvalidTimelogDuration(vmjExchange);
		invalidtimelogdurationRepository.saveObject(invalidtimelogduration);
		return getAllinvalidTimelogDuration(vmjExchange);
	}

    public  createinvalidTimelogDuration(VMJExchange vmjExchange){
		
		invalidTimelogDuration invalidtimelogduration = record.createinvalidTimelogDuration(vmjExchange);
		invalidTimelogDuration invalidtimelogdurationdeco = invalidTimelogDurationFactory.createinvalidTimelogDuration("taskline.timelogduration.core.TimelogImpl", invalidtimelogduration, 
		timelogDuration
		);
			return invalidtimelogdurationdeco;
	}


    public  createinvalidTimelogDuration(VMJExchange vmjExchange, int id){
		invalidTimelogDuration invalidtimelogduration = invalidtimelogdurationRepository.getObject(id);
		int recordinvalidTimelogDurationId = (((invalidTimelogDurationDecorator) savedinvalidTimelogDuration.getRecord()).getId();
		
		invalidTimelogDuration invalidtimelogduration = record.createinvalidTimelogDuration(vmjExchange);
		invalidTimelogDuration invalidtimelogdurationdeco = invalidTimelogDurationFactory.createinvalidTimelogDuration("taskline.timelogduration.core.TimelogImpl", id, invalidtimelogduration, 
		timelogDuration
		);
			return invalidtimelogdurationdeco;
	}

	// @Restriced(permission = "")
    @Route(url="call/timelogduration/update")
    public HashMap<String, Object> updateinvalidTimelogDuration(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		String idStr = (String) vmjExchange.getRequestBodyForm("");
		int id = Integer.parseInt(idStr);
		
		invalidTimelogDuration invalidtimelogduration = invalidtimelogdurationRepository.getObject(id);
		invalidtimelogduration = createinvalidTimelogDuration(vmjExchange, id);
		
		invalidtimelogdurationRepository.updateObject(invalidtimelogduration);
		invalidtimelogduration = invalidtimelogdurationRepository.getObject(id);
		//to do: fix association attributes
		
		return invalidtimelogduration.toHashMap();
		
	}

	// @Restriced(permission = "")
    @Route(url="call/timelogduration/detail")
    public HashMap<String, Object> getinvalidTimelogDuration(VMJExchange vmjExchange){
		return record.getinvalidTimelogDuration(vmjExchange);
	}

	// @Restriced(permission = "")
    @Route(url="call/timelogduration/list")
    public List<HashMap<String,Object>> getAllinvalidTimelogDuration(VMJExchange vmjExchange){
		List<invalidTimelogDuration> invalidtimelogdurationList = invalidtimelogdurationRepository.getAllObject("invalidtimelogduration_impl");
		return transforminvalidTimelogDurationListToHashMap(invalidtimelogdurationList);
	}

    public List<HashMap<String,Object>> transforminvalidTimelogDurationListToHashMap(List<invalidTimelogDuration> invalidTimelogDurationList){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < invalidTimelogDurationList.size(); i++) {
            resultList.add(invalidTimelogDurationList.get(i).toHashMap());
        }

        return resultList;
	}

	// @Restriced(permission = "")
    @Route(url="call/timelogduration/delete")
    public List<HashMap<String,Object>> deleteinvalidTimelogDuration(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		String idStr = (String) vmjExchange.getRequestBodyForm("");
		int id = Integer.parseInt(idStr);
		invalidtimelogdurationRepository.deleteObject(id);
		return getAllinvalidTimelogDuration(vmjExchange);
	}

	public void getTotalDuration() {
		// TODO: implement this method
	}
	
}
