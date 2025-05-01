package taskline.analytic.burndownbymember;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;

import taskline.analytic.core.AnalyticDecorator;
import taskline.analytic.core.Analytic;
import taskline.analytic.core.AnalyticComponent;

@Entity(name="analytic_burndownbymember")
@Table(name="analytic_burndownbymember")
public class AnalyticImpl extends AnalyticDecorator {
	@OneToOne(targetEntity = taskline.user.core.UserComponent.class)
	private User user;

	public AnalyticImpl(){
        super();
        this.objectName = AnalyticImpl.class.getName();
    }
    
    public AnalyticImpl(User user) {
    	super();
		this.user = user;
		this.objectName = AnalyticImpl.class.getName();
    }
	
	public AnalyticImpl(AnalyticComponent record, User user) {
		super(record);
		this.user = user;
		this.objectName = AnalyticImpl.class.getName();
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "{"
			+ "id=" + getId()
			+ ", record=" + getRecord()
			+ ", user=" + getUser()
			+ "}";
	}

	public HashMap<String, Object> toHashMap() {
		HashMap<String, Object> map = record.toHashMap();
		map.put("user", this.getUser().toHashMap());
		return map;
	}
}
