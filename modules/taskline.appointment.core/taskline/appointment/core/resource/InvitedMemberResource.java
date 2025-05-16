package taskline.appointment.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public interface InvitedMemberResource {
    List<HashMap<String,Object>> saveInvitedMember(VMJExchange vmjExchange);
    HashMap<String, Object> updateInvitedMember(VMJExchange vmjExchange);
    HashMap<String, Object> getInvitedMember(VMJExchange vmjExchange);
    List<HashMap<String,Object>> getAllInvitedMember(VMJExchange vmjExchange);
    List<HashMap<String,Object>> deleteInvitedMember(VMJExchange vmjExchange);
	HashMap<String, Object> createInvitedMember(VMJExchange vmjExhange);
}
