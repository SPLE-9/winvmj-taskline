package MProject.project.core;
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
import MProject.project.ProjectFactory;
import prices.auth.vmj.annotations.Restricted;
//add other required packages

public class ProjectServiceImpl extends ProjectServiceComponent{

    public List<HashMap<String,Object>> saveProject(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		Project project = createProject(vmjExchange);
		projectRepository.saveObject(project);
		return getAllProject(vmjExchange);
	}

    public Project createProject(Map<String, Object> requestBody){
		String title = (String) requestBody.get("title");
		String description = (String) requestBody.get("description");
		
		//to do: fix association attributes
		Project Project = ProjectFactory.createProject(
			"MProject.project.core.ProjectImpl",
		projectId
		, title
		, description
		, completion
		);
		Repository.saveObject(project);
		return project;
	}

    public Project createProject(Map<String, Object> requestBody, int id){
		String title = (String) vmjExchange.getRequestBodyForm("title");
		String description = (String) vmjExchange.getRequestBodyForm("description");
		
		//to do: fix association attributes
		
		Project project = ProjectFactory.createProject("MProject.project.core.ProjectImpl", projectId, title, description, completion);
		return project;
	}

    public HashMap<String, Object> updateProject(Map<String, Object> requestBody){
		String idStr = (String) requestBody.get("projectId");
		int id = Integer.parseInt(idStr);
		Project project = Repository.getObject(id);
		
		project.setTitle((String) requestBody.get("title"));
		project.setDescription((String) requestBody.get("description"));
		
		Repository.updateObject(project);
		
		//to do: fix association attributes
		
		return project.toHashMap();
		
	}

    public HashMap<String, Object> getProject(Map<String, Object> requestBody){
		List<HashMap<String, Object>> projectList = getAllProject("project_impl");
		for (HashMap<String, Object> project : projectList){
			int record_id = ((Double) project.get("record_id")).intValue();
			if (record_id == id){
				return project;
			}
		}
		return null;
	}

	public HashMap<String, Object> getProjectById(int id){
		String idStr = vmjExchange.getGETParam("projectId"); 
		int id = Integer.parseInt(idStr);
		Project project = projectRepository.getObject(id);
		return project.toHashMap();
	}

    public List<HashMap<String,Object>> getAllProject(Map<String, Object> requestBody){
		String table = (String) requestBody.get("table_name");
		List<Project> List = Repository.getAllObject(table);
		return transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<Project> List){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < List.size(); i++) {
            resultList.add(List.get(i).toHashMap());
        }

        return resultList;
	}

    public List<HashMap<String,Object>> deleteProject(Map<String, Object> requestBody){
		String idStr = ((String) requestBody.get("id"));
		int id = Integer.parseInt(idStr);
		Repository.deleteObject(id);
		return getAllProject(requestBody);
	}

}
