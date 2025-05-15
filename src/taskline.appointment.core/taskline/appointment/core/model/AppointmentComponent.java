package taskline.appointment.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.ManyToOne;
import taskline.member.core.*;

@Entity
@Table(name="appointment_comp")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class AppointmentComponent implements Appointment{
	@Id
	public UUID appointmentId; 
	public Date startTime;
	public Date endTime;
	public String description;
	@ManyToOne(targetEntity=taskline.member.core.MemberComponent.class)
	public Member member;
	protected String objectName = AppointmentComponent.class.getName();

	public AppointmentComponent() {

	} 

	public AppointmentComponent(
        UUID appointmentId, Date startTime, Date endTime, String description, Member member
    ) {
        this.appointmentId = appointmentId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.description = description;
        this.member = member;
    }

	public AppointmentComponent(
        UUID appointmentId, Date startTime, Date endTime, String description
    ) {
        this.appointmentId = appointmentId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.description = description;
        this.member = null;
    }

	public UUID getAppointmentId() {
		return this.appointmentId;
	}

	public void setAppointmentId(UUID appointmentId) {
		this.appointmentId = appointmentId;
	}

	public Date getStartTime() {
		return this.startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	
	public Date getEndTime() {
		return this.endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public Member getMember() {
		return this.member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	@Override
    public String toString() {
        return "{" +
			" appointmentId='" + getAppointmentId() + "'" +
            " startTime='" + getStartTime() + "'" +
            " endTime='" + getEndTime() + "'" +
            " description='" + getDescription() + "'" +
            " memberId='" + getMember().getMemberId() + "'" +
            "}";
    }
	
}
