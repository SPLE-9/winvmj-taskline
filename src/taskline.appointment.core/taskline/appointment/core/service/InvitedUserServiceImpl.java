package taskline.appointment.core;
import java.util.*;
import java.util.stream.*;
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
import taskline.member.core.*;

public class InvitedUserServiceImpl extends InvitedUserServiceComponent{
	private InvitedUserFactory invitedUserFactory = new InvitedUserFactory();

	AppointmentService appointmentService = new AppointmentServiceImpl();
    MemberService memberService = new MemberServiceImpl();
	private final Gson gson = new Gson();

    public HashMap<String,Object> saveInvitedUser(Map<String, Object> requestBody){
		if (!requestBody.containsKey("appointmentId")) {
            throw new FieldValidationException("Field 'appointmentId' not found in the request body.");
        }
		String appointmentIdStr = (String) requestBody.get("appointmentId");
		HashMap<String, Object> appointmentMap = appointmentService.getAppointmentById(appointmentIdStr);
		String json = gson.toJson(appointmentMap);
		Appointment appointment = gson.fromJson(json, AppointmentImpl.class);

		if (!requestBody.containsKey("memberId")) {
            throw new FieldValidationException("Field 'memberId' not found in the request body.");
        }

		String memberIdStr = (String) requestBody.get("memberId");
        UUID memberId = UUID.fromString(memberIdStr);
        Member member = memberService.getMemberById(memberId);

		UUID appointmentId = UUID.fromString(appointmentIdStr);
		validateUniqueInvitedUser(appointmentId, memberId);

		UUID invitedUserId = UUID.randomUUID();

		InvitedUser invitedUser = invitedUserFactory.createInvitedUser("taskline.appointment.core.InvitedUserImpl", invitedUserId, appointment, member);
		invitedUserRepository.saveObject(invitedUser);
		
		return invitedUserRepository.getObject(invitedUserId).toHashMap();
	}

    public HashMap<String, Object> updateInvitedUser(Map<String, Object> requestBody){
		String invitedUserIdStr = (String) requestBody.get("invitedUserId");
		UUID invitedUserId = UUID.fromString(invitedUserIdStr);
		InvitedUser inviteduser = invitedUserRepository.getObject(invitedUserId);
		
		
		// Repository.updateObject(inviteduser);
		
		//to do: fix association attributes
		
		return inviteduser.toHashMap();
		
	}

    public HashMap<String, Object> getInvitedUserById(String invitedUserIdStr){
		UUID invitedUserId = UUID.fromString(invitedUserIdStr);

		InvitedUser invitedUser = invitedUserRepository.getObject(invitedUserId);
		if (invitedUser == null) {
			throw new NotFoundException("InvitedUser with invitedUserId " + invitedUserId +" not found");
		}

		return invitedUser.toHashMap();
	}

    public List<HashMap<String,Object>> getAllInvitedUser(){
		List<InvitedUser> invitedUserList = invitedUserRepository.getAllObject("inviteduser_impl");
		return transformListToHashMap(invitedUserList);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<InvitedUser> invitedUserList){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(InvitedUser invitedUser : invitedUserList) {
            resultList.add(invitedUser.toHashMap());
        }

        return resultList;
	}

    public HashMap<String,Object> deleteInvitedUser(Map<String, Object> requestBody){
		String invitedUserIdStr = (String) requestBody.get("invitedUserIsd");
    	UUID invitedUserId = UUID.fromString(invitedUserIdStr);
		
		InvitedUser invitedUser = invitedUserRepository.getObject(invitedUserId);
		if (invitedUser == null) {
			throw new NotFoundException("InvitedUser with invitedUserId " + invitedUserId +" not found");
		}

		invitedUserRepository.deleteObject(invitedUserId);

		return invitedUser.toHashMap();
	}

	private void validateUniqueInvitedUser(UUID appointmentId, UUID memberId) {
		List<InvitedUser> existingInvitedUsers = invitedUserRepository.getListObject("inviteduser_comp", "appointment_appointmentid", appointmentId);
        Set<UUID> existingMemberIds = existingInvitedUsers.stream()
                            .map(iu -> iu.getMember().getMemberId())
                            .collect(Collectors.toSet());
        
        if (existingMemberIds.contains(memberId)) {
            throw new BadRequestException("Member with id '" + memberId + "' is already an invited user.");
        }
	}
}
