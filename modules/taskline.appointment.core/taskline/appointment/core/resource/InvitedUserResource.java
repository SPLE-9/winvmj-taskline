package taskline.appointment.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public interface InvitedUserResource {
    List<HashMap<String,Object>> saveInvitedUser(VMJExchange vmjExchange);
    HashMap<String, Object> updateInvitedUser(VMJExchange vmjExchange);
    HashMap<String, Object> getInvitedUser(VMJExchange vmjExchange);
    List<HashMap<String,Object>> getAllInvitedUser(VMJExchange vmjExchange);
    List<HashMap<String,Object>> deleteInvitedUser(VMJExchange vmjExchange);
	HashMap<String, Object> InvitedUser(VMJExchange vmjExhange);
}
