package taskline.appointment.core;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import vmj.routing.route.exceptions.*;
import taskline.appointment.InvitedUserFactory;
import prices.auth.vmj.annotations.Restricted;
//add other required packages


public class InvitedUserResourceImpl extends InvitedUserResourceComponent{
	
	private InvitedUserServiceImpl inviteduserServiceImpl = new InvitedUserServiceImpl();

	// @Restriced(permission = "")
    @Route(url="call/appointment/save")
    public List<HashMap<String,Object>> saveInvitedUser(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		InvitedUser inviteduser = createInvitedUser(vmjExchange);
		inviteduserRepository.saveObject(inviteduser);
		return getAllInvitedUser(vmjExchange);
	}

	// @Restriced(permission = "")
    @Route(url="call/appointment")
    public HashMap<String,Object> inviteduser(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			InvitedUser result = inviteduserServiceImpl.createInvitedUser(requestBody);
			return result.toHashMap();
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

    public InvitedUser createInvitedUser(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			InvitedUser result = inviteduserServiceImpl.createInvitedUser(requestBody);
			return result.toHashMap();
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

    public InvitedUser createInvitedUser(VMJExchange vmjExchange, int id){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			InvitedUser result = inviteduserServiceImpl.createInvitedUser(requestBody, id);
			return result.toHashMap();
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

	// @Restriced(permission = "")
    @Route(url="call/appointment/update")
    public HashMap<String, Object> updateInvitedUser(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")){
			return null;
		}
		return inviteduserServiceImpl.updateInvitedUser(requestBody);
		
	}

	// @Restriced(permission = "")
    @Route(url="call/appointment/detail")
    public HashMap<String, Object> getInvitedUser(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		return inviteduserServiceImpl.getInvitedUser(requestBody);
	}

	// @Restriced(permission = "")
    @Route(url="call/appointment/list")
    public List<HashMap<String,Object>> getAllInvitedUser(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		return inviteduserServiceImpl.getAllInvitedUser(requestBody);
	}

	// @Restriced(permission = "")
    @Route(url="call/appointment/delete")
    public List<HashMap<String,Object>> deleteInvitedUser(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		return inviteduserServiceImpl.deleteInvitedUser(requestBody);
	}


}
