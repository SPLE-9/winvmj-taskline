package taskline.task.taskwithcomment;
import java.util.*;

import vmj.routing.route.VMJExchange;

public interface CommentResource {
    HashMap<String,Object> saveComment(VMJExchange vmjExchange);
    HashMap<String, Object> updateComment(VMJExchange vmjExchange);
    HashMap<String, Object> getCommentById(VMJExchange vmjExchange);
    HashMap<String,Object> deleteComment(VMJExchange vmjExchange);
    List<HashMap<String,Object>> getAllComment(VMJExchange vmjExchange);
    List<HashMap<String,Object>> getCommentByTaskId(VMJExchange vmjExchange);

}
