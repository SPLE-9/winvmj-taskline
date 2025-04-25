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

@Entity(name="appointment_impl")
@Table(name="appointment_impl")
public class AppointmentImpl extends AppointmentComponent {

	public AppointmentImpl(UUID appointmentId, Date startTime, Date endTime, String description, Member member) {
		this.appointmentId = appointmentId;
		this.startTime = startTime;
		this.endTime = endTime;
		this.description = description;
		this.member = member;
	}

	public AppointmentImpl(Date startTime, Date endTime, String description, Member member) {
		this.appointmentId = UUID.randomUUID();
		this.startTime = startTime;
		this.endTime = endTime;
		this.description = description;
		this.member = member;
	}

	public AppointmentImpl() {
		this.appointmentId = UUID.randomUUID();
		this.startTime = new Date();
		this.endTime = new Date();
		this.description = "";
		this.member = null;
	}

	public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> Map = new HashMap<String,Object>();
		Map.put("appointmentId",getAppointmentId());
		Map.put("startTime",getStartTime());
		Map.put("endTime",getEndTime());
		Map.put("description",getDescription());
		Map.put("member",getMember());

        return Map;
    }
}
