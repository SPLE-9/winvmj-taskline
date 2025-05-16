package taskline.project.projectwithmembers;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import vmj.routing.route.exceptions.*;

import taskline.project.core.*;

public class ProjectResourceImpl extends ProjectResourceDecorator {
	private ProjectMemberService projectMemberService = new ProjectMemberServiceImpl();
    
	public ProjectResourceImpl (ProjectResourceComponent recordResource) {
        super(recordResource);
    }

    // @Restriced(permission = "")
    @Route(url="call/projectwithmembers/saveprojectmember")
    public HashMap<String,Object> saveProjectMember(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			return projectMemberService.saveProjectMember(requestBody);
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

	// @Restriced(permission = "")
    @Route(url="call/projectwithmembers/deleteprojectmember")
    public List<HashMap<String,Object>> deleteProjectMember(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("DELETE")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			return projectMemberService.deleteProjectMember(requestBody);
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

	// @Restriced(permission = "")
    @Route(url="call/projectwithmembers/projectmemberlist")
    public List<HashMap<String,Object>> getProjectMembers(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("GET")) {
		    String projectIdStr = vmjExchange.getGETParam("projectId"); 
			return projectMemberService.getProjectMembers(projectIdStr);
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

	// @Restriced(permission = "")
    @Route(url="call/projectwithmembers/myprojects")
    public List<HashMap<String,Object>> getProjectsByMember(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("GET")) {
		    String memberEmail = vmjExchange.getAuthPayload().getEmail(); 
			return projectMemberService.getProjectsByMember(memberEmail);
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

}
