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
@Table(name="invitedmember_comp")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class InvitedMemberComponent implements InvitedMember{
	@Id
	
	@ManyToOne(targetEntity=taskline.member.core.MemberComponent.class)
	public Member memberimpl;
	@ManyToOne(targetEntity=taskline.appointment.core.AppointmentComponent.class)
	public Appointment appointmentimpl;
	protected String objectName = InvitedMemberComponent.class.getName();

	public InvitedMemberComponent() {

	} 

	public InvitedMemberComponent(
        MemberImpl memberimpl, AppointmentImpl appointmentimpl
    ) {
        this.memberimpl = memberimpl;
        this.appointmentimpl = appointmentimpl;
    }

	public abstract MemberImpl getMemberimpl();
	public abstract void setMemberimpl(MemberImpl memberimpl);
	
	public abstract AppointmentImpl getAppointmentimpl();
	public abstract void setAppointmentimpl(AppointmentImpl appointmentimpl);
	
 

	@Override
    public String toString() {
        return "{" +
            " memberimpl='" + getMemberimpl() + "'" +
            " appointmentimpl='" + getAppointmentimpl() + "'" +
            "}";
    }
	
}
