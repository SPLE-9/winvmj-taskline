package taskline.project.core;
import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;
//add other required packages

public abstract class ProjectServiceComponent implements ProjectService{
	protected RepositoryUtil<Project> Repository;

    public ProjectServiceComponent(){
        this.Repository = new RepositoryUtil<Project>(taskline.project.core.ProjectComponent.class);
    }	

    public abstract List<HashMap<String,Object>> saveProject(VMJExchange vmjExchange);
    public abstract Project createProject(Map<String, Object> requestBodye);
	public abstract Project createProject(Map<String, Object> requestBody, Map<String, Object> response);    
	public abstract HashMap<String, Object> updateProject(Map<String, Object> requestBody);
    public abstract HashMap<String, Object> getProject(Map<String, Object> requestBody);
    public abstract List<HashMap<String,Object>> getAllProject(Map<String, Object> requestBody);
    public abstract List<HashMap<String,Object>> transformListToHashMap(List<Project> List);
    public abstract List<HashMap<String,Object>> deleteProject(Map<String, Object> requestBody);
	public abstract HashMap<String, Object> getProjectById(int id);

}
