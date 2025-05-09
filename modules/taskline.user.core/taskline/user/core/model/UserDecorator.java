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

	public UserDecorator (UserComponent record) {
		this.record = record;
	}

	public UserDecorator (UUID userId, UserComponent record) {
		this.userId =  userId;
		this.record = record;
	}

	public UserDecorator() {
		super();
		this.userId = UUID.randomUUID();
	}

	public UUID getUserId() {
		return this.record.getUserId();
	}

	public void setUserId(UUID userId) {
		this.record.setUserId(userId);
	}

	public String getEmail() {
        return this.record.getEmail();
    }

    public void setEmail(String email) {
        this.record.setEmail(email);
    }

	public String getName() {
        return this.record.getName();
    }

    public void setName(String name) {
        this.record.setName(name);
    }

	public HashMap<String, Object> toHashMap() {
        return this.record.toHashMap();
    }

}
