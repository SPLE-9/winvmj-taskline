package taskline.timelog.core;

import java.lang.Math;
import java.time.LocalDate;
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

import taskline.task.core.*;
import taskline.member.core.*;

@Entity(name="timelog_impl")
@Table(name="timelog_impl")
public class TimelogImpl extends TimelogComponent {

	public TimelogImpl(
			UUID timelogId, UUID taskId, UUID memberId, 
			LocalDate timelogDate, 
			String timelogType, String timelogNotes, 
			Task taskimpl, Member memberimpl) {
		super(timelogId, taskId, memberId, timelogDate, timelogType, timelogNotes, taskimpl, memberimpl);
        this.taskimpl = taskimpl;
        this.memberimpl = memberimpl;
	}
	
	public UUID getTimelogId() {
		return this.timelogId;
	}

	public void setTimelogId(UUID timelogId) {
		this.timelogId = timelogId;
	}
	
	public UUID getTaskId() {
		return this.taskId;
	}

	public void setTaskId(UUID taskId) {
		this.taskId = taskId;
	}
	
	public String getTimelogNotes() {
		return this.timelogNotes;
	}

	public void setTimelogNotes(String timelogNotes) {
		this.timelogNotes = timelogNotes;
	}

	public void setTimelogType(String timelogType) {
		this.timelogType = timelogType;
	}
	
	public String getTimelogType() {
		return this.timelogType;
	}
	
	public void setTimelogDate(LocalDate timelogDate) {
		this.timelogDate = timelogDate;
	}
	
	public LocalDate getTimelogDate() {
		return this.timelogDate;
	}
	
	public Task getTaskimpl() {
		return this.taskimpl;
	}
	
	public void setTaskimpl(Task taskimpl) {
		this.taskimpl = taskimpl;
	}
	
	public Member getMemberimpl() {
		return this.memberimpl;
	}
	
	public void setMemberimpl(Member memberimpl) {
		this.memberimpl = memberimpl;
	}
	
	public UUID getMemberId() {
		return this.memberId;
	}

	public void setMemberId(UUID memberId) {
		this.memberId = memberId;
	}

	public void validateTimelog(UUID taskId, LocalDate timelogDate, String timelogType) {
		// TODO: implement this method
		if (taskId == null) {
			throw new IllegalArgumentException("Invalid task");
		}
		if (startDate == null) {
			throw new IllegalArgumentException("Invalid timelog start date");
		}
		if (timelogType == null || timelogType.isEmpty()) {
			throw new IllegalArgumentException("Invalid timelog type");
		}
		
	}
	
	public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> timelogMap = new HashMap<String,Object>();
		timelogMap.put("timelogId",getTimelogId());
		timelogMap.put("taskId",getTaskId());
		timelogMap.put("memberId",getMemberId());
		timelogMap.put("timelogDate",getTimelogDate());
		timelogMap.put("timelogType",getTimelogType());
		timelogMap.put("timelogNotes",getTimelogNotes());
		timelogMap.put("memberimpl",getMemberimpl());
		timelogMap.put("taskimpl",getTaskimpl());

        return timelogMap;
    }

}
