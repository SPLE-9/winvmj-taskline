package taskline.project.core;
import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;
//add other required packages

public abstract class ProjectResourceComponent implements ProjectResource{
    protected RepositoryUtil<Project> projectRepository;
	
	public ProjectResourceComponent() {
        this.projectRepository = new RepositoryUtil<Project>(taskline.project.core.ProjectComponent.class);
    }
 
    public abstract HashMap<String,Object> saveProject(VMJExchange vmjExchange);    
	public abstract HashMap<String, Object> updateProject(VMJExchange vmjExchange);
    public abstract HashMap<String, Object> getProject(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> getAllProject(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> deleteProject(VMJExchange vmjExchange);

}
