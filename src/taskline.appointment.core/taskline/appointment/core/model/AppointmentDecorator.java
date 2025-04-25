package taskline.appointment.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.OneToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.CascadeType;
import taskline.member.core.*;

@MappedSuperclass
public abstract class AppointmentDecorator extends AppointmentComponent{
    @OneToOne(cascade=CascadeType.ALL)
	protected AppointmentComponent record;

	public AppointmentDecorator () {
		super();
		this.appointmentId = UUID.randomUUID();
	}
		
	public AppointmentDecorator (AppointmentComponent record) {
		this.appointmentId = UUID.randomUUID();
		this.record = record;
	}

	public AppointmentDecorator (UUID appointmentId, AppointmentComponent record) {
		this.appointmentId =  appointmentId;
		this.record = record;
	}

	public UUID getAppointmentId() {
		return this.record.getAppointmentId();
	}

	public void setAppointmentId(UUID appointmentId) {
		this.record.setAppointmentId(appointmentId);
	}

	public String getDescription() {
		return this.record.getDescription();
	}

	public void setDescription(String description) {
		this.record.setDescription(description);
	}

	public Date getStartTime() {
		return this.record.getStartTime();
	}

	public void setStartTime(Date startTime) {
		this.record.setStartTime(startTime);
	}

	public Date getEndTime() {
		return this.record.getEndTime();
	}

	public void setEndTime(Date endTime) {
		this.record.setEndTime(endTime);
	}

	public Member getMember() {
		return this.record.getMember();
	}

	public void setMember(Member member) {
		this.record.setMember(member);
	}

	public HashMap<String, Object> toHashMap() {
        return this.record.toHashMap();
    }
}
