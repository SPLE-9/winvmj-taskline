package taskline.timelog.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="timelog_comp")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class TimelogComponent implements Timelog{
	@Id
	protected UUID timelogId; protected UUID taskId; protected UUID memberId; 
	protected UUID timelogId;
	protected UUID taskId;
	protected UUID memberId;
	public EDate timelogDate;
	public EString timelogType;
	public EString timelogNotes;
	@ManyToOne(targetEntity=taskline.member.core.MemberComponent.class)
	public Member memberimpl;
	@ManyToOne(targetEntity=taskline..core.Component.class)
	public  taskimpl;
	protected String objectName = TimelogComponent.class.getName();

	public TimelogComponent() {

	} 

	public TimelogComponent(
        UUID timelogId, UUID taskId, UUID memberId, EDate timelogDate, EString timelogType, EString timelogNotes, MemberImpl memberimpl, TaskImpl taskimpl
    ) {
        this.timelogId = timelogId;
        this.taskId = taskId;
        this.memberId = memberId;
        this.timelogDate = timelogDate;
        this.timelogType = timelogType;
        this.timelogNotes = timelogNotes;
        this.memberimpl = memberimpl;
        this.taskimpl = taskimpl;
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
	public abstract EDate getTimelogDate();
	public abstract void setTimelogDate(EDate timelogDate);
	
	public abstract EString getTimelogType();
	public abstract void setTimelogType(EString timelogType);
	
	public abstract EString getTimelogNotes();
	public abstract void setTimelogNotes(EString timelogNotes);
	
	public abstract MemberImpl getMemberimpl();
	public abstract void setMemberimpl(MemberImpl memberimpl);
	
	public abstract TaskImpl getTaskimpl();
	public abstract void setTaskimpl(TaskImpl taskimpl);
	
 
	public abstract void getTimelogDetail();

	public abstract void validateTimelog();

	@Override
    public String toString() {
        return "{" +
            " timelogId='" + getTimelogId() + "'" +
            " taskId='" + getTaskId() + "'" +
            " memberId='" + getMemberId() + "'" +
            " timelogDate='" + getTimelogDate() + "'" +
            " timelogType='" + getTimelogType() + "'" +
            " timelogNotes='" + getTimelogNotes() + "'" +
            " memberimpl='" + getMemberimpl() + "'" +
            " taskimpl='" + getTaskimpl() + "'" +
            "}";
    }
	
}
