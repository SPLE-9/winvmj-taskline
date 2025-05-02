package taskline.project.core;
import java.util.*;
import com.google.gson.Gson;
import java.util.*;
import java.util.logging.Logger;
import java.io.File;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import vmj.routing.route.exceptions.*;
import taskline.project.ProjectFactory;
import prices.auth.vmj.annotations.Restricted;
//add other required packages

public class ProjectServiceImpl extends ProjectServiceComponent{
	private ProjectFactory projectFactory = new ProjectFactory();

	public HashMap<String,Object> saveProject(Map<String, Object> requestBody) {
		if (!requestBody.containsKey("title")) {
            throw new FieldValidationException("Field 'title' not found in the request body.");
        }

		String title = (String) body.get("title");

        validateUniqueProjectTitle(title);

		String description = requestBody.containsKey("description") ? (String) body.get("description") : "";

        UUID projectId = UUID.randomUUID();

		Project project = projectFactory.createProject("taskline.project.core.ProjectImpl", projectId, title, description);
		projectRepository.saveObject(project);
		
		return projectRepository.getObject(projectId).toHashMap();
	}

    public HashMap<String, Object> updateProject(Map<String, Object> requestBody) {
		if (!requestBody.containsKey("projectId")) {
    		throw new NotFoundException("Field 'projectId' not found in the request body.");
    	}

    	String projectIdStr = (String) requestBody.get("projectId");
    	UUID projectId = UUID.fromString(projectIdStr);

		Project project = projectRepository.getObject(projectId);
		if (project == null) {
	        throw new NotFoundException("Project with projectId " + projectId +" not found");
	    }

		if (requestBody.containsKey("title")) {
        	String title =  (String) requestBody.get("title");
            project.setTitle(title);
        }

		if (requestBody.containsKey("description")) {
        	String description =  (String) requestBody.get("description");
            project.setDescription(description);
        }

		// TODO: Handle completion calculation
		// project.setCompletion();

		projectRepository.updateObject(project);
		return projectRepository.getObject(projectId).toHashMap();
	}

	public HashMap<String, Object> getProject(String projectIdStr) {
		UUID projectId = UUID.fromString(projectIdStr);

		Project project = projectRepository.getObject(projectId);
		if (project == null) {
			throw new NotFoundException("Project with projectId " + projectId +" not found");
		}

		return project.toHashMap();
	}

    public List<HashMap<String,Object>> getAllProject() {
		List<Project> projectList = projectRepository.getAllObject("project_impl");
		return transformListToHashMap(projectList);
	}

    public List<HashMap<String,Object>> deleteProject(Map<String, Object> requestBody) {
		String projectIdStr = (String) body.get("projectId");
    	UUID projectId = UUID.fromString(projectIdStr);
		
		Project project = projectRepository.getObject(projectId);
		if (project == null) {
			throw new NotFoundException("Project with projectId " + projectId +" not found");
		}

		// TODO: Handle task deletion
		projectRepository.deleteObject(projectId);
		return getAllProject();
	}

	public List<HashMap<String, Object>> transformListToHashMap(List<Project> projectList) {
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(Project project : projectList) {
            resultList.add(projectList.get(i).toHashMap());
        }

        return resultList;
	}

	private void validateUniqueProjectTitle(String title) {
		List<Category> existingProjects = projectRepository.getListObject("project_impl", "title", title);
		if (!existingProjects.isEmpty()) {
            throw new BadRequestException("Project with title '" + title + "' already exists.");
        }
	}

}
