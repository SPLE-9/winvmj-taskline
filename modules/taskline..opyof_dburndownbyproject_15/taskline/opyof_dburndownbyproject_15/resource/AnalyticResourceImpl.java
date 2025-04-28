package taskline..opyof_dburndownbyproject_15;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import taskline..core.AnalyticResourceDecorator;
import taskline..core.AnalyticImpl;
import taskline..core.AnalyticResourceComponent;

public class AnalyticResourceImpl extends AnalyticResourceDecorator {
    public AnalyticResourceImpl (AnalyticResourceComponent record) {
        super(record);
    }

    // @Restriced(permission = "")
    @Route(url="call/opyof_dburndownbyproject_15/save")
    public List<HashMap<String,Object>> save(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		invalidopyOf_DBurndownByProject_15 invalidopyof_dburndownbyproject_15 = createinvalidopyOf_DBurndownByProject_15(vmjExchange);
		invalidopyof_dburndownbyproject_15Repository.saveObject(invalidopyof_dburndownbyproject_15);
		return getAllinvalidopyOf_DBurndownByProject_15(vmjExchange);
	}

    public  createinvalidopyOf_DBurndownByProject_15(VMJExchange vmjExchange){
		
		invalidopyOf_DBurndownByProject_15 invalidopyof_dburndownbyproject_15 = record.createinvalidopyOf_DBurndownByProject_15(vmjExchange);
		invalidopyOf_DBurndownByProject_15 invalidopyof_dburndownbyproject_15deco = invalidopyOf_DBurndownByProject_15Factory.createinvalidopyOf_DBurndownByProject_15("taskline.opyof_dburndownbyproject_15.core.AnalyticImpl", invalidopyof_dburndownbyproject_15, 
		);
			return invalidopyof_dburndownbyproject_15deco;
	}


    public  createinvalidopyOf_DBurndownByProject_15(VMJExchange vmjExchange, int id){
		invalidopyOf_DBurndownByProject_15 invalidopyof_dburndownbyproject_15 = invalidopyof_dburndownbyproject_15Repository.getObject(id);
		int recordinvalidopyOf_DBurndownByProject_15Id = (((invalidopyOf_DBurndownByProject_15Decorator) savedinvalidopyOf_DBurndownByProject_15.getRecord()).getId();
		
		invalidopyOf_DBurndownByProject_15 invalidopyof_dburndownbyproject_15 = record.createinvalidopyOf_DBurndownByProject_15(vmjExchange);
		invalidopyOf_DBurndownByProject_15 invalidopyof_dburndownbyproject_15deco = invalidopyOf_DBurndownByProject_15Factory.createinvalidopyOf_DBurndownByProject_15("taskline.opyof_dburndownbyproject_15.core.AnalyticImpl", id, invalidopyof_dburndownbyproject_15, 
		);
			return invalidopyof_dburndownbyproject_15deco;
	}

	// @Restriced(permission = "")
    @Route(url="call/opyof_dburndownbyproject_15/update")
    public HashMap<String, Object> updateinvalidopyOf_DBurndownByProject_15(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		String idStr = (String) vmjExchange.getRequestBodyForm("");
		int id = Integer.parseInt(idStr);
		
		invalidopyOf_DBurndownByProject_15 invalidopyof_dburndownbyproject_15 = invalidopyof_dburndownbyproject_15Repository.getObject(id);
		invalidopyof_dburndownbyproject_15 = createinvalidopyOf_DBurndownByProject_15(vmjExchange, id);
		
		invalidopyof_dburndownbyproject_15Repository.updateObject(invalidopyof_dburndownbyproject_15);
		invalidopyof_dburndownbyproject_15 = invalidopyof_dburndownbyproject_15Repository.getObject(id);
		//to do: fix association attributes
		
		return invalidopyof_dburndownbyproject_15.toHashMap();
		
	}

	// @Restriced(permission = "")
    @Route(url="call/opyof_dburndownbyproject_15/detail")
    public HashMap<String, Object> getinvalidopyOf_DBurndownByProject_15(VMJExchange vmjExchange){
		return record.getinvalidopyOf_DBurndownByProject_15(vmjExchange);
	}

	// @Restriced(permission = "")
    @Route(url="call/opyof_dburndownbyproject_15/list")
    public List<HashMap<String,Object>> getAllinvalidopyOf_DBurndownByProject_15(VMJExchange vmjExchange){
		List<invalidopyOf_DBurndownByProject_15> invalidopyof_dburndownbyproject_15List = invalidopyof_dburndownbyproject_15Repository.getAllObject("invalidopyof_dburndownbyproject_15_impl");
		return transforminvalidopyOf_DBurndownByProject_15ListToHashMap(invalidopyof_dburndownbyproject_15List);
	}

    public List<HashMap<String,Object>> transforminvalidopyOf_DBurndownByProject_15ListToHashMap(List<invalidopyOf_DBurndownByProject_15> invalidopyOf_DBurndownByProject_15List){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < invalidopyOf_DBurndownByProject_15List.size(); i++) {
            resultList.add(invalidopyOf_DBurndownByProject_15List.get(i).toHashMap());
        }

        return resultList;
	}

	// @Restriced(permission = "")
    @Route(url="call/opyof_dburndownbyproject_15/delete")
    public List<HashMap<String,Object>> deleteinvalidopyOf_DBurndownByProject_15(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		String idStr = (String) vmjExchange.getRequestBodyForm("");
		int id = Integer.parseInt(idStr);
		invalidopyof_dburndownbyproject_15Repository.deleteObject(id);
		return getAllinvalidopyOf_DBurndownByProject_15(vmjExchange);
	}

	public void calculateBurndownData() {
		// TODO: implement this method
	}
	
}
