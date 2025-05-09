package taskline.task.core;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import vmj.routing.route.exceptions.*;
import taskline.task.TaskFactory;
import taskline.task.core.TaskService;
//import prices.auth.vmj.annotations.Restricted;
//add other required packages
import taskline.task.core.TaskServiceImpl;
import taskline.user.core.UserImpl;
import taskline.project.core.ProjectImpl;

public class TaskResourceImpl extends TaskResourceComponent{
	
	private TaskService taskService = new TaskServiceImpl();

	@Route(url="call/task/save")
    public HashMap<String,Object> saveTask(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			return taskService.saveTask(requestBody);
		}

		throw new NotFoundException("Route tidak ditemukan");
	}

    // @Restriced(permission = "")
    @Route(url="call/task/update")
    public HashMap<String, Object> updateTask(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("PUT")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			return taskService.updateTask(requestBody);
		}

		throw new NotFoundException("Route tidak ditemukan");
		
	}

	// @Restriced(permission = "")
    @Route(url="call/task/detail")
    public HashMap<String, Object> getTaskByid(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("GET")) {
		    String taskIdStr = vmjExchange.getGETParam("taskId");
			return taskService.getTaskById(taskIdStr);
		}

		throw new NotFoundException("Route tidak ditemukan");
	}

	// @Restriced(permission = "")
    @Route(url="call/task/list")
    public List<HashMap<String,Object>> getAllTask(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("GET")) {
			return taskService.getAllTask();
		}

		throw new NotFoundException("Route tidak ditemukan");
	}

    
	// @Restriced(permission = "")
    @Route(url="call/task/delete")
    public List<HashMap<String,Object>> deleteTask(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("DELETE")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			return taskService.deleteTask(requestBody);
		}

		throw new NotFoundException("Route tidak ditemukan");
	}

	@Route(url="call/project-task/list")
	public void getTasksByProjectId() {
		if (vmjExchange.getHttpMethod().equals("GET")) {
		    String projectIdStr = vmjExchange.getGETParam("projectId");
			return taskService.getTaskByProjectId(projectIdStr);
		}

		throw new NotFoundException("Route tidak ditemukan");
	}
}
