package taskline.task.taskwithcomment;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import taskline.task.core.TaskResourceDecorator;
import taskline.task.core.TaskImpl;
import taskline.task.core.TaskResourceComponent;

public class TaskResourceImpl extends TaskResourceDecorator {
    public TaskResourceImpl (TaskResourceComponent record) {
        super(record);
    }

    // @Restriced(permission = "")
    @Route(url="call/taskwithcomment/save")
    public List<HashMap<String,Object>> save(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		  = create(vmjExchange);
		Repository.saveObject();
		return getAll(vmjExchange);
	}

    public Task create(VMJExchange vmjExchange){
		
		  = record.create(vmjExchange);
		 deco = Factory.create("taskline.taskwithcomment.core.TaskImpl", , );
			return deco;
	}

    public Task create(VMJExchange vmjExchange, int id){
		  = Repository.getObject(id);
		int recordId = (((Decorator) saved.getRecord()).getId();
		
		  = record.create(vmjExchange);
		 deco = Factory.create("taskline.taskwithcomment.core.TaskImpl", id, , );
			return deco;
	}

    // @Restriced(permission = "")
    @Route(url="call/taskwithcomment/update")
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
    @Route(url="call/taskwithcomment/detail")
    public HashMap<String, Object> get(VMJExchange vmjExchange){
		return record.getTask(vmjExchange);
	}

	// @Restriced(permission = "")
    @Route(url="call/taskwithcomment/list")
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
    @Route(url="call/taskwithcomment/delete")
    public List<HashMap<String,Object>> deleteTask(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		String idStr = (String) vmjExchange.getRequestBodyForm("");
		int id = Integer.parseInt(idStr);
		Repository.deleteObject(id);
		return getAll(vmjExchange);
	}

}
