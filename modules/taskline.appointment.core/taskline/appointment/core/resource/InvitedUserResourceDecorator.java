package taskline.appointment.core;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

public abstract class InvitedUserResourceDecorator extends InvitedUserResourceComponent{
	protected InvitedUserResourceComponent record;

    public InvitedUserResourceDecorator(InvitedUserResourceComponent record) {
        this.record = record;
    }

    public List<HashMap<String,Object>> saveInvitedUser(VMJExchange vmjExchange){
		return record.saveInvitedUser(vmjExchange);
	}

    public InvitedUser createInvitedUser(VMJExchange vmjExchange){
		return record.createInvitedUser(vmjExchange);
	}

    public InvitedUser createInvitedUser(VMJExchange vmjExchange, int id){
		return record.createInvitedUser(vmjExchange, id);
	}

    public HashMap<String, Object> updateInvitedUser(VMJExchange vmjExchange){
		return record.updateInvitedUser(vmjExchange);
	}

    public HashMap<String, Object> getInvitedUser(VMJExchange vmjExchange){
		return record.getInvitedUser(vmjExchange);
	}

    public List<HashMap<String,Object>> getAllInvitedUser(VMJExchange vmjExchange){
		return record.getAllInvitedUser(vmjExchange);
	}

    public List<HashMap<String,Object>> deleteInvitedUser(VMJExchange vmjExchange){
		return record.deleteInvitedUser(vmjExchange);
	}

}
