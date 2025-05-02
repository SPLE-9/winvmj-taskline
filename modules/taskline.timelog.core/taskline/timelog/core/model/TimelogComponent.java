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
	protected UUID timelogId;
	protected UUID taskId;
	protected UUID userId;
	public LocalDateTime timelogDate;
	public String timelogType;
	public String timelogNotes;
	@ManyToOne(targetEntity=taskline.user.core.UserComponent.class)
	public User userimpl;
	@ManyToOne(targetEntity=taskline.task.core.Component.class)
	public Task taskimpl;
	protected String objectName = TimelogComponent.class.getName();

	public TimelogComponent(
        UUID timelogId, UUID taskId, UUID userId, LocalDateTime timelogDate, String timelogType, String timelogNotes, UserImpl userimpl, TaskImpl taskimpl
    ) {
        this.timelogId = timelogId;
        this.taskId = taskId;
        this.userId = userId;
        this.timelogDate = timelogDate;
        this.timelogType = timelogType;
        this.timelogNotes = timelogNotes;
        this.userimpl = userimpl;
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
	public UUID getUserId() {
		return this.userId;
	}

	public void setUserId(UUID userId) {
		this.userId = userId;
	}
	public abstract LocalDateTime getTimelogDate();
	public abstract void setTimelogDate(LocalDateTime timelogDate);
	
	public abstract String getTimelogType();
	public abstract void setTimelogType(String timelogType);
	
	public abstract String getTimelogNotes();
	public abstract void setTimelogNotes(String timelogNotes);
	
	public abstract UserImpl getUserimpl();
	public abstract void setUserimpl(UserImpl userimpl);
	
	public abstract TaskImpl getTaskimpl();
	public abstract void setTaskimpl(TaskImpl taskimpl);
	
 
	// public abstract void getTimelogDetail();

	public abstract void validateTimelog(Task task, LocalDateTime timelogDate, String timelogType);

	@Override
    public String toString() {
        return "{" +
            " timelogId='" + getTimelogId() + "'" +
            " taskId='" + getTaskId() + "'" +
            " userId='" + getUserId() + "'" +
            " timelogDate='" + getTimelogDate() + "'" +
            " timelogType='" + getTimelogType() + "'" +
            " timelogNotes='" + getTimelogNotes() + "'" +
            " userimpl='" + getUserimpl() + "'" +
            " taskimpl='" + getTaskimpl() + "'" +
            "}";
    }

	public HashMap<String, Object> toHashMap() {
		HashMap<String, Object> map = new HashMap<>();
		map.put("timelogId", this.timelogId);
		map.put("taskId", this.taskId);
		map.put("userId", this.userId);
		map.put("timelogDate", this.timelogDate);
		map.put("timelogType", this.timelogType);
		map.put("timelogNotes", this.timelogNotes);
		map.put("userimpl", this.userimpl.toHashMap());
		map.put("taskimpl", this.taskimpl.toHashMap());
		return map;
	}
	
}
