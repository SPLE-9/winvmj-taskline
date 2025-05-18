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


@Entity(name="appointment_impl")
@Table(name="appointment_impl")
public class AppointmentImpl extends AppointmentComponent {

	public AppointmentImpl(EDate startTime, EDate endTime, String description, MemberImpl memberimpl) {
		this.startTime = startTime;
		this.endTime = endTime;
		this.description = description;
		this.memberimpl = memberimpl;
	}

	public AppointmentImpl(EDate startTime, EDate endTime, String description, MemberImpl memberimpl) {
		this. =  .randomUUID();;
		this.startTime = startTime;
		this.endTime = endTime;
		this.description = description;
		this.memberimpl = memberimpl;
	}

	public AppointmentImpl() { }


	
	public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> appointmentMap = new HashMap<String,Object>();
		appointmentMap.put("startTime",getStartTime());
		appointmentMap.put("endTime",getEndTime());
		appointmentMap.put("description",getDescription());
		appointmentMap.put("memberimpl",getMemberimpl());

        return appointmentMap;
    }

}
