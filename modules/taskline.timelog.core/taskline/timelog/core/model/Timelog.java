package taskline.timelog.core;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import java.util.*;

public interface Timelog {
	public UUID getTimelogId();
	public void setTimelogId(UUID timelogId);
	public UUID getTaskId();
	public void setTaskId(UUID taskId);
	public UUID getUserId();
	public void setUserId(UUID userId);
	public LocalDateTime getTimelogDate();
	public void setTimelogDate(LocalDateTime timelogDate);
	public String getTimelogType();
	public void setTimelogType(String timelogType);
	public String getTimelogNotes();
	public void setTimelogNotes(String timelogNotes);
	public UserImpl getUserimpl();
	public void setUserimpl(UserImpl userimpl);
	public TaskImpl getTaskimpl();
	public void setTaskimpl(TaskImpl taskimpl);
	HashMap<String, Object> toHashMap();
}
