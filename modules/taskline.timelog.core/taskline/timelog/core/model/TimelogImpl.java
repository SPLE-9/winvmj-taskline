package taskline.timelog.core;

import java.lang.Math;
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


@Entity(name="timelog_impl")
@Table(name="timelog_impl")
public class TimelogImpl extends TimelogComponent {

	public TimelogImpl(UUID timelogId, UUID taskId, UUID userId, EDate timelogDate, EString timelogType, EString timelogNotes, UserImpl userimpl, TaskImpl taskimpl) {
		this.timelogId = timelogId;
		this.taskId = taskId;
		this.userId = userId;
		this.timelogDate = timelogDate;
		this.timelogType = timelogType;
		this.timelogNotes = timelogNotes;
		this.userimpl = userimpl;
		this.taskimpl = taskimpl;
	}

	public TimelogImpl(UUID timelogId, UUID taskId, UUID userId, EDate timelogDate, EString timelogType, EString timelogNotes, UserImpl userimpl, TaskImpl taskimpl) {
		this.timelogIdtaskIduserId =  timelogIdtaskIduserId.randomUUID();;
		this.timelogId = timelogId;
		this.taskId = taskId;
		this.userId = userId;
		this.timelogDate = timelogDate;
		this.timelogType = timelogType;
		this.timelogNotes = timelogNotes;
		this.userimpl = userimpl;
		this.taskimpl = taskimpl;
	}

	public TimelogImpl() { }

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
	public UUID getUserId() {
		return this.userId;
	}

	public void setUserId(UUID userId) {
		this.userId = userId;
	}

	public void getTimelogDetail() {
		// TODO: implement this method
	}

	public void validateTimelog() {
		// TODO: implement this method
	}
	
	public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> timelogMap = new HashMap<String,Object>();
		timelogMap.put("timelogId",getTimelogId());
		timelogMap.put("taskId",getTaskId());
		timelogMap.put("userId",getUserId());
		timelogMap.put("timelogDate",getTimelogDate());
		timelogMap.put("timelogType",getTimelogType());
		timelogMap.put("timelogNotes",getTimelogNotes());
		timelogMap.put("userimpl",getUserimpl());
		timelogMap.put("taskimpl",getTaskimpl());

        return timelogMap;
    }

}
