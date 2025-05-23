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
@Table(name="appointment_comp")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class AppointmentComponent implements Appointment{
	@Id
	
	public EDate startTime;
	public EDate endTime;
	public String description;
	@ManyToOne(targetEntity=taskline.member.core.MemberComponent.class)
	public Member memberimpl;
	protected String objectName = AppointmentComponent.class.getName();

	public AppointmentComponent() {

	} 

	public AppointmentComponent(
        EDate startTime, EDate endTime, String description, MemberImpl memberimpl
    ) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.description = description;
        this.memberimpl = memberimpl;
    }

	public abstract EDate getStartTime();
	public abstract void setStartTime(EDate startTime);
	
	public abstract EDate getEndTime();
	public abstract void setEndTime(EDate endTime);
	
	public abstract String getDescription();
	public abstract void setDescription(String description);
	
	public abstract MemberImpl getMemberimpl();
	public abstract void setMemberimpl(MemberImpl memberimpl);
	
 

	@Override
    public String toString() {
        return "{" +
            " startTime='" + getStartTime() + "'" +
            " endTime='" + getEndTime() + "'" +
            " description='" + getDescription() + "'" +
            " memberimpl='" + getMemberimpl() + "'" +
            "}";
    }
	
}
