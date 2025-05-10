package taskline.appointment.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public interface InvitedMemberService {
	InvitedMember createInvitedMember(Map<String, Object> requestBody);
	InvitedMember createInvitedMember(Map<String, Object> requestBody, Map<String, Object> response);
	HashMap<String, Object> getInvitedMember(Map<String, Object> requestBody);
    List<HashMap<String,Object>> saveInvitedMember(Map<String, Object> requestBody);
    HashMap<String, Object> updateInvitedMember(Map<String, Object> requestBody);
    HashMap<String, Object> getInvitedMemberById(int id);
    List<HashMap<String,Object>> getAllInvitedMember(Map<String, Object> requestBody);
    List<HashMap<String,Object>> deleteInvitedMember(Map<String, Object> requestBody);
	List<HashMap<String, Object>> transformListToHashMap(List<Disbursement> List);
}
