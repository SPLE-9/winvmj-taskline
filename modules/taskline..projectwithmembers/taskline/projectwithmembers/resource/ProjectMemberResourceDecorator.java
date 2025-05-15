package taskline..projectwithmembers;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

public abstract class ProjectMemberResourceDecorator extends ProjectMemberResourceComponent{
	protected ProjectMemberResourceComponent record;

    public ProjectMemberResourceDecorator(ProjectMemberResourceComponent record) {
        this.record = record;
    }

    public List<HashMap<String,Object>> saveProjectMember(VMJExchange vmjExchange){
		return record.saveProjectMember(vmjExchange);
	}

    public ProjectMember createProjectMember(VMJExchange vmjExchange){
		return record.createProjectMember(vmjExchange);
	}

    public HashMap<String, Object> updateProjectMember(VMJExchange vmjExchange){
		return record.updateProjectMember(vmjExchange);
	}

    public HashMap<String, Object> getProjectMember(VMJExchange vmjExchange){
		return record.getProjectMember(vmjExchange);
	}

    public List<HashMap<String,Object>> getAllProjectMember(VMJExchange vmjExchange){
		return record.getAllProjectMember(vmjExchange);
	}

    public List<HashMap<String,Object>> transformProjectMemberListToHashMap(List<ProjectMember> projectmemberList){
		return record.transformProjectMemberListToHashMap(projectmemberList);
	}

    public List<HashMap<String,Object>> deleteProjectMember(VMJExchange vmjExchange){
		return record.deleteProjectMember(vmjExchange);
	}

	public void getProjectsByMember(UUID memberId) {
		return record.getProjectsByMember(memberId);
	}

	public void getProjectMembers(UUID projectId) {
		return record.getProjectMembers(projectId);
	}
}
