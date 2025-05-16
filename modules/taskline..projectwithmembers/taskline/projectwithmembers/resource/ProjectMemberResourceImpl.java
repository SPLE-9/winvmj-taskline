package taskline..projectwithmembers;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import taskline.projectwithmembers.ProjectMemberFactory;
import prices.auth.vmj.annotations.Restricted;
//add other required packages

public class ProjectMemberResourceImpl extends ProjectMemberResourceComponent{
	protected ProjectMemberResourceComponent record;

	// @Restriced(permission = "")
    @Route(url="call/projectwithmembers/save")
    public List<HashMap<String,Object>> saveProjectMember(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		ProjectMember projectmember = createProjectMember(vmjExchange);
		projectmemberRepository.saveObject(projectmember);
		return getAllProjectMember(vmjExchange);
	}

    public ProjectMember createProjectMember(VMJExchange vmjExchange){
		
		//to do: fix association attributes
		
		ProjectMember projectmember = ProjectMemberFactory.createProjectMember("taskline.projectwithmembers.core.ProjectMemberImpl", projectMemberId, projectimpl, memberimpl);
			return projectmember;
	}

    // @Restriced(permission = "")
    @Route(url="call/projectwithmembers/update")
    public HashMap<String, Object> updateProjectMember(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		String idStr = (String) vmjExchange.getRequestBodyForm("projectMemberId");
		int id = Integer.parseInt(idStr);
		
		ProjectMember projectmember = projectmemberRepository.getObject(id);
		
		projectmemberRepository.updateObject(projectmember);
		projectmember = projectmemberRepository.getObject(id);
		//to do: fix association attributes
		
		return projectmember.toHashMap();
		
	}

	// @Restriced(permission = "")
    @Route(url="call/projectwithmembers/detail")
    public HashMap<String, Object> getProjectMember(VMJExchange vmjExchange){
		String idStr = vmjExchange.getGETParam("projectMemberId"); 
		int id = Integer.parseInt(idStr);
		ProjectMember projectmember = projectmemberRepository.getObject(id);
		return projectmember.toHashMap();
	}

	// @Restriced(permission = "")
    @Route(url="call/projectwithmembers/list")
    public List<HashMap<String,Object>> getAllProjectMember(VMJExchange vmjExchange){
		List<ProjectMember> projectmemberList = projectmemberRepository.getAllObject("projectmember_impl");
		return transformProjectMemberListToHashMap(projectmemberList);
	}

    public List<HashMap<String,Object>> transformProjectMemberListToHashMap(List<ProjectMember> ProjectMemberList){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < ProjectMemberList.size(); i++) {
            resultList.add(ProjectMemberList.get(i).toHashMap());
        }

        return resultList;
	}

	// @Restriced(permission = "")
    @Route(url="call/projectwithmembers/delete")
    public List<HashMap<String,Object>> deleteProjectMember(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		String idStr = (String) vmjExchange.getRequestBodyForm("projectMemberId");
		int id = Integer.parseInt(idStr);
		projectmemberRepository.deleteObject(id);
		return getAllProjectMember(vmjExchange);
	}

	public void getProjectsByMember(UUID memberId) {
		// TODO: implement this method
	}

	public void getProjectMembers(UUID projectId) {
		// TODO: implement this method
	}
}
