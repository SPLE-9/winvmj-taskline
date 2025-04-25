package taskline.appointment.core;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import vmj.routing.route.exceptions.*;
//import prices.auth.vmj.annotations.Restricted;
//add other required packages

public class InvitedUserResourceImpl extends InvitedUserResourceComponent{
	
	private InvitedUserServiceImpl inviteduserServiceImpl = new InvitedUserServiceImpl();

	// @Restriced(permission = "")
    @Route(url="call/appointment")
    public HashMap<String,Object> saveInvitedUser(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload();
			return inviteduserServiceImpl.saveInvitedUser(requestBody);
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

    // @Restriced(permission = "")
    @Route(url="call/appointment/update")
    public HashMap<String, Object> updateInvitedUser(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("PUT")){
			Map<String, Object> requestBody = vmjExchange.getPayload(); 
			return inviteduserServiceImpl.updateInvitedUser(requestBody);
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

	// @Restriced(permission = "")
    @Route(url="call/appointment/detail")
    public HashMap<String, Object> getInvitedUserById(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("GET")) {
		    String invitedUserIdStr = vmjExchange.getGETParam("invitedUserId");
			return inviteduserServiceImpl.getInvitedUserById(invitedUserIdStr);
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

	// @Restriced(permission = "")
    @Route(url="call/appointment/list")
    public List<HashMap<String,Object>> getAllInvitedUser(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("GET")) {
			return inviteduserServiceImpl.getAllInvitedUser();
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

    
	// @Restriced(permission = "")
    @Route(url="call/appointment/delete")
    public HashMap<String,Object> deleteInvitedUser(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("DELETE")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			return inviteduserServiceImpl.deleteInvitedUser(requestBody);
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

}
