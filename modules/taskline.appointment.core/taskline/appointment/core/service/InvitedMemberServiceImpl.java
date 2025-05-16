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
import taskline.appointment.InvitedMemberFactory;
import prices.auth.vmj.annotations.Restricted;
//add other required packages

public class InvitedMemberServiceImpl extends InvitedMemberServiceComponent{

    public List<HashMap<String,Object>> saveInvitedMember(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		InvitedMember invitedmember = createInvitedMember(vmjExchange);
		invitedmemberRepository.saveObject(invitedmember);
		return getAllInvitedMember(vmjExchange);
	}

    public InvitedMember createInvitedMember(Map<String, Object> requestBody){
		
		//to do: fix association attributes
		InvitedMember InvitedMember = InvitedMemberFactory.createInvitedMember(
			"taskline.appointment.core.InvitedMemberImpl",
		memberimpl
		, appointmentimpl
		);
		Repository.saveObject(invitedmember);
		return invitedmember;
	}

    public InvitedMember createInvitedMember(Map<String, Object> requestBody, int id){
		
		//to do: fix association attributes
		
		InvitedMember invitedmember = InvitedMemberFactory.createInvitedMember("taskline.appointment.core.InvitedMemberImpl", memberimpl, appointmentimpl);
		return invitedmember;
	}

    public HashMap<String, Object> updateInvitedMember(Map<String, Object> requestBody){
		String idStr = (String) requestBody.get("");
		int id = Integer.parseInt(idStr);
		InvitedMember invitedmember = Repository.getObject(id);
		
		
		Repository.updateObject(invitedmember);
		
		//to do: fix association attributes
		
		return invitedmember.toHashMap();
		
	}

    public HashMap<String, Object> getInvitedMember(Map<String, Object> requestBody){
		List<HashMap<String, Object>> invitedmemberList = getAllInvitedMember("invitedmember_impl");
		for (HashMap<String, Object> invitedmember : invitedmemberList){
			int record_id = ((Double) invitedmember.get("record_id")).intValue();
			if (record_id == id){
				return invitedmember;
			}
		}
		return null;
	}

	public HashMap<String, Object> getInvitedMemberById(int id){
		String idStr = vmjExchange.getGETParam(""); 
		int id = Integer.parseInt(idStr);
		InvitedMember invitedmember = invitedmemberRepository.getObject(id);
		return invitedmember.toHashMap();
	}

    public List<HashMap<String,Object>> getAllInvitedMember(Map<String, Object> requestBody){
		String table = (String) requestBody.get("table_name");
		List<InvitedMember> List = Repository.getAllObject(table);
		return transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<InvitedMember> List){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < List.size(); i++) {
            resultList.add(List.get(i).toHashMap());
        }

        return resultList;
	}

    public List<HashMap<String,Object>> deleteInvitedMember(Map<String, Object> requestBody){
		String idStr = ((String) requestBody.get("id"));
		int id = Integer.parseInt(idStr);
		Repository.deleteObject(id);
		return getAllInvitedMember(requestBody);
	}

}
