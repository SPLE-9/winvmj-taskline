package taskline.appointment.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public interface InvitedUserService {
	InvitedUser createInvitedUser(Map<String, Object> requestBody);
	InvitedUser createInvitedUser(Map<String, Object> requestBody, Map<String, Object> response);
	HashMap<String, Object> getInvitedUser(Map<String, Object> requestBody);
    List<HashMap<String,Object>> saveInvitedUser(Map<String, Object> requestBody);
    HashMap<String, Object> updateInvitedUser(Map<String, Object> requestBody);
    HashMap<String, Object> getInvitedUserById(int id);
    List<HashMap<String,Object>> getAllInvitedUser(Map<String, Object> requestBody);
    List<HashMap<String,Object>> deleteInvitedUser(Map<String, Object> requestBody);
	List<HashMap<String, Object>> transformListToHashMap(List<Disbursement> List);
}
