package taskline.appointment.core;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import java.util.*;

public interface InvitedMember {
	public EDate getStartTime();
	public void setStartTime(EDate startTime);
	public EDate getEndTime();
	public void setEndTime(EDate endTime);
	public String getDescription();
	public void setDescription(String description);
	public MemberImpl getMemberimpl();
	public void setMemberimpl(MemberImpl memberimpl);
	public MemberImpl getMemberimpl();
	public void setMemberimpl(MemberImpl memberimpl);
	public AppointmentImpl getAppointmentimpl();
	public void setAppointmentimpl(AppointmentImpl appointmentimpl);
	HashMap<String, Object> toHashMap();
}
