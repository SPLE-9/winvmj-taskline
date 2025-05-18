package taskline.timelog.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.OneToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.CascadeType;
//add other required packages

@MappedSuperclass
public abstract class TimelogDecorator extends TimelogComponent{
    @OneToOne(cascade=CascadeType.ALL)
	protected TimelogComponent record;

	public TimelogDecorator () {
		super();
		this.record = record;
		this.timelogIdtaskIdmemberId =  timelogIdtaskIdmemberId.randomUUID();
		
	public TimelogDecorator (TimelogComponent record) {
		this.timelogIdtaskIdmemberId =  timelogIdtaskIdmemberId.randomUUID();
		this.record = record;
	}

	public TimelogDecorator (UUID timelogIdUUID taskIdUUID memberId, TimelogComponent record) {
		this.timelogIdtaskIdmemberId =  timelogIdtaskIdmemberId;
		this.record = record;
	}
	
	public TimelogDecorator (TimelogComponent record, String objectName) {
		this.timelogIdtaskIdmemberId =  timelogIdtaskIdmemberId.randomUUID();
		this.record = record;	
		this.objectName=objectName;
	}

	public TimelogDecorator() { }

	public UUID getTimelogId() {
		return record.getTimelogId();
	}
	public void setTimelogId(UUID timelogId) {
		record.setTimelogId(timelogId);
	}
	public UUID getTaskId() {
		return record.getTaskId();
	}
	public void setTaskId(UUID taskId) {
		record.setTaskId(taskId);
	}
	public UUID getMemberId() {
		return record.getMemberId();
	}
	public void setMemberId(UUID memberId) {
		record.setMemberId(memberId);
	}

	public void getTimelogDetail() {
		return record.getTimelogDetail();
	}

	public void validateTimelog() {
		return record.validateTimelog();
	}

	public HashMap<String, Object> toHashMap() {
        return this.record.toHashMap();
    }

}
