package taskline.appointment.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="inviteduser_comp")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class InvitedUserComponent implements InvitedUser{
	@Id
	
	@ManyToOne(targetEntity=taskline.user.core.UserComponent.class)
	public User userimpl;
	@ManyToOne(targetEntity=taskline.appointment.core.AppointmentComponent.class)
	public Appointment appointmentimpl;
	protected String objectName = InvitedUserComponent.class.getName();

	public InvitedUserComponent() {

	} 

	public InvitedUserComponent(
        UserImpl userimpl, AppointmentImpl appointmentimpl
    ) {
        this.userimpl = userimpl;
        this.appointmentimpl = appointmentimpl;
    }

	public abstract UserImpl getUserimpl();
	public abstract void setUserimpl(UserImpl userimpl);
	
	public abstract AppointmentImpl getAppointmentimpl();
	public abstract void setAppointmentimpl(AppointmentImpl appointmentimpl);
	
 

	@Override
    public String toString() {
        return "{" +
            " userimpl='" + getUserimpl() + "'" +
            " appointmentimpl='" + getAppointmentimpl() + "'" +
            "}";
    }
	
}
