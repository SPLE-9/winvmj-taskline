package taskline.appointment.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public abstract class InvitedMemberServiceDecorator extends InvitedMemberServiceComponent{
	protected InvitedMemberServiceComponent record;

    public InvitedMemberServiceDecorator(InvitedMemberServiceComponent record) {
        this.record = record;
    }

	public InvitedMemberImpl createInvitedMember(Map<String, Object> requestBody){
		return record.createInvitedMember(requestBody);
	}

    public InvitedMember createInvitedMember(Map<String, Object> requestBody, Map<String, Object> response){
		return record.createInvitedMember(requestBody, response);
	}

	public HashMap<String, Object> getInvitedMember(Map<String, Object> requestBody){
		return record.getInvitedMember(requestBody);
	}

	public List<HashMap<String,Object>> getAllInvitedMember(Map<String, Object> requestBody){
		return record.getAllInvitedMember(requestBody);
	}

    public List<HashMap<String,Object>> saveInvitedMember(VMJExchange vmjExchange){
		return record.saveInvitedMember(vmjExchange);
	}

    public HashMap<String, Object> updateInvitedMember(Map<String, Object> requestBody){
		return record.updateInvitedMember(requestBody);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<InvitedMember> List){
		return record.transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> deleteInvitedMember(Map<String, Object> requestBody){
		return record.deleteInvitedMember(requestBody);
	}

	public HashMap<String, Object> getInvitedMemberById(int id){
        return record.getInvitedMemberById(id);
    }

}
