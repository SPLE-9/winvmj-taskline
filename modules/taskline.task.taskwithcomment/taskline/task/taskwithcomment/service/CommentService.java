package taskline.task.taskwithcomment;

import java.util.*;
import vmj.routing.route.VMJExchange;

public interface CommentService {
    HashMap<String,Object> saveComment(Map<String, Object> requestBody); 
    HashMap<String,Object> deleteComment(Map<String, Object> requestBody);
	HashMap<String, Object> updateComment(Map<String, Object> requestBody);
    List<HashMap<String,Object>> getAllComment();
    List<HashMap<String,Object>> getCommentByTaskId(String taskId);
    HashMap<String, Object> getCommentById(String commentId);

    List<HashMap<String,Object>> transformListToHashMap(List<Comment> commentList);
}
