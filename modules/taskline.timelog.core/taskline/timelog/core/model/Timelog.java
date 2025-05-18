package taskline.timelog.core;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import java.util.*;

public interface Timelog {
	public UUID getTimelogId();
	public void setTimelogId(UUID timelogId);
	public UUID getTaskId();
	public void setTaskId(UUID taskId);
	public UUID getMemberId();
	public void setMemberId(UUID memberId);
	public EDate getTimelogDate();
	public void setTimelogDate(EDate timelogDate);
	public EString getTimelogType();
	public void setTimelogType(EString timelogType);
	public EString getTimelogNotes();
	public void setTimelogNotes(EString timelogNotes);
	public MemberImpl getMemberimpl();
	public void setMemberimpl(MemberImpl memberimpl);
	public TaskImpl getTaskimpl();
	public void setTaskimpl(TaskImpl taskimpl);
	HashMap<String, Object> toHashMap();
}
