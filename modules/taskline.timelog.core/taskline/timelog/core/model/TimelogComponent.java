package taskline.timelog.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.ManyToOne;

import taskline.task.core.*;
import taskline.member.core.*;
import java.time.LocalDateTime;

@Entity
@Table(name="timelog_comp")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class TimelogComponent implements Timelog{
	@Id
	protected UUID timelogId;
	protected UUID taskId;
	protected UUID memberId;
	public LocalDateTime startDate;
	public String timelogType;
	public String timelogNotes;
	@ManyToOne(targetEntity=taskline.task.core.TaskComponent.class)
	public Task taskimpl;
	@ManyToOne(targetEntity=taskline.member.core.MemberComponent.class)
	public Member memberimpl;
	protected String objectName = TimelogComponent.class.getName();

	public TimelogComponent(
        UUID timelogId, UUID taskId, UUID memberId, 
        LocalDateTime startDate, 
        String timelogType, String timelogNotes, 
        Task taskimpl, Member memberimpl
    ) {
        this.timelogId = timelogId;
        this.taskId = taskId;
        this.memberId = memberId;
        this.startDate = startDate;
        this.timelogType = timelogType;
        this.timelogNotes = timelogNotes;
        this.memberimpl = memberimpl;
        this.taskimpl = taskimpl;
    }
	
	public TimelogComponent() {
		
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
	public UUID getMemberId() {
		return this.memberId;
	}

	public void setMemberId(UUID memberId) {
		this.memberId = memberId;
	}
	public abstract LocalDateTime getStartDate();
	public abstract void setStartDate(LocalDateTime startDate);
	
	public abstract String getTimelogType();
	public abstract void setTimelogType(String timelogType);
	
	public abstract String getTimelogNotes();
	public abstract void setTimelogNotes(String timelogNotes);
	
	public abstract Member getMemberimpl();
	public abstract void setMemberimpl(Member memberimpl);
	
	public abstract Task getTaskimpl();
	public abstract void setTaskimpl(Task taskimpl);
	
 
	// public abstract void getTimelogDetail();

	public abstract void validateTimelog(UUID taskId, LocalDateTime startDate, String timelogType);

	@Override
    public String toString() {
        return "{" +
            " timelogId='" + getTimelogId() + "'" +
            " taskId='" + getTaskId() + "'" +
            " memberId='" + getMemberId() + "'" +
            " startDate='" + getStartDate() + "'" +
            " timelogType='" + getTimelogType() + "'" +
            " timelogNotes='" + getTimelogNotes() + "'" +
            " memberimpl='" + getMemberimpl() + "'" +
            " taskimpl='" + getTaskimpl() + "'" +
            "}";
    }

	public HashMap<String, Object> toHashMap() {
		HashMap<String, Object> map = new HashMap<>();
		map.put("timelogId", this.timelogId);
		map.put("taskId", this.taskId);
		map.put("startDate", this.startDate);
		map.put("timelogType", this.timelogType);
		map.put("timelogNotes", this.timelogNotes);
		map.put("taskimpl", this.taskimpl.toHashMap());
		return map;
	}
	
}
