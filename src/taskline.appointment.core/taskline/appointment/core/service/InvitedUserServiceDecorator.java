package taskline.appointment.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public abstract class InvitedUserServiceDecorator extends InvitedUserServiceComponent{
	protected InvitedUserServiceComponent record;

    public InvitedUserServiceDecorator(InvitedUserServiceComponent record) {
        this.record = record;
    }

	public HashMap<String, Object> saveInvitedUser(Map<String, Object> requestBody){
		return record.saveInvitedUser(requestBody);
	}

	public HashMap<String, Object> getInvitedUserById(String invitedUserId){
		return record.getInvitedUserById(invitedUserId);
	}

	public List<HashMap<String,Object>> getAllInvitedUser(){
		return record.getAllInvitedUser();
	}

    public HashMap<String, Object> updateInvitedUser(Map<String, Object> requestBody){
		return record.updateInvitedUser(requestBody);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<InvitedUser> invitedUserList){
		return record.transformListToHashMap(invitedUserList);
	}

    public HashMap<String,Object> deleteInvitedUser(Map<String, Object> requestBody){
		return record.deleteInvitedUser(requestBody);
	}
}
