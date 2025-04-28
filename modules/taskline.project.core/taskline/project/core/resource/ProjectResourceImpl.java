package taskline.project.core;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import vmj.routing.route.exceptions.*;
import taskline.project.ProjectFactory;
import prices.auth.vmj.annotations.Restricted;
//add other required packages


public class ProjectResourceImpl extends ProjectResourceComponent{
	
	private ProjectServiceImpl projectServiceImpl = new ProjectServiceImpl();

	// @Restriced(permission = "")
    @Route(url="call/project/save")
    public List<HashMap<String,Object>> saveProject(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		Project project = createProject(vmjExchange);
		projectRepository.saveObject(project);
		return getAllProject(vmjExchange);
	}

	// @Restriced(permission = "")
    @Route(url="call/project")
    public HashMap<String,Object> project(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			Project result = projectServiceImpl.createProject(requestBody);
			return result.toHashMap();
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

    public Project createProject(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			Project result = projectServiceImpl.createProject(requestBody);
			return result.toHashMap();
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

    public Project createProject(VMJExchange vmjExchange, int id){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			Project result = projectServiceImpl.createProject(requestBody, id);
			return result.toHashMap();
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

	// @Restriced(permission = "")
    @Route(url="call/project/update")
    public HashMap<String, Object> updateProject(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")){
			return null;
		}
		return projectServiceImpl.updateProject(requestBody);
		
	}

	// @Restriced(permission = "")
    @Route(url="call/project/detail")
    public HashMap<String, Object> getProject(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		return projectServiceImpl.getProject(requestBody);
	}

	// @Restriced(permission = "")
    @Route(url="call/project/list")
    public List<HashMap<String,Object>> getAllProject(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		return projectServiceImpl.getAllProject(requestBody);
	}

	// @Restriced(permission = "")
    @Route(url="call/project/delete")
    public List<HashMap<String,Object>> deleteProject(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		return projectServiceImpl.deleteProject(requestBody);
	}


}
