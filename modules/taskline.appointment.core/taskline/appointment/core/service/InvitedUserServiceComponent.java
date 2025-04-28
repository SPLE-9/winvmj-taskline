package taskline.appointment.core;
import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;
//add other required packages

public abstract class InvitedUserServiceComponent implements InvitedUserService{
	protected RepositoryUtil<InvitedUser> Repository;

    public InvitedUserServiceComponent(){
        this.Repository = new RepositoryUtil<InvitedUser>(taskline.appointment.core.InvitedUserComponent.class);
    }	

    public abstract List<HashMap<String,Object>> saveInvitedUser(VMJExchange vmjExchange);
    public abstract InvitedUser createInvitedUser(Map<String, Object> requestBodye);
	public abstract InvitedUser createInvitedUser(Map<String, Object> requestBody, Map<String, Object> response);    
	public abstract HashMap<String, Object> updateInvitedUser(Map<String, Object> requestBody);
    public abstract HashMap<String, Object> getInvitedUser(Map<String, Object> requestBody);
    public abstract List<HashMap<String,Object>> getAllInvitedUser(Map<String, Object> requestBody);
    public abstract List<HashMap<String,Object>> transformListToHashMap(List<InvitedUser> List);
    public abstract List<HashMap<String,Object>> deleteInvitedUser(Map<String, Object> requestBody);
	public abstract HashMap<String, Object> getInvitedUserById(int id);

}
