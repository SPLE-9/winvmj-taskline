package taskline.appointment.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.OneToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.CascadeType;
//add other required packages

@MappedSuperclass
public abstract class AppointmentDecorator extends AppointmentComponent{
    @OneToOne(cascade=CascadeType.ALL)
	protected AppointmentComponent record;

	public AppointmentDecorator () {
		super();
		this.record = record;
		this. =  .randomUUID();
		
	public AppointmentDecorator (AppointmentComponent record) {
		this. =  .randomUUID();
		this.record = record;
	}

	public AppointmentDecorator (, AppointmentComponent record) {
		this. =  ;
		this.record = record;
	}
	
	public AppointmentDecorator (AppointmentComponent record, String objectName) {
		this. =  .randomUUID();
		this.record = record;	
		this.objectName=objectName;
	}

	public AppointmentDecorator() { }



	public HashMap<String, Object> toHashMap() {
        return this.record.toHashMap();
    }

}
