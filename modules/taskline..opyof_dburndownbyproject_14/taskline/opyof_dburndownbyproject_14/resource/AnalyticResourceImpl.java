package taskline..opyof_dburndownbyproject_14;
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
    @Route(url="call/opyof_dburndownbyproject_14/save")
    public List<HashMap<String,Object>> save(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		invalidopyOf_DBurndownByProject_14 invalidopyof_dburndownbyproject_14 = createinvalidopyOf_DBurndownByProject_14(vmjExchange);
		invalidopyof_dburndownbyproject_14Repository.saveObject(invalidopyof_dburndownbyproject_14);
		return getAllinvalidopyOf_DBurndownByProject_14(vmjExchange);
	}

    public  createinvalidopyOf_DBurndownByProject_14(VMJExchange vmjExchange){
		
		invalidopyOf_DBurndownByProject_14 invalidopyof_dburndownbyproject_14 = record.createinvalidopyOf_DBurndownByProject_14(vmjExchange);
		invalidopyOf_DBurndownByProject_14 invalidopyof_dburndownbyproject_14deco = invalidopyOf_DBurndownByProject_14Factory.createinvalidopyOf_DBurndownByProject_14("taskline.opyof_dburndownbyproject_14.core.AnalyticImpl", invalidopyof_dburndownbyproject_14, 
		);
			return invalidopyof_dburndownbyproject_14deco;
	}


    public  createinvalidopyOf_DBurndownByProject_14(VMJExchange vmjExchange, int id){
		invalidopyOf_DBurndownByProject_14 invalidopyof_dburndownbyproject_14 = invalidopyof_dburndownbyproject_14Repository.getObject(id);
		int recordinvalidopyOf_DBurndownByProject_14Id = (((invalidopyOf_DBurndownByProject_14Decorator) savedinvalidopyOf_DBurndownByProject_14.getRecord()).getId();
		
		invalidopyOf_DBurndownByProject_14 invalidopyof_dburndownbyproject_14 = record.createinvalidopyOf_DBurndownByProject_14(vmjExchange);
		invalidopyOf_DBurndownByProject_14 invalidopyof_dburndownbyproject_14deco = invalidopyOf_DBurndownByProject_14Factory.createinvalidopyOf_DBurndownByProject_14("taskline.opyof_dburndownbyproject_14.core.AnalyticImpl", id, invalidopyof_dburndownbyproject_14, 
		);
			return invalidopyof_dburndownbyproject_14deco;
	}

	// @Restriced(permission = "")
    @Route(url="call/opyof_dburndownbyproject_14/update")
    public HashMap<String, Object> updateinvalidopyOf_DBurndownByProject_14(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		String idStr = (String) vmjExchange.getRequestBodyForm("");
		int id = Integer.parseInt(idStr);
		
		invalidopyOf_DBurndownByProject_14 invalidopyof_dburndownbyproject_14 = invalidopyof_dburndownbyproject_14Repository.getObject(id);
		invalidopyof_dburndownbyproject_14 = createinvalidopyOf_DBurndownByProject_14(vmjExchange, id);
		
		invalidopyof_dburndownbyproject_14Repository.updateObject(invalidopyof_dburndownbyproject_14);
		invalidopyof_dburndownbyproject_14 = invalidopyof_dburndownbyproject_14Repository.getObject(id);
		//to do: fix association attributes
		
		return invalidopyof_dburndownbyproject_14.toHashMap();
		
	}

	// @Restriced(permission = "")
    @Route(url="call/opyof_dburndownbyproject_14/detail")
    public HashMap<String, Object> getinvalidopyOf_DBurndownByProject_14(VMJExchange vmjExchange){
		return record.getinvalidopyOf_DBurndownByProject_14(vmjExchange);
	}

	// @Restriced(permission = "")
    @Route(url="call/opyof_dburndownbyproject_14/list")
    public List<HashMap<String,Object>> getAllinvalidopyOf_DBurndownByProject_14(VMJExchange vmjExchange){
		List<invalidopyOf_DBurndownByProject_14> invalidopyof_dburndownbyproject_14List = invalidopyof_dburndownbyproject_14Repository.getAllObject("invalidopyof_dburndownbyproject_14_impl");
		return transforminvalidopyOf_DBurndownByProject_14ListToHashMap(invalidopyof_dburndownbyproject_14List);
	}

    public List<HashMap<String,Object>> transforminvalidopyOf_DBurndownByProject_14ListToHashMap(List<invalidopyOf_DBurndownByProject_14> invalidopyOf_DBurndownByProject_14List){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < invalidopyOf_DBurndownByProject_14List.size(); i++) {
            resultList.add(invalidopyOf_DBurndownByProject_14List.get(i).toHashMap());
        }

        return resultList;
	}

	// @Restriced(permission = "")
    @Route(url="call/opyof_dburndownbyproject_14/delete")
    public List<HashMap<String,Object>> deleteinvalidopyOf_DBurndownByProject_14(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		String idStr = (String) vmjExchange.getRequestBodyForm("");
		int id = Integer.parseInt(idStr);
		invalidopyof_dburndownbyproject_14Repository.deleteObject(id);
		return getAllinvalidopyOf_DBurndownByProject_14(vmjExchange);
	}

	public void calculateBurndownData() {
		// TODO: implement this method
	}
	
}
