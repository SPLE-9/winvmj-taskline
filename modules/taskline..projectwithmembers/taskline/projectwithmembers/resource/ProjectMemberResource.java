package taskline..projectwithmembers;
import java.util.*;

import vmj.routing.route.VMJExchange;

public interface ProjectMemberResource {
    List<HashMap<String,Object>> saveProjectMember(VMJExchange vmjExchange);
    HashMap<String, Object> updateProjectMember(VMJExchange vmjExchange);
    HashMap<String, Object> getProjectMember(VMJExchange vmjExchange);
    List<HashMap<String,Object>> getAllProjectMember(VMJExchange vmjExchange);
    List<HashMap<String,Object>> deleteProjectMember(VMJExchange vmjExchange);
}
