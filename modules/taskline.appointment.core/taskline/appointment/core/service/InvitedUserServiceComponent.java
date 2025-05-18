package taskline.appointment.core;
import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;
//add other required packages

public abstract class InvitedMemberServiceComponent implements InvitedMemberService{
	protected RepositoryUtil<InvitedMember> Repository;

    public InvitedMemberServiceComponent(){
        this.Repository = new RepositoryUtil<InvitedMember>(taskline.appointment.core.InvitedMemberComponent.class);
    }	

    public abstract List<HashMap<String,Object>> saveInvitedMember(VMJExchange vmjExchange);
    public abstract InvitedMember createInvitedMember(Map<String, Object> requestBodye);
	public abstract InvitedMember createInvitedMember(Map<String, Object> requestBody, Map<String, Object> response);    
	public abstract HashMap<String, Object> updateInvitedMember(Map<String, Object> requestBody);
    public abstract HashMap<String, Object> getInvitedMember(Map<String, Object> requestBody);
    public abstract List<HashMap<String,Object>> getAllInvitedMember(Map<String, Object> requestBody);
    public abstract List<HashMap<String,Object>> transformListToHashMap(List<InvitedMember> List);
    public abstract List<HashMap<String,Object>> deleteInvitedMember(Map<String, Object> requestBody);
	public abstract HashMap<String, Object> getInvitedMemberById(int id);

}
