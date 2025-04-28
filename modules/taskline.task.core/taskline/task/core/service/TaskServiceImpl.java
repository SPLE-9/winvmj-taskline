package taskline.task.core;
import java.util.*;
import com.google.gson.Gson;
import java.util.*;
import java.util.logging.Logger;
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
import taskline.task.TaskFactory;
import prices.auth.vmj.annotations.Restricted;
//add other required packages

public class TaskServiceImpl extends TaskServiceComponent{

    public List<HashMap<String,Object>> save(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		  = create(vmjExchange);
		Repository.saveObject();
		return getAll(vmjExchange);
	}

    public  create(Map<String, Object> requestBody){
		String title = (String) requestBody.get("title");
		String description = (String) requestBody.get("description");
		
		//to do: fix association attributes
		  = Factory.create(
			"taskline.task.core.TaskImpl",
		taskId
		, title
		, description
		, status
		, createdAt
		, userimpl
		, projectimpl
		);
		Repository.saveObject();
		return ;
	}

    public  create(Map<String, Object> requestBody, int id){
		String title = (String) vmjExchange.getRequestBodyForm("title");
		String description = (String) vmjExchange.getRequestBodyForm("description");
		
		//to do: fix association attributes
		
		  = Factory.create("taskline.task.core.TaskImpl", taskId, title, description, status, createdAt, userimpl, projectimpl);
		return ;
	}

    public HashMap<String, Object> update(Map<String, Object> requestBody){
		String idStr = (String) requestBody.get("taskId");
		int id = Integer.parseInt(idStr);
		  = Repository.getObject(id);
		
		.setTitle((String) requestBody.get("title"));
		.setDescription((String) requestBody.get("description"));
		
		Repository.updateObject();
		
		//to do: fix association attributes
		
		return .toHashMap();
		
	}

    public HashMap<String, Object> get(Map<String, Object> requestBody){
		List<HashMap<String, Object>> List = getAll("_impl");
		for (HashMap<String, Object>  : List){
			int record_id = ((Double) .get("record_id")).intValue();
			if (record_id == id){
				return ;
			}
		}
		return null;
	}

	public HashMap<String, Object> getById(int id){
		String idStr = vmjExchange.getGETParam("taskId"); 
		int id = Integer.parseInt(idStr);
		  = Repository.getObject(id);
		return .toHashMap();
	}

    public List<HashMap<String,Object>> getAll(Map<String, Object> requestBody){
		String table = (String) requestBody.get("table_name");
		List<> List = Repository.getAllObject(table);
		return transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<> List){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < List.size(); i++) {
            resultList.add(List.get(i).toHashMap());
        }

        return resultList;
	}

    public List<HashMap<String,Object>> delete(Map<String, Object> requestBody){
		String idStr = ((String) requestBody.get("id"));
		int id = Integer.parseInt(idStr);
		Repository.deleteObject(id);
		return getAll(requestBody);
	}

	public void getTasksByProject() {
		// TODO: implement this method
	}
}
