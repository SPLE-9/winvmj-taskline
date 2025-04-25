package taskline.appointment.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.OneToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.CascadeType;
import taskline.member.core.*;

@MappedSuperclass
public abstract class InvitedUserDecorator extends InvitedUserComponent {
    @OneToOne(cascade=CascadeType.ALL)
	protected InvitedUserComponent record;

	public InvitedUserDecorator () {
		super();
		this.invitedUserId = UUID.randomUUID();
	}
		
	public InvitedUserDecorator (InvitedUserComponent record) {
		this.record = record;
	}

	public InvitedUserDecorator (UUID invitedUserId, InvitedUserComponent record) {
		this.invitedUserId = invitedUserId;
		this.record = record;
	}

	public UUID getInvitedUserId() {
		return this.record.invitedUserId;
	}

	public void setInvitedUserId(UUID invitedUserId) {
		this.record.invitedUserId = invitedUserId;
	}

	public Appointment getAppointment() {
		return this.record.appointment;
	}

	public void setAppointment(Appointment appointment) {
		this.record.appointment = appointment;
	}

	public Member getMember() {
		return this.record.member;
	}

	public void setMember(Member member) {
		this.record.member = member;
	}

	public HashMap<String, Object> toHashMap() {
        return this.record.toHashMap();
    }

}
