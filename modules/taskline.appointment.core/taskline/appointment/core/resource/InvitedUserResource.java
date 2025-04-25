package taskline.appointment.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public interface InvitedUserResource {
    HashMap<String,Object> saveInvitedUser(VMJExchange vmjExchange);
    HashMap<String, Object> updateInvitedUser(VMJExchange vmjExchange);
    HashMap<String, Object> getInvitedUserById(VMJExchange vmjExchange);
    HashMap<String,Object> deleteInvitedUser(VMJExchange vmjExchange);
    List<HashMap<String,Object>> getAllInvitedUser(VMJExchange vmjExchange);
}
