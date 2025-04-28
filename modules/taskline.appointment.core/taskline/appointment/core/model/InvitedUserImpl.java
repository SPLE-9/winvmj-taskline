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


@Entity(name="inviteduser_impl")
@Table(name="inviteduser_impl")
public class InvitedUserImpl extends InvitedUserComponent {

	public InvitedUserImpl(UserImpl userimpl, AppointmentImpl appointmentimpl) {
		this.userimpl = userimpl;
		this.appointmentimpl = appointmentimpl;
	}

	public InvitedUserImpl(UserImpl userimpl, AppointmentImpl appointmentimpl) {
		this. =  .randomUUID();;
		this.userimpl = userimpl;
		this.appointmentimpl = appointmentimpl;
	}

	public InvitedUserImpl() { }


	
	public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> inviteduserMap = new HashMap<String,Object>();
		inviteduserMap.put("userimpl",getUserimpl());
		inviteduserMap.put("appointmentimpl",getAppointmentimpl());

        return inviteduserMap;
    }

}
