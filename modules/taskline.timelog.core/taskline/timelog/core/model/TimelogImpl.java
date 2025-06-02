package taskline.timelog.core;

import java.lang.Math;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
			String timelogNotes, 
			Task taskimpl, Member memberimpl) {
		super(timelogId, taskId, memberId, timelogDate, timelogNotes, taskimpl, memberimpl);
        this.taskimpl = taskimpl;
        this.memberimpl = memberimpl;
	}

	public TimelogImpl() {
		this.timelogId = UUID.randomUUID();
        this.taskId = null;
        this.memberId = null;
        this.timelogDate = null;
        this.timelogNotes = "";
        this.taskimpl = null;
        this.memberimpl = null;
	}
	
	public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> timelogMap = new HashMap<String,Object>();
		timelogMap.put("timelogId",getTimelogId());
		timelogMap.put("taskId",getTaskId());
		timelogMap.put("memberId",getMemberId());
		timelogMap.put("timelogDate",this.timelogDate != null 
						? this.timelogDate.format(DateTimeFormatter.ISO_LOCAL_DATE) 
						: null);
		timelogMap.put("timelogNotes",getTimelogNotes());
		timelogMap.put("memberimpl",getMemberimpl());
		timelogMap.put("taskimpl",getTaskimpl());
		
		if (this.getTaskimpl() != null) {
			timelogMap.put("taskTitle", this.getTaskimpl().getTitle());
	    }
	    if (this.getMemberimpl() != null) {
	    	timelogMap.put("memberName", this.getMemberimpl().getName());
	    }

        return timelogMap;
    }

}
