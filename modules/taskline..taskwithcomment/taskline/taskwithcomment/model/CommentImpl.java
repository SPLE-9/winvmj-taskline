package taskline..taskwithcomment;

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


@Entity(name="_impl")
@Table(name="_impl")
public class CommentImpl extends CommentComponent {

	public CommentImpl(UUID commentId, String content, EDate createdAt, TaskImpl taskimpl, UserImpl userimpl) {
		this.commentId = commentId;
		this.content = content;
		this.createdAt = createdAt;
		this.taskimpl = taskimpl;
		this.userimpl = userimpl;
	}


}
