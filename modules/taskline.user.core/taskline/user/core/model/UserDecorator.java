package taskline.user.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.OneToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.CascadeType;
//add other required packages

@MappedSuperclass
public abstract class UserDecorator extends UserComponent{
    @OneToOne(cascade=CascadeType.ALL)
	protected UserComponent record;

	public UserDecorator () {
		super();
		this.record = record;
		this.userId =  userId.randomUUID();
		
	public UserDecorator (UserComponent record) {
		this.userId =  userId.randomUUID();
		this.record = record;
	}

	public UserDecorator (UUID userId, UserComponent record) {
		this.userId =  userId;
		this.record = record;
	}
	
	public UserDecorator (UserComponent record, String objectName) {
		this.userId =  userId.randomUUID();
		this.record = record;	
		this.objectName=objectName;
	}

	public UserDecorator() { }

	public UUID getUserId() {
		return record.getUserId();
	}
	public void setUserId(UUID userId) {
		record.setUserId(userId);
	}


	public HashMap<String, Object> toHashMap() {
        return this.record.toHashMap();
    }

}
