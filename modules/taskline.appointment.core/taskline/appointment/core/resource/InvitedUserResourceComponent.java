package taskline.appointment.core;
import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;
//add other required packages

public abstract class InvitedMemberResourceComponent implements InvitedMemberResource{
	
	public InvitedMemberResourceComponent() { }
 
    public abstract InvitedMember createInvitedMember(VMJExchange vmjExchange);    
	public abstract HashMap<String, Object> updateInvitedMember(VMJExchange vmjExchange);
    public abstract HashMap<String, Object> getInvitedMember(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> getAllInvitedMember(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> deleteInvitedMember(VMJExchange vmjExchange);

}
