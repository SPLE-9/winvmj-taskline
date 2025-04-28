package taskline..taskwithcomment;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.OneToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.CascadeType;
//add other required packages

@MappedSuperclass
public abstract class CommentDecorator extends CommentComponent{
	protected CommentComponent record;
	
	public CommentDecorator () {
		super();
		this.record = record;
		this.commentId =  commentId.randomUUID();
	}

	public CommentDecorator (CommentComponent record) {
		this.record = record;
	}

	public UUID getCommentId() {
		return record.getCommentId();
	}
	public void setCommentId(UUID commentId) {
		record.setCommentId(commentId);
	}


}
