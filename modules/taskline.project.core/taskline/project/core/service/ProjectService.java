package taskline.project.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public interface ProjectService {
	HashMap<String,Object> saveProject(Map<String, Object> requestBody);
    HashMap<String, Object> updateProject(Map<String, Object> requestBody);
	HashMap<String, Object> getProject(String projectId);
    List<HashMap<String,Object>> getAllProject();
    List<HashMap<String,Object>> deleteProject(Map<String, Object> requestBody);
	List<HashMap<String, Object>> transformListToHashMap(List<Project> projectList);
}
