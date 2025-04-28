package taskline.appointment.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.OneToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.CascadeType;
//add other required packages

@MappedSuperclass
public abstract class InvitedUserDecorator extends InvitedUserComponent{
    @OneToOne(cascade=CascadeType.ALL)
	protected InvitedUserComponent record;

	public InvitedUserDecorator () {
		super();
		this.record = record;
		this. =  .randomUUID();
		
	public InvitedUserDecorator (InvitedUserComponent record) {
		this. =  .randomUUID();
		this.record = record;
	}

	public InvitedUserDecorator (, InvitedUserComponent record) {
		this. =  ;
		this.record = record;
	}
	
	public InvitedUserDecorator (InvitedUserComponent record, String objectName) {
		this. =  .randomUUID();
		this.record = record;	
		this.objectName=objectName;
	}

	public InvitedUserDecorator() { }



	public HashMap<String, Object> toHashMap() {
        return this.record.toHashMap();
    }

}
