package taskline.project.projectwithmembers;

import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;

public abstract class ProjectMemberServiceComponent implements ProjectMemberService {
    protected RepositoryUtil<ProjectMember> projectMemberRepository;

    public ProjectMemberServiceComponent(){
        this.projectMemberRepository = new RepositoryUtil<ProjectMember>(taskline.project.projectwithmembers.ProjectMemberComponent.class);
    }

    public abstract HashMap<String,Object> saveProjectMember(Map<String, Object> requestBody);
    public abstract List<HashMap<String,Object>> deleteProjectMember(Map<String, Object> requestBody);
    public abstract List<HashMap<String,Object>> getProjectMembers(String projectIdStr);
    public abstract List<HashMap<String,Object>> getProjectsByMember(String memberEmail);
	public abstract List<HashMap<String, Object>> transformListToHashMap(List<ProjectMember> projectMemberList);
    
}
