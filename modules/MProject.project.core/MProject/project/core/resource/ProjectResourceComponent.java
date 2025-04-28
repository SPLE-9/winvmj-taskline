package MProject.project.core;
import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;
//add other required packages

public abstract class ProjectResourceComponent implements ProjectResource{
	
	public ProjectResourceComponent() { }
 
    public abstract List<HashMap<String,Object>> saveProject(VMJExchange vmjExchange);
    public abstract Project createProject(VMJExchange vmjExchange);
	public abstract Project createProject(VMJExchange vmjExchange, int id);    
	public abstract HashMap<String, Object> updateProject(VMJExchange vmjExchange);
    public abstract HashMap<String, Object> getProject(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> getAllProject(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> deleteProject(VMJExchange vmjExchange);

}
