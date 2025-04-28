package taskline..taskwithcomment;;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="_comp")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class CommentComponent implements {
	
	@Id
	protected UUID commentId; 
	protected UUID commentId;
	public String content;
	public EDate createdAt;
	public TaskImpl taskimpl;
	public UserImpl userimpl;

	public CommentComponent() {

	} 
	public UUID getCommentId() {
		return this.commentId;
	}

	public void setCommentId(UUID commentId) {
		this.commentId = commentId;
	}
 
}
