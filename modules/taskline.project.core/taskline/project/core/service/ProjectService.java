package taskline.project.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public interface ProjectService {
	Project createProject(Map<String, Object> requestBody);
	Project createProject(Map<String, Object> requestBody, Map<String, Object> response);
	HashMap<String, Object> getProject(Map<String, Object> requestBody);
    List<HashMap<String,Object>> saveProject(Map<String, Object> requestBody);
    HashMap<String, Object> updateProject(Map<String, Object> requestBody);
    HashMap<String, Object> getProjectById(int id);
    List<HashMap<String,Object>> getAllProject(Map<String, Object> requestBody);
    List<HashMap<String,Object>> deleteProject(Map<String, Object> requestBody);
	List<HashMap<String, Object>> transformListToHashMap(List<Disbursement> List);
}
