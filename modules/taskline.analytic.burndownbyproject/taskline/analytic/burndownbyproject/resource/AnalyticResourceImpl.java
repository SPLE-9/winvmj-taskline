package taskline.analytic.burndownbyproject;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import taskline.analytic.core.AnalyticResourceDecorator;
import taskline.analytic.core.AnalyticImpl;
import taskline.analytic.core.AnalyticResourceComponent;

public class AnalyticResourceImpl extends AnalyticResourceDecorator {
    public AnalyticResourceImpl (AnalyticResourceComponent record) {
        super(record);
    }

    // @Restriced(permission = "")
    @Route(url="call/burndownbyproject/save")
    public List<HashMap<String,Object>> save(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		  = create(vmjExchange);
		Repository.saveObject();
		return getAll(vmjExchange);
	}

    public Analytic create(VMJExchange vmjExchange){
		
		  = record.create(vmjExchange);
		 deco = Factory.create("taskline.burndownbyproject.core.AnalyticImpl", , projectimpl);
			return deco;
	}

    public Analytic create(VMJExchange vmjExchange, int id){
		  = Repository.getObject(id);
		int recordId = (((Decorator) saved.getRecord()).getId();
		
		  = record.create(vmjExchange);
		 deco = Factory.create("taskline.burndownbyproject.core.AnalyticImpl", id, , projectimpl);
			return deco;
	}

    // @Restriced(permission = "")
    @Route(url="call/burndownbyproject/update")
    public HashMap<String, Object> update(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		String idStr = (String) vmjExchange.getRequestBodyForm("");
		int id = Integer.parseInt(idStr);
		
		  = Repository.getObject(id);
		 = create(vmjExchange, id);
		
		Repository.updateObject();
		 = Repository.getObject(id);
		//to do: fix association attributes
		
		return .toHashMap();
		
	}

	// @Restriced(permission = "")
    @Route(url="call/burndownbyproject/detail")
    public HashMap<String, Object> get(VMJExchange vmjExchange){
		return record.getAnalytic(vmjExchange);
	}

	// @Restriced(permission = "")
    @Route(url="call/burndownbyproject/list")
    public List<HashMap<String,Object>> getAll(VMJExchange vmjExchange){
		List<> List = Repository.getAllObject("_impl");
		return transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<> List){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < List.size(); i++) {
            resultList.add(List.get(i).toHashMap());
        }

        return resultList;
	}

	// @Restriced(permission = "")
    @Route(url="call/burndownbyproject/delete")
    public List<HashMap<String,Object>> deleteAnalytic(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		String idStr = (String) vmjExchange.getRequestBodyForm("");
		int id = Integer.parseInt(idStr);
		Repository.deleteObject(id);
		return getAll(vmjExchange);
	}

	public void calculateBurndownData() {
		// TODO: implement this method
	}
}
