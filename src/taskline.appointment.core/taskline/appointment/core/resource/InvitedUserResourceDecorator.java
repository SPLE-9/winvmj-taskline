package taskline.appointment.core;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

public abstract class InvitedUserResourceDecorator extends InvitedUserResourceComponent{
	protected InvitedUserResourceComponent record;

    public InvitedUserResourceDecorator(InvitedUserResourceComponent record) {
        this.record = record;
    }

    public HashMap<String, Object> saveInvitedUser(VMJExchange vmjExchange){
		return record.saveInvitedUser(vmjExchange);
	}

    public HashMap<String, Object> updateInvitedUser(VMJExchange vmjExchange){
		return record.updateInvitedUser(vmjExchange);
	}

    public HashMap<String, Object> getInvitedUserById(VMJExchange vmjExchange){
		return record.getInvitedUserById(vmjExchange);
	}

    public List<HashMap<String,Object>> getAllInvitedUser(VMJExchange vmjExchange){
		return record.getAllInvitedUser(vmjExchange);
	}

    public HashMap<String,Object> deleteInvitedUser(VMJExchange vmjExchange){
		return record.deleteInvitedUser(vmjExchange);
	}

}
