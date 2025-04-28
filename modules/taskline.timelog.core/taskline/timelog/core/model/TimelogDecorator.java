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
		this.timelogIdtaskIduserId =  timelogIdtaskIduserId.randomUUID();
		
	public TimelogDecorator (TimelogComponent record) {
		this.timelogIdtaskIduserId =  timelogIdtaskIduserId.randomUUID();
		this.record = record;
	}

	public TimelogDecorator (UUID timelogIdUUID taskIdUUID userId, TimelogComponent record) {
		this.timelogIdtaskIduserId =  timelogIdtaskIduserId;
		this.record = record;
	}
	
	public TimelogDecorator (TimelogComponent record, String objectName) {
		this.timelogIdtaskIduserId =  timelogIdtaskIduserId.randomUUID();
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
	public UUID getUserId() {
		return record.getUserId();
	}
	public void setUserId(UUID userId) {
		record.setUserId(userId);
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
