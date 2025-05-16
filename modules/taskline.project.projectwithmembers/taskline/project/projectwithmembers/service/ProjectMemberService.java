package taskline.project.projectwithmembers;
import java.util.*;

import vmj.routing.route.VMJExchange;

public interface ProjectMemberService {
    HashMap<String,Object> saveProjectMember(Map<String, Object> requestBody);
    List<HashMap<String,Object>> deleteProjectMember(Map<String, Object> requestBody);
    List<HashMap<String,Object>> getProjectMembers(String projectIdStr);
    List<HashMap<String,Object>> getProjectsByMember(String memberEmail);
	List<HashMap<String, Object>> transformListToHashMap(List<ProjectMember> projectMemberList);
}
