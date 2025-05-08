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

    public List<HashMap<String,Object>> saveTask(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		Task task  = createTask(vmjExchange);
		Repository.saveObject();
		return getAll(vmjExchange);
	}

    public Task createTask(Map<String, Object> requestBody){
		String title = (String) requestBody.get("title");
		String description = (String) requestBody.get("description");
		
		//to do: fix association attributes
		Task task  = TaskFactory.createTask(
			"taskline.task.core.TaskImpl",
		taskId
		, title
		, description
		, status
		, createdAt
		, userimpl
		, projectimpl
		, completedAt
		);
		Repository.saveObject();
		return task;
	}

    public Task createTask(Map<String, Object> requestBody, int id){
		String title = (String) vmjExchange.getRequestBodyForm("title");
		String description = (String) vmjExchange.getRequestBodyForm("description");
		
		//to do: fix association attributes
		
		Task task = TaskFactory.createTask("taskline.task.core.TaskImpl", taskId, title, description, status, createdAt, userimpl, projectimpl, completedAt);
		return task;
	}

    public HashMap<String, Object> updateTask(Map<String, Object> requestBody){
		String idStr = (String) requestBody.get("taskId");
		int id = Integer.parseInt(idStr);
		Task task  = Repository.getObject(id);
		
		task.setTitle((String) requestBody.get("title"));
		task.setDescription((String) requestBody.get("description"));
		
		Repository.updateObject(task);
		
		return task.toHashMap();
		
	}

    public HashMap<String, Object> getTask(Map<String, Object> requestBody){
		List<HashMap<String, Object>> taskList = getAllTask("task_impl");
		for (HashMap<String, Object> task : taskList){
			int record_id = ((Double) .get("record_id")).intValue();
			if (record_id == id){
				return task;
			}
		}
		return null;
	}

	public HashMap<String, Object> getTaskById(int id){
		String idStr = vmjExchange.getGETParam("taskId"); 
		int idTask = Integer.parseInt(id);
		Task task  = Repository.getObject(idTask);
		return task.toHashMap();
	}

    public List<HashMap<String,Object>> getAllTask(Map<String, Object> requestBody){
		String table = (String) requestBody.get("table_name");
		List<Task> List = Repository.getAllObject(table);
		return transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<> List){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < List.size(); i++) {
            resultList.add(List.get(i).toHashMap());
        }

        return resultList;
	}

    public List<HashMap<String,Object>> deleteTask(Map<String, Object> requestBody){
		String idStr = ((String) requestBody.get("id"));
		int id = Integer.parseInt(idStr);
		Repository.deleteObject(id);
		return getAll(requestBody);
	}

	public void getTasksByProject(Map<String, Object> requestBody) {
		String table = (String) requestBody.get("table_name");
		String column = (String) requestBody.get("column_name");
		String filter = (String) requestBody.get("project_id");
		List<Task> List = Repository.getListObject(table, column, filter);
	}
}
