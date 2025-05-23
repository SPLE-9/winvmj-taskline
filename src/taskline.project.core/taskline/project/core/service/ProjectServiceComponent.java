package taskline.project.core;
import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;
//add other required packages

public abstract class ProjectServiceComponent implements ProjectService{
	protected RepositoryUtil<Project> projectRepository;

    public ProjectServiceComponent(){
        this.projectRepository = new RepositoryUtil<Project>(taskline.project.core.ProjectComponent.class);
    }

    public abstract HashMap<String,Object> saveProject(Map<String, Object> requestBody);
    public abstract HashMap<String, Object> updateProject(Map<String, Object> requestBody);
	public abstract HashMap<String, Object> getProject(String projectId);
    public abstract Project getProjectById(UUID projectId);
    public abstract List<HashMap<String,Object>> getAllProject();
    public abstract List<HashMap<String,Object>> deleteProject(Map<String, Object> requestBody);
	public abstract List<HashMap<String, Object>> transformListToHashMap(List<Project> projectList);

}
