package taskline.member.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public interface MemberService {
	Member getMemberByEmail(String email);
	Member getMemberById(UUID memberId);
	List<HashMap<String,Object>> getAllMember();
	List<HashMap<String, Object>> transformListToHashMap(List<Member> memberList);
}
