package taskline.task.taskwithcomment;
import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;
//add other required packages

public abstract class CommentResourceComponent implements CommentResource {
	
	protected RepositoryUtil<Comment> commentRepository;

    public CommentResourceComponent() {
        this.commentRepository = new RepositoryUtil<Comment>(taskline.task.taskwithcomment.CommentComponent.class);
    }	
 
    public abstract HashMap<String,Object> saveComment(VMJExchange vmjExchange);
    public abstract HashMap<String, Object> updateComment(VMJExchange vmjExchange);
    public abstract HashMap<String, Object> getCommentById(VMJExchange vmjExchange);
    public abstract HashMap<String,Object> deleteComment(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> getAllComment(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> getCommentByTaskId(VMJExchange vmjExchange);
}
