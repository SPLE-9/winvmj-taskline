package taskline.task.taskwithcomment;

import java.lang.Math;
import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


import taskline.member.core.Member;
import taskline.task.core.Task;

@Entity(name = "comment_impl")
@Table(name = "comment_impl")
public class CommentImpl extends CommentComponent {

	public CommentImpl(String content, Date createdAt, Member memberimpl, Task taskimpl) {
		this.commentId =  UUID.randomUUID();;
		this.content = content;
		this.createdAt = createdAt;
		this.memberimpl = memberimpl;
		this.taskimpl = taskimpl;
	}

	public CommentImpl(String content, Date createdAt, Task taskimpl) {
		this.commentId =  UUID.randomUUID();;
		this.content = content;
		this.createdAt = createdAt;
		this.memberimpl = null;
		this.taskimpl = taskimpl;
	}

	public CommentImpl(String content, Member memberimpl, Task taskimpl) {
		this.commentId =  UUID.randomUUID();;
		this.content = content;
		this.createdAt = new Date();
		this.memberimpl = memberimpl;
		this.taskimpl = taskimpl;
	}

	public CommentImpl() {
		this.commentId = UUID.randomUUID();
		this.content = "";
		this.createdAt = new Date();
		this.memberimpl = null;
		this.taskimpl = null;
	}

	public HashMap<String, Object> toHashMap() {
		HashMap<String, Object> Map = new HashMap<String, Object>();
		Map.put("commentId", getCommentId());
		Map.put("content", getcontent());
		Map.put("createdAt", getCreatedAt());
		Map.put("memberimpl", getMemberimpl());
		Map.put("taskimpl", getTaskimpl());

		return Map;
	}

}
