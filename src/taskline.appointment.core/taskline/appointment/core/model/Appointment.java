package taskline.appointment.core;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import java.util.*;
import taskline.member.core.*;

public interface Appointment {
	public UUID getAppointmentId();
	public void setAppointmentId(UUID appointmentId);
	public Date getStartTime();
	public void setStartTime(Date startTime);
	public Date getEndTime();
	public void setEndTime(Date endTime);
	public String getDescription();
	public void setDescription(String description);
	public Member getMember();
	public void setMember(Member member);
	HashMap<String, Object> toHashMap();
}
