package taskline.appointment.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public interface InvitedUserService {
	HashMap<String, Object> saveInvitedUser(Map<String, Object> requestBody);
    HashMap<String, Object> updateInvitedUser(Map<String, Object> requestBody);
    HashMap<String, Object> getInvitedUserById(String invitedUserId);
    List<HashMap<String,Object>> getAllInvitedUser();
    HashMap<String,Object> deleteInvitedUser(Map<String, Object> requestBody);
	List<HashMap<String, Object>> transformListToHashMap(List<InvitedUser> invitedUserList);
}
