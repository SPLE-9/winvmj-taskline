package taskline.appointment.core;
import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;
//add other required packages

public abstract class InvitedUserServiceComponent implements InvitedUserService{
	protected RepositoryUtil<InvitedUser> invitedUserRepository;

    public InvitedUserServiceComponent(){
        this.invitedUserRepository = new RepositoryUtil<InvitedUser>(taskline.appointment.core.InvitedUserComponent.class);
    }	

    public abstract HashMap<String,Object> saveInvitedUser(Map<String, Object> requestBody);
	public abstract HashMap<String, Object> updateInvitedUser(Map<String, Object> requestBody);
    public abstract HashMap<String, Object> getInvitedUserById(String invitedUserId);
    public abstract List<HashMap<String,Object>> getAllInvitedUser();
    public abstract List<HashMap<String,Object>> transformListToHashMap(List<InvitedUser> invitedUserList);
    public abstract HashMap<String,Object> deleteInvitedUser(Map<String, Object> requestBody);

}
