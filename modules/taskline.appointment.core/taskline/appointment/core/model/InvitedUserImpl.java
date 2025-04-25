package taskline.appointment.core;

import java.lang.Math;
import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import taskline.member.core.*;

@Entity(name="inviteduser_impl")
@Table(name="inviteduser_impl")
public class InvitedUserImpl extends InvitedUserComponent {

	public InvitedUserImpl(UUID invitedUserId, Member member, Appointment appointment) {
		this.invitedUserId = invitedUserId;
		this.member = member;
		this.appointment = appointment;
	}

	public InvitedUserImpl(Member member, Appointment appointment) {
		this.invitedUserId = UUID.randomUUID();
		this.member = member;
		this.appointment = appointment;
	}

	public InvitedUserImpl() {
		this.invitedUserId = UUID.randomUUID();
		this.member = null;
		this.appointment = null;
	}

	public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> Map = new HashMap<String,Object>();
		Map.put("invitedUserId",getInvitedUserId());
		Map.put("appointmentId",getAppointment().getAppointmentId());
		Map.put("memberId",getMember().getMemberId());

        return Map;
    }
}
