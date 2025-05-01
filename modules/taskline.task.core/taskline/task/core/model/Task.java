package taskline.task.core;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import java.util.*;

public interface Task {
	public UUID getTaskId();
	public void setTaskId(UUID taskId);
	public String getTitle();
	public void setTitle(String title);
	public String getDescription();
	public void setDescription(String description);
	public status getStatus();
	public void setStatus(status status);
	public EDate getCreatedAt();
	public void setCreatedAt(EDate createdAt);
	public UserImpl getUserimpl();
	public void setUserimpl(UserImpl userimpl);
	public ProjectImpl getProjectimpl();
	public void setProjectimpl(ProjectImpl projectimpl);
	HashMap<String, Object> toHashMap();
}
