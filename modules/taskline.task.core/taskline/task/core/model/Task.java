package taskline.task.core;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import taskline.member.core.MemberImpl;
import taskline.project.core.ProjectImpl;
import taskline.member.core.Member;
import taskline.project.core.Project;
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
	public Member getMemberimpl();
	public void setMemberimpl(MemberImpl memberimpl);
	public Project getProjectimpl();
	public void setProjectimpl(ProjectImpl projectimpl);
	HashMap<String, Object> toHashMap();
}
