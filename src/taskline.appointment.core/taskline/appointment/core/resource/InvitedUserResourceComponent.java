package taskline.appointment.core;
import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;
//add other required packages

public abstract class InvitedUserResourceComponent implements InvitedUserResource{
    protected RepositoryUtil<InvitedUser> invitedUserRepository;
	
	public InvitedUserResourceComponent() {
        this.invitedUserRepository = new RepositoryUtil<InvitedUser>(taskline.appointment.core.InvitedUserComponent.class);
    }
 
    public abstract HashMap<String, Object> saveInvitedUser(VMJExchange vmjExchange);    
	public abstract HashMap<String, Object> updateInvitedUser(VMJExchange vmjExchange);
    public abstract HashMap<String, Object> getInvitedUserById(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> getAllInvitedUser(VMJExchange vmjExchange);
    public abstract HashMap<String,Object> deleteInvitedUser(VMJExchange vmjExchange);

}
