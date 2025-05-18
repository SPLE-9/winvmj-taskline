package taskline.appointment.core;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

public abstract class InvitedMemberResourceDecorator extends InvitedMemberResourceComponent{
	protected InvitedMemberResourceComponent record;

    public InvitedMemberResourceDecorator(InvitedMemberResourceComponent record) {
        this.record = record;
    }

    public InvitedMember createInvitedMember(VMJExchange vmjExchange){
		return record.createInvitedMember(vmjExchange);
	}

    public HashMap<String, Object> updateInvitedMember(VMJExchange vmjExchange){
		return record.updateInvitedMember(vmjExchange);
	}

    public HashMap<String, Object> getInvitedMember(VMJExchange vmjExchange){
		return record.getInvitedMember(vmjExchange);
	}

    public List<HashMap<String,Object>> getAllInvitedMember(VMJExchange vmjExchange){
		return record.getAllInvitedMember(vmjExchange);
	}

    public List<HashMap<String,Object>> deleteInvitedMember(VMJExchange vmjExchange){
		return record.deleteInvitedMember(vmjExchange);
	}

}
