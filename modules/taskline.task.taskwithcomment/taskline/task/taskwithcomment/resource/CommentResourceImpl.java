package taskline.task.taskwithcomment;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import vmj.routing.route.exceptions.*;
import taskline.task.CommentFactory;
//import prices.auth.vmj.annotations.Restricted;
//add other required packages

public class CommentResourceImpl extends CommentResourceComponen {
	
	private CommentService commentService = new commentServiceImpl();

	@Route(url="call/comment/save")
    public HashMap<String,Object> saveComment(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			return commentService.saveComment(requestBody);
		}

		throw new NotFoundException("Route tidak ditemukan");
	}

    // @Restriced(permission = "")
    @Route(url="call/comment/update")
    public HashMap<String, Object> updateComment(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("PUT")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			return commentService.updateComment(requestBody);
		}

		throw new NotFoundException("Route tidak ditemukan");
		
	}

	// @Restriced(permission = "")
    @Route(url="call/comment/detail")
    public HashMap<String, Object> getCommentById(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("GET")) {
		    String commentIdStr = vmjExchange.getGETParam("commentId");
			return commentService.getCommentById(commentIdStr);
		}

		throw new NotFoundException("Route tidak ditemukan");
	}

	// @Restriced(permission = "")
    @Route(url="call/comment/list")
    public List<HashMap<String,Object>> getAllComment(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("GET")) {
			return commentService.getAllComment();
		}

		throw new NotFoundException("Route tidak ditemukan");
	}

    
	// @Restriced(permission = "")
    @Route(url="call/comment/delete")
    public HashMap<String,Object> deleteComment(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("DELETE")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			return commentService.deleteComment(requestBody);
		}

		throw new NotFoundException("Route tidak ditemukan");
	}

	@Route(url="call/task-comment/list")
	public List<HashMap<String,Object>> getCommentByProjectId(VMJExchange vmjExchange) {
		if (vmjExchange.getHttpMethod().equals("GET")) {
		    String projectIdStr = vmjExchange.getGETParam("taskId");
			return commentService.getCommentByProjectId(projectIdStr);
		}

		throw new NotFoundException("Route tidak ditemukan");
	}
}
