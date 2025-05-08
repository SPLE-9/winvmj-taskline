package taskline.appointment.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public abstract class InvitedUserServiceDecorator extends InvitedUserServiceComponent{
	protected InvitedUserServiceComponent record;

    public InvitedUserServiceDecorator(InvitedUserServiceComponent record) {
        this.record = record;
    }

	public InvitedUserImpl createInvitedUser(Map<String, Object> requestBody){
		return record.createInvitedUser(requestBody);
	}

    public InvitedUser createInvitedUser(Map<String, Object> requestBody, Map<String, Object> response){
		return record.createInvitedUser(requestBody, response);
	}

	public HashMap<String, Object> getInvitedUser(Map<String, Object> requestBody){
		return record.getInvitedUser(requestBody);
	}

	public List<HashMap<String,Object>> getAllInvitedUser(Map<String, Object> requestBody){
		return record.getAllInvitedUser(requestBody);
	}

    public List<HashMap<String,Object>> saveInvitedUser(VMJExchange vmjExchange){
		return record.saveInvitedUser(vmjExchange);
	}

    public HashMap<String, Object> updateInvitedUser(Map<String, Object> requestBody){
		return record.updateInvitedUser(requestBody);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<InvitedUser> List){
		return record.transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> deleteInvitedUser(Map<String, Object> requestBody){
		return record.deleteInvitedUser(requestBody);
	}

	public HashMap<String, Object> getInvitedUserById(int id){
        return record.getInvitedUserById(id);
    }

}
