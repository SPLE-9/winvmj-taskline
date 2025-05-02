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
	public EDate getTimelogDate();
	public void setTimelogDate(EDate timelogDate);
	public EString getTimelogType();
	public void setTimelogType(EString timelogType);
	public EString getTimelogNotes();
	public void setTimelogNotes(EString timelogNotes);
	public UserImpl getUserimpl();
	public void setUserimpl(UserImpl userimpl);
	public TaskImpl getTaskimpl();
	public void setTaskimpl(TaskImpl taskimpl);
	org.eclipse.uml2.uml.internal.impl.ClassImpl@578b900b (name: TimelogImpl, visibility: <unset>) (isLeaf: false, isAbstract: false, isFinalSpecialization: false) (isActive: false)
	HashMap<String, Object> toHashMap();
}
