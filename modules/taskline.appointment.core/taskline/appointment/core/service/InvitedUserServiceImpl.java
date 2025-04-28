package taskline.appointment.core;
import java.util.*;
import com.google.gson.Gson;
import java.util.*;
import java.util.logging.Logger;
import java.io.File;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import vmj.routing.route.exceptions.*;
import taskline.appointment.InvitedUserFactory;
import prices.auth.vmj.annotations.Restricted;
//add other required packages

public class InvitedUserServiceImpl extends InvitedUserServiceComponent{

    public List<HashMap<String,Object>> saveInvitedUser(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		InvitedUser inviteduser = createInvitedUser(vmjExchange);
		inviteduserRepository.saveObject(inviteduser);
		return getAllInvitedUser(vmjExchange);
	}

    public InvitedUser createInvitedUser(Map<String, Object> requestBody){
		
		//to do: fix association attributes
		InvitedUser InvitedUser = InvitedUserFactory.createInvitedUser(
			"taskline.appointment.core.InvitedUserImpl",
		userimpl
		, appointmentimpl
		);
		Repository.saveObject(inviteduser);
		return inviteduser;
	}

    public InvitedUser createInvitedUser(Map<String, Object> requestBody, int id){
		
		//to do: fix association attributes
		
		InvitedUser inviteduser = InvitedUserFactory.createInvitedUser("taskline.appointment.core.InvitedUserImpl", userimpl, appointmentimpl);
		return inviteduser;
	}

    public HashMap<String, Object> updateInvitedUser(Map<String, Object> requestBody){
		String idStr = (String) requestBody.get("");
		int id = Integer.parseInt(idStr);
		InvitedUser inviteduser = Repository.getObject(id);
		
		
		Repository.updateObject(inviteduser);
		
		//to do: fix association attributes
		
		return inviteduser.toHashMap();
		
	}

    public HashMap<String, Object> getInvitedUser(Map<String, Object> requestBody){
		List<HashMap<String, Object>> inviteduserList = getAllInvitedUser("inviteduser_impl");
		for (HashMap<String, Object> inviteduser : inviteduserList){
			int record_id = ((Double) inviteduser.get("record_id")).intValue();
			if (record_id == id){
				return inviteduser;
			}
		}
		return null;
	}

	public HashMap<String, Object> getInvitedUserById(int id){
		String idStr = vmjExchange.getGETParam(""); 
		int id = Integer.parseInt(idStr);
		InvitedUser inviteduser = inviteduserRepository.getObject(id);
		return inviteduser.toHashMap();
	}

    public List<HashMap<String,Object>> getAllInvitedUser(Map<String, Object> requestBody){
		String table = (String) requestBody.get("table_name");
		List<InvitedUser> List = Repository.getAllObject(table);
		return transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<InvitedUser> List){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < List.size(); i++) {
            resultList.add(List.get(i).toHashMap());
        }

        return resultList;
	}

    public List<HashMap<String,Object>> deleteInvitedUser(Map<String, Object> requestBody){
		String idStr = ((String) requestBody.get("id"));
		int id = Integer.parseInt(idStr);
		Repository.deleteObject(id);
		return getAllInvitedUser(requestBody);
	}

}
