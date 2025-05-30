package taskline.timelog.core;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import java.util.*;

import taskline.task.core.*;
import taskline.member.core.*;
import java.time.LocalDate;

public interface Timelog {
	public UUID getTimelogId();
	public void setTimelogId(UUID timelogId);
	public UUID getTaskId();
	public void setTaskId(UUID taskId);
	public UUID getMemberId();
	public void setMemberId(UUID memberId);
	public LocalDate getTimelogDate();
	public void setTimelogDate(LocalDate timelogDate);
	public String getTimelogNotes();
	public void setTimelogNotes(String timelogNotes);
	public Task getTaskimpl();
	public void setTaskimpl(Task taskimpl);
	public Member getMemberimpl();
	public void setMemberimpl(Member memberimpl);
	HashMap<String, Object> toHashMap();
}
