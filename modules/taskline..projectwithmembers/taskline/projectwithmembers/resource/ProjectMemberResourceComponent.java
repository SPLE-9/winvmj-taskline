package taskline..projectwithmembers;

import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;
//add other required packages

public abstract class ProjectMemberResourceComponent implements ProjectMemberResource{
	protected RepositoryUtil<ProjectMember> ProjectMemberRepository;

    public ProjectMemberResourceComponent(){
        this.ProjectMemberRepository = new RepositoryUtil<ProjectMember>(taskline.projectwithmembers.core.ProjectMemberComponent.class);
    }	

    public abstract List<HashMap<String,Object>> saveProjectMember(VMJExchange vmjExchange);
    public abstract ProjectMember createProjectMember(VMJExchange vmjExchange);
    public abstract HashMap<String, Object> updateProjectMember(VMJExchange vmjExchange);
    public abstract HashMap<String, Object> getProjectMember(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> getAllProjectMember(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> transformProjectMemberListToHashMap(List<ProjectMember> ProjectMemberList);
    public abstract List<HashMap<String,Object>> deleteProjectMember(VMJExchange vmjExchange);

	public abstract void getProjectsByMember(UUID memberId);

	public abstract void getProjectMembers(UUID projectId);
}
