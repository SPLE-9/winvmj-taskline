package taskline.appointment.core;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import vmj.routing.route.exceptions.*;
import taskline.appointment.InvitedMemberFactory;
//import prices.auth.vmj.annotations.Restricted;
//add other required packages

public class InvitedMemberResourceImpl extends InvitedMemberResourceComponent{
	
	private InvitedMemberServiceImpl invitedmemberServiceImpl = new InvitedMemberServiceImpl();

	// @Restriced(permission = "")
    @Route(url="call/appointment")
    public HashMap<String,Object> createinvitedmember(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			InvitedMember result = invitedmemberServiceImpl.createInvitedMember(requestBody);
			return result.toHashMap();
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

    // @Restriced(permission = "")
    @Route(url="call/appointment/update")
    public HashMap<String, Object> updateInvitedMember(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")){
			return null;
		}
		return invitedmemberServiceImpl.updateInvitedMember(requestBody);
		
	}

	// @Restriced(permission = "")
    @Route(url="call/appointment/detail")
    public HashMap<String, Object> getInvitedMember(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		return invitedmemberServiceImpl.getInvitedMember(requestBody);
	}

	// @Restriced(permission = "")
    @Route(url="call/appointment/list")
    public List<HashMap<String,Object>> getAllInvitedMember(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		return invitedmemberServiceImpl.getAllInvitedMember(requestBody);
	}

    
	// @Restriced(permission = "")
    @Route(url="call/appointment/delete")
    public List<HashMap<String,Object>> deleteInvitedMember(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		return invitedmemberServiceImpl.deleteInvitedMember(requestBody);
	}

}
