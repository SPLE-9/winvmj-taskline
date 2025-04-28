package taskline..timelogsession;
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
    @Route(url="call/timelogsession/save")
    public List<HashMap<String,Object>> save(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		invalidTimelogSession invalidtimelogsession = createinvalidTimelogSession(vmjExchange);
		invalidtimelogsessionRepository.saveObject(invalidtimelogsession);
		return getAllinvalidTimelogSession(vmjExchange);
	}

    public  createinvalidTimelogSession(VMJExchange vmjExchange){
		
		invalidTimelogSession invalidtimelogsession = record.createinvalidTimelogSession(vmjExchange);
		invalidTimelogSession invalidtimelogsessiondeco = invalidTimelogSessionFactory.createinvalidTimelogSession("taskline.timelogsession.core.TimelogImpl", invalidtimelogsession, 
		startTime, endTime
		);
			return invalidtimelogsessiondeco;
	}


    public  createinvalidTimelogSession(VMJExchange vmjExchange, int id){
		invalidTimelogSession invalidtimelogsession = invalidtimelogsessionRepository.getObject(id);
		int recordinvalidTimelogSessionId = (((invalidTimelogSessionDecorator) savedinvalidTimelogSession.getRecord()).getId();
		
		invalidTimelogSession invalidtimelogsession = record.createinvalidTimelogSession(vmjExchange);
		invalidTimelogSession invalidtimelogsessiondeco = invalidTimelogSessionFactory.createinvalidTimelogSession("taskline.timelogsession.core.TimelogImpl", id, invalidtimelogsession, 
		startTime, endTime
		);
			return invalidtimelogsessiondeco;
	}

	// @Restriced(permission = "")
    @Route(url="call/timelogsession/update")
    public HashMap<String, Object> updateinvalidTimelogSession(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		String idStr = (String) vmjExchange.getRequestBodyForm("");
		int id = Integer.parseInt(idStr);
		
		invalidTimelogSession invalidtimelogsession = invalidtimelogsessionRepository.getObject(id);
		invalidtimelogsession = createinvalidTimelogSession(vmjExchange, id);
		
		invalidtimelogsessionRepository.updateObject(invalidtimelogsession);
		invalidtimelogsession = invalidtimelogsessionRepository.getObject(id);
		//to do: fix association attributes
		
		return invalidtimelogsession.toHashMap();
		
	}

	// @Restriced(permission = "")
    @Route(url="call/timelogsession/detail")
    public HashMap<String, Object> getinvalidTimelogSession(VMJExchange vmjExchange){
		return record.getinvalidTimelogSession(vmjExchange);
	}

	// @Restriced(permission = "")
    @Route(url="call/timelogsession/list")
    public List<HashMap<String,Object>> getAllinvalidTimelogSession(VMJExchange vmjExchange){
		List<invalidTimelogSession> invalidtimelogsessionList = invalidtimelogsessionRepository.getAllObject("invalidtimelogsession_impl");
		return transforminvalidTimelogSessionListToHashMap(invalidtimelogsessionList);
	}

    public List<HashMap<String,Object>> transforminvalidTimelogSessionListToHashMap(List<invalidTimelogSession> invalidTimelogSessionList){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < invalidTimelogSessionList.size(); i++) {
            resultList.add(invalidTimelogSessionList.get(i).toHashMap());
        }

        return resultList;
	}

	// @Restriced(permission = "")
    @Route(url="call/timelogsession/delete")
    public List<HashMap<String,Object>> deleteinvalidTimelogSession(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		String idStr = (String) vmjExchange.getRequestBodyForm("");
		int id = Integer.parseInt(idStr);
		invalidtimelogsessionRepository.deleteObject(id);
		return getAllinvalidTimelogSession(vmjExchange);
	}

	public void calculateTotalDuration() {
		// TODO: implement this method
	}

	public void getIsOnGoing() {
		// TODO: implement this method
	}

	public void endSession() {
		// TODO: implement this method
	}
	
}
