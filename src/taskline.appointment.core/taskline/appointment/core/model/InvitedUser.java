package taskline.appointment.core;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import java.util.*;
import taskline.member.core.*;

public interface InvitedUser {
	public UUID getInvitedUserId();
	public void setInvitedUserId(UUID invitedUserId);
	public Member getMember();
	public void setMember(Member member);
	public Appointment getAppointment();
	public void setAppointment(Appointment appointment);
	HashMap<String, Object> toHashMap();
}
