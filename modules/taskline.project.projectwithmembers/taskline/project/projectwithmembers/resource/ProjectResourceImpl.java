package taskline.project.projectwithmembers;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import taskline.project.core.ProjectResourceDecorator;
import taskline.project.core.ProjectImpl;
import taskline.project.core.ProjectResourceComponent;

public class ProjectResourceImpl extends ProjectResourceDecorator {
    public ProjectResourceImpl (ProjectResourceComponent record) {
        super(record);
    }

    // @Restriced(permission = "")
    @Route(url="call/projectwithmembers/save")
    public List<HashMap<String,Object>> save(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		ProjectProjectWithMembers projectprojectwithmembers = createProjectProjectWithMembers(vmjExchange);
		projectprojectwithmembersRepository.saveObject(projectprojectwithmembers);
		return getAllProjectProjectWithMembers(vmjExchange);
	}

    public Project createProjectProjectWithMembers(VMJExchange vmjExchange){
		
		ProjectProjectWithMembers projectprojectwithmembers = record.createProjectProjectWithMembers(vmjExchange);
		ProjectProjectWithMembers projectprojectwithmembersdeco = ProjectProjectWithMembersFactory.createProjectProjectWithMembers("taskline.projectwithmembers.core.ProjectImpl", projectprojectwithmembers, projectId, title, description, completion
		);
			return projectprojectwithmembersdeco;
	}


    public Project createProjectProjectWithMembers(VMJExchange vmjExchange, int id){
		ProjectProjectWithMembers projectprojectwithmembers = projectprojectwithmembersRepository.getObject(id);
		int recordProjectProjectWithMembersId = (((ProjectProjectWithMembersDecorator) savedProjectProjectWithMembers.getRecord()).getId();
		
		ProjectProjectWithMembers projectprojectwithmembers = record.createProjectProjectWithMembers(vmjExchange);
		ProjectProjectWithMembers projectprojectwithmembersdeco = ProjectProjectWithMembersFactory.createProjectProjectWithMembers("taskline.projectwithmembers.core.ProjectImpl", id, projectprojectwithmembers, projectId, title, description, completion
		);
			return projectprojectwithmembersdeco;
	}

	// @Restriced(permission = "")
    @Route(url="call/projectwithmembers/update")
    public HashMap<String, Object> updateProjectProjectWithMembers(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		String idStr = (String) vmjExchange.getRequestBodyForm("projectId");
		int id = Integer.parseInt(idStr);
		
		ProjectProjectWithMembers projectprojectwithmembers = projectprojectwithmembersRepository.getObject(id);
		projectprojectwithmembers = createProjectProjectWithMembers(vmjExchange, id);
		
		projectprojectwithmembersRepository.updateObject(projectprojectwithmembers);
		projectprojectwithmembers = projectprojectwithmembersRepository.getObject(id);
		//to do: fix association attributes
		
		return projectprojectwithmembers.toHashMap();
		
	}

	// @Restriced(permission = "")
    @Route(url="call/projectwithmembers/detail")
    public HashMap<String, Object> getProjectProjectWithMembers(VMJExchange vmjExchange){
		return record.getProjectProjectWithMembers(vmjExchange);
	}

	// @Restriced(permission = "")
    @Route(url="call/projectwithmembers/list")
    public List<HashMap<String,Object>> getAllProjectProjectWithMembers(VMJExchange vmjExchange){
		List<ProjectProjectWithMembers> projectprojectwithmembersList = projectprojectwithmembersRepository.getAllObject("projectprojectwithmembers_impl");
		return transformProjectProjectWithMembersListToHashMap(projectprojectwithmembersList);
	}

    public List<HashMap<String,Object>> transformProjectProjectWithMembersListToHashMap(List<ProjectProjectWithMembers> ProjectProjectWithMembersList){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < ProjectProjectWithMembersList.size(); i++) {
            resultList.add(ProjectProjectWithMembersList.get(i).toHashMap());
        }

        return resultList;
	}

	// @Restriced(permission = "")
    @Route(url="call/projectwithmembers/delete")
    public List<HashMap<String,Object>> deleteProjectProjectWithMembers(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		String idStr = (String) vmjExchange.getRequestBodyForm("projectId");
		int id = Integer.parseInt(idStr);
		projectprojectwithmembersRepository.deleteObject(id);
		return getAllProjectProjectWithMembers(vmjExchange);
	}

	public void getProjectsByUser(UUID userId) {
		// TODO: implement this method
	}
	
}
