package taskline.appointment.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.OneToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.CascadeType;
//add other required packages

@MappedSuperclass
public abstract class InvitedMemberDecorator extends InvitedMemberComponent{
    @OneToOne(cascade=CascadeType.ALL)
	protected InvitedMemberComponent record;

	public InvitedMemberDecorator () {
		super();
		this.record = record;
		this. =  .randomUUID();
		
	public InvitedMemberDecorator (InvitedMemberComponent record) {
		this. =  .randomUUID();
		this.record = record;
	}

	public InvitedMemberDecorator (, InvitedMemberComponent record) {
		this. =  ;
		this.record = record;
	}
	
	public InvitedMemberDecorator (InvitedMemberComponent record, String objectName) {
		this. =  .randomUUID();
		this.record = record;	
		this.objectName=objectName;
	}

	public InvitedMemberDecorator() { }



	public HashMap<String, Object> toHashMap() {
        return this.record.toHashMap();
    }

}
