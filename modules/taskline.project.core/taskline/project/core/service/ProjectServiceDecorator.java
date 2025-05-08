package taskline.project.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public abstract class ProjectServiceDecorator extends ProjectServiceComponent{
	protected ProjectServiceComponent record;

    public ProjectServiceDecorator(ProjectServiceComponent record) {
        this.record = record;
    }

	public ProjectImpl createProject(Map<String, Object> requestBody){
		return record.createProject(requestBody);
	}

    public Project createProject(Map<String, Object> requestBody, Map<String, Object> response){
		return record.createProject(requestBody, response);
	}

	public HashMap<String, Object> getProject(Map<String, Object> requestBody){
		return record.getProject(requestBody);
	}

	public List<HashMap<String,Object>> getAllProject(Map<String, Object> requestBody){
		return record.getAllProject(requestBody);
	}

    public List<HashMap<String,Object>> saveProject(VMJExchange vmjExchange){
		return record.saveProject(vmjExchange);
	}

    public HashMap<String, Object> updateProject(Map<String, Object> requestBody){
		return record.updateProject(requestBody);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<Project> List){
		return record.transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> deleteProject(Map<String, Object> requestBody){
		return record.deleteProject(requestBody);
	}

	public HashMap<String, Object> getProjectById(int id){
        return record.getProjectById(id);
    }

}
