package taskline.project.core;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import vmj.routing.route.exceptions.*;
import taskline.project.ProjectFactory;
import taskline.project.ProjectService;
//import prices.auth.vmj.annotations.Restricted;
//add other required packages

public class ProjectResourceImpl extends ProjectResourceComponent{
	
	private ProjectService projectService = new ProjectServiceImpl();

	// @Restriced(permission = "")
    @Route(url="call/project/save")
    public HashMap<String,Object> saveProject(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			return projectService.saveProject(requestBody);
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

    // @Restriced(permission = "")
    @Route(url="call/project/update")
    public HashMap<String, Object> updateProject(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("PUT")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			return projectService.updateProject(requestBody);
		}
		throw new NotFoundException("Route tidak ditemukan");
		
	}

	// @Restriced(permission = "")
    @Route(url="call/project/detail")
    public HashMap<String, Object> getProject(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("GET")) {
		    String projectIdStr = vmjExchange.getGETParam("projectId");
			return projectService.getProject(projectIdStr);
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

	// @Restriced(permission = "")
    @Route(url="call/project/list")
    public List<HashMap<String,Object>> getAllProject(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("GET")) {
		    return projectService.getAllProject();
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

    
	// @Restriced(permission = "")
    @Route(url="call/project/delete")
    public List<HashMap<String,Object>> deleteProject(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("DELETE")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			return projectService.deleteProject(requestBody);
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

}
