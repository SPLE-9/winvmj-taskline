package taskline.task.taskwithcomment;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import taskline.member.core.MemberImpl;
import taskline.task.core.TaskImpl;
import taskline.member.core.Member;
import taskline.task.core.Task;
import java.util.*;

public interface Comment {
	public UUID getCommentId();
	public void setCommentId(UUID commentId);
	public String getContent();
	public void setContent(String content);
	public Date getCreatedAt();
	public void setCreatedAt(Date createdAt);
	public Member getMemberimpl();
	public void setMemberimpl(MemberImpl memberimpl);
	public Task getTaskimpl();
	public void setTaskimpl(TaskImpl projectimpl);
	HashMap<String, Object> toHashMap();
}
