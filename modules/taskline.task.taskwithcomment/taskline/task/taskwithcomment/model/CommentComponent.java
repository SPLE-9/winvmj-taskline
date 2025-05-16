package taskline.task.taskwithcomment;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.CascadeType;
import javax.persistence.Table;

import taskline.member.core.Member;
import taskline.member.core.MemberComponent;
import taskline.member.core.MemberImpl;
import taskline.task.core.Task;
import taskline.task.core.TaskComponent;
import taskline.task.core.TaskImpl;


@Entity(name="comment_comp")
@Table(name="comment_comp")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class CommentComponent implements Comment {
	@Id
	protected UUID commentId; 
	public String content;
	public Date createdAt;
	@ManyToOne(targetEntity=taskline.member.core.MemberComponent.class)
	public Member memberimpl;
	@ManyToOne(targetEntity=taskline.task.core.TaskComponent.class)
	public Task taskimpl;
	protected String objectName = CommentComponent.class.getName();

	public CommentComponent() {

	} 

	public CommentComponent(
        UUID commentId, String content, Date createdAt, Member memberimpl, Task taskimpl
    ) {
        this.commentId = commentId;
        this.content = content;
        this.createdAt = createdAt;
        this.memberimpl = memberimpl;
        this.taskimpl = taskimpl;
    }

	public UUID getCommentId() {
		return this.commentId;
	}

	public void setCommentId(UUID commentId) {
		this.commentId = commentId;
	}

	public String getContent() {
		return this.content;
	}
	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	
	public Member getMemberimpl() {
		return this.memberimpl;
	}

	public void setMemberimpl(MemberImpl memberimpl) {
		this.memberimpl = memberimpl;
	}
	public Task getTaskimpl() {
		return this.taskimpl;
	}
	public void setTaskimpl(TaskImpl taskimpl) {
		this.taskimpl = taskimpl;
	}
	

	@Override
    public String toString() {
        return "{" +
            " CommentId='" + getCommentId() + "'" +
            " Content='" + getContent() + "'" +
            " createdAt='" + getCreatedAt() + "'" +
            " memberimpl='" + getMemberimpl() + "'" +
            " taskimpl='" + getTaskimpl() + "'" +
            "}";
    }
	
}
