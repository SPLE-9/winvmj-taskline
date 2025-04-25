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
import javax.persistence.UniqueConstraint;
import taskline.member.core.*;

@Entity
@Table(name="inviteduser_comp", uniqueConstraints = @UniqueConstraint(columnNames = { "appointment_appointmentId", "member_memberId" }))
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class InvitedUserComponent implements InvitedUser{
	@Id
	public UUID invitedUserId;
	@ManyToOne(targetEntity=taskline.member.core.MemberComponent.class)
	public Member member;
	@ManyToOne(targetEntity=taskline.appointment.core.AppointmentComponent.class)
	public Appointment appointment;
	protected String objectName = InvitedUserComponent.class.getName();

	public InvitedUserComponent() {

	} 

	public InvitedUserComponent(
        UUID invitedUserId, Member member, Appointment appointment
    ) {
		this.invitedUserId = invitedUserId;
        this.member = member;
        this.appointment = appointment;
    }

	public UUID getInvitedUserId() {
		return this.invitedUserId;
	}

	public void setInvitedUserId(UUID invitedUserId) {
		this.invitedUserId = invitedUserId;
	}

	public Member getMember() {
		return this.member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public Appointment getAppointment() {
		return this.appointment;
	}

	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}
	
	@Override
    public String toString() {
        return "{" +
			" invitedUserId='" + getInvitedUserId() + "'" +
            " memberId='" + getMember().getMemberId() + "'" +
            " appointmentId='" + getAppointment().getAppointmentId() + "'" +
            "}";
    }
	
	public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> invitedUserMap = new HashMap<String,Object>();
		invitedUserMap.put("invitedUserId", getInvitedUserId());
		invitedUserMap.put("appointmentId", getAppointment().getAppointmentId());
		invitedUserMap.put("memberId", getMember().getMemberId());
		invitedUserMap.put("name", getMember().getName());
		invitedUserMap.put("email", getMember().getEmail());

        return invitedUserMap;
    }
}
