package taskline.member.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public interface MemberResource {
    List<HashMap<String,Object>> getAllMember(VMJExchange vmjExchange);
}
