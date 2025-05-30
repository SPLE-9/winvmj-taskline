package taskline.timelog.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.OneToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.CascadeType;
//add other required packages
import java.time.LocalDate;

@MappedSuperclass
public abstract class TimelogDecorator extends TimelogComponent{
    @OneToOne(cascade=CascadeType.ALL)
	protected TimelogComponent record;
		
	public TimelogDecorator (TimelogComponent record) {
		this.record = record;
	}

	public TimelogDecorator (UUID timelogId, TimelogComponent record) {
		this.timelogId =  timelogId;
		this.record = record;
	}

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

	public void validateTimelog(UUID taskId, LocalDate timelogDate) {
		record.validateTimelog(taskId, timelogDate);
	}

	public HashMap<String, Object> toHashMap() {
        return this.record.toHashMap();
    }

}
