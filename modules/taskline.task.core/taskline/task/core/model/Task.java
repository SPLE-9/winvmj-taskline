package taskline.task.core;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import taskline.user.core.UserImpl;
import taskline.project.core.ProjectImpl;
import taskline.user.core.User;
import taskline.project.core.Project;
import taskline.task.core.Status;
import java.util.*;

public interface Task {
	public UUID getTaskId();
	public void setTaskId(UUID taskId);
	public String getTitle();
	public void setTitle(String title);
	public String getDescription();
	public void setDescription(String description);
	public Status getStatus();
	public void setStatus(Status status);
	public Date getCreatedAt();
	public void setCreatedAt(Date createdAt);
	public Date getCompletedAt();
	public void setCompletedAt(Date completedAt);
	public User getUserimpl();
	public void setUserimpl(UserImpl userimpl);
	public Project getProjectimpl();
	public void setProjectimpl(ProjectImpl projectimpl);
	HashMap<String, Object> toHashMap();
}
