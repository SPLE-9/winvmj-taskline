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
//add other required packages
import taskline.project.core.ProjectService;
import taskline.project.core.ProjectServiceImpl;
import taskline.member.core.MemberImpl;
import taskline.project.core.ProjectImpl;
import taskline.member.core.Member;
import taskline.project.core.Project;

public class TaskServiceImpl extends TaskServiceComponent {
	
	private TaskFactory taskFactory = new TaskFactory();
	private ProjectService projectService = new ProjectServiceImpl();
	private final Gson gson = new Gson();


    public HashMap<String,Object> saveTask(Map<String, Object> requestBody){
		if (!requestBody.containsKey("title")) {
            throw new FieldValidationException("Field 'title' not found in the request body.");
        }

		if (!requestBody.containsKey("projectId")) {
            throw new FieldValidationException("Field 'projectId' not found in the request body.");
        }


		String projectId = (String) requestBody.get("projectId");
		HashMap<String, Object> projectMap = projectService.getProject(projectId);
		String json = gson.toJson(projectMap);
		
		Project project = gson.fromJson(json, ProjectImpl.class);
		String title = (String) requestBody.get("title");
		String description = (String) requestBody.get("description");


		Task task = taskFactory.createTask("taskline.task.core.TaskImpl", title, description, project);
		taskRepository.saveObject(task);
		
		return task.toHashMap();
	}

    public HashMap<String, Object> updateTask(Map<String, Object> requestBody){
		if (!requestBody.containsKey("taskId")) {
    		throw new NotFoundException("Field 'taskId' not found in the request body.");
    	}

		String taskIdStr = (String) requestBody.get("taskId");
		UUID taskId = UUID.fromString(taskIdStr);
		
		Task task  = taskRepository.getObject(taskId);
		if (task == null) {
	        throw new NotFoundException("Project with projectId " + taskId +" not found");
	    }

		if (requestBody.containsKey("title")) {
        	String title =  (String) requestBody.get("title");
            task.setTitle(title);
        }

		if (requestBody.containsKey("description")) {
        	String description =  (String) requestBody.get("description");
            task.setDescription(description);
        }
		
		taskRepository.updateObject(task);
		
		return task.toHashMap();
		
	}


	public HashMap<String, Object> getTaskById(String taskIdStr){
		UUID taskId = UUID.fromString(taskIdStr);
		Task task = taskRepository.getObject(taskId);
		
		if (task == null) {
			throw new NotFoundException("Task with taskId " + taskId +" not found");
		}

		return task.toHashMap();
	}

    public List<HashMap<String,Object>> getAllTask(){
		List<Task> taskList = taskRepository.getAllObject("task_impl");
		
		return transformListToHashMap(taskList);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<Task> taskList){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(Task task : taskList) {
            resultList.add(task.toHashMap());
        }

        return resultList;
	}

    public HashMap<String,Object> deleteTask(Map<String, Object> requestBody){
		String taskIdStr = (String) requestBody.get("taskId");
		UUID taskId = UUID.fromString(taskIdStr);
		Task task = taskRepository.getObject(taskId);
		
		if (task == null) {
			throw new NotFoundException("Task with taskId " + taskId +" not found");
		}

		taskRepository.deleteObject(taskId);
		
		return task.toHashMap();

	}

	public List<HashMap<String,Object>> getTaskByProjectId(String projectIdStr) {
		UUID projectId = UUID.fromString(projectIdStr);
		List<Task> taskList = taskRepository.getListObject("task_impl", "projectimpl_projectid", projectId);

		return transformListToHashMap(taskList);
	}

	public List<Task> getTaskByMemberId(UUID memberId){
		List<Task> taskList = taskRepository.getListObject("task_comp", "member_memberid", memberId);
		return taskList;
	}
}
