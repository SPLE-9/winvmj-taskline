package taskline.project.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public interface ProjectResource {
    List<HashMap<String,Object>> saveProject(VMJExchange vmjExchange);
    HashMap<String, Object> updateProject(VMJExchange vmjExchange);
    HashMap<String, Object> getProject(VMJExchange vmjExchange);
    List<HashMap<String,Object>> getAllProject(VMJExchange vmjExchange);
    List<HashMap<String,Object>> deleteProject(VMJExchange vmjExchange);
	HashMap<String, Object> createProject(VMJExchange vmjExhange);
}
