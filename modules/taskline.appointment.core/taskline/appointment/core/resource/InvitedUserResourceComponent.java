package taskline.appointment.core;
import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;
//add other required packages

public abstract class InvitedUserResourceComponent implements InvitedUserResource{
	
	public InvitedUserResourceComponent() { }
 
    public abstract List<HashMap<String,Object>> saveInvitedUser(VMJExchange vmjExchange);
    public abstract InvitedUser createInvitedUser(VMJExchange vmjExchange);
	public abstract InvitedUser createInvitedUser(VMJExchange vmjExchange, int id);    
	public abstract HashMap<String, Object> updateInvitedUser(VMJExchange vmjExchange);
    public abstract HashMap<String, Object> getInvitedUser(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> getAllInvitedUser(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> deleteInvitedUser(VMJExchange vmjExchange);

}
