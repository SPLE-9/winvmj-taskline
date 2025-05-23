package taskline.project.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public abstract class ProjectServiceDecorator extends ProjectServiceComponent{
	protected ProjectServiceComponent record;

    public ProjectServiceDecorator(ProjectServiceComponent record) {
        this.record = record;
    }

	public HashMap<String,Object> saveProject(Map<String, Object> requestBody) {
		return record.saveProject(requestBody);
	}

    public HashMap<String, Object> updateProject(Map<String, Object> requestBody) {
		return record.updateProject(requestBody);
	}

	public HashMap<String, Object> getProject(String projectIdStr) {
		return record.getProject(projectIdStr);
	}

	public Project getProjectById(UUID projectId) {
		return record.getProjectById(projectId);
	}

    public List<HashMap<String,Object>> getAllProject() {
		return record.getAllProject();
	}

    public List<HashMap<String,Object>> deleteProject(Map<String, Object> requestBody) {
		return record.deleteProject(requestBody);
	}
	
	public List<HashMap<String, Object>> transformListToHashMap(List<Project> projectList) {
		return record.transformListToHashMap(projectList);
	}

}
