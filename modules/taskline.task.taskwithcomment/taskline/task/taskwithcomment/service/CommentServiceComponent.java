package taskline.task.taskwithcomment;
import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;
//add other required packages

public abstract class CommentServiceComponent implements CommentService {
	protected RepositoryUtil<Comment> commentRepository;

    public CommentServiceComponent(){
        this.commentRepository = new RepositoryUtil<Comment>(taskline.task.taskwithcomment.CommentComponent.class);
    }	

    public abstract HashMap<String,Object> saveComment(Map<String, Object> requestBody); 
    public abstract HashMap<String,Object> deleteComment(Map<String, Object> requestBody);
	public abstract HashMap<String, Object> updateComment(Map<String, Object> requestBody);
    public abstract List<HashMap<String,Object>> getAllComment();
    public abstract List<HashMap<String,Object>> getCommentByTaskId(String taskId);
    public abstract HashMap<String, Object> getCommentById(String commentId);

    public abstract List<HashMap<String,Object>> transformListToHashMap(List<Comment> commentList);
    
}
