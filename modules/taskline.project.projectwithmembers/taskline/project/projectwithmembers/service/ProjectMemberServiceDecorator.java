package taskline.project.projectwithmembers;

import java.util.*;

import vmj.routing.route.VMJExchange;

public abstract class ProjectMemberServiceDecorator extends ProjectMemberServiceComponent {
    protected ProjectMemberServiceComponent record;

    public ProjectMemberServiceDecorator(ProjectMemberServiceComponent record) {
        this.record = record;
    }

	public HashMap<String,Object> saveProjectMember(Map<String, Object> requestBody) {
		return record.saveProjectMember(requestBody);
	}

    public List<HashMap<String,Object>> deleteProjectMember(Map<String, Object> requestBody) {
		return record.deleteProjectMember(requestBody);
	}

    public List<HashMap<String,Object>> getProjectMembers(String projectIdStr) {
        return record.getProjectMembers(projectIdStr);
    }

    public List<HashMap<String,Object>> getProjectsByMember(String memberEmail) {
        return record.getProjectsByMember(memberEmail);
    }
	
	public List<HashMap<String, Object>> transformListToHashMap(List<ProjectMember> projectMemberList) {
		return record.transformListToHashMap(projectMemberList);
	}
    
}
