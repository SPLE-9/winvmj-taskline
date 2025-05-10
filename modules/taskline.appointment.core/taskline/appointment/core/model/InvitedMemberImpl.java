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


@Entity(name="invitedmember_impl")
@Table(name="invitedmember_impl")
public class InvitedMemberImpl extends InvitedMemberComponent {

	public InvitedMemberImpl(MemberImpl memberimpl, AppointmentImpl appointmentimpl) {
		this.memberimpl = memberimpl;
		this.appointmentimpl = appointmentimpl;
	}

	public InvitedMemberImpl(MemberImpl memberimpl, AppointmentImpl appointmentimpl) {
		this. =  .randomUUID();;
		this.memberimpl = memberimpl;
		this.appointmentimpl = appointmentimpl;
	}

	public InvitedMemberImpl() { }


	
	public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> invitedmemberMap = new HashMap<String,Object>();
		invitedmemberMap.put("memberimpl",getMemberimpl());
		invitedmemberMap.put("appointmentimpl",getAppointmentimpl());

        return invitedmemberMap;
    }

}
