package taskline.task.taskwithcomment;

import java.util.*;
import com.google.gson.Gson;
import java.util.*;
import java.util.logging.Logger;
import java.io.File;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import vmj.routing.route.exceptions.*;
//add other required packages
import taskline.task.core.TaskService;
import taskline.task.core.TaskServiceImpl;
import taskline.task.core.TaskImpl;
import taskline.task.core.Task;
import taskline.member.core.MemberService;
import taskline.member.core.MemberServiceImpl;
import taskline.member.core.MemberImpl;
import taskline.member.core.Member;


public class CommentServiceImpl extends CommentServiceComponent {
	
	private CommentFactory commentFactory = new CommentFactory();
	private TaskService taskService = new TaskServiceImpl();
	private MemberService memberService = new MemberServiceImpl();
	private final Gson gson = new Gson();


    public HashMap<String,Object> saveComment(Map<String, Object> requestBody){
		if (!requestBody.containsKey("content")) {
            throw new FieldValidationException("Field 'content' not found in the request body.");
        }

		if (!requestBody.containsKey("taskId")) {
            throw new FieldValidationException("Field 'taskId' not found in the request body.");
        }

		if (!requestBody.containsKey("memberId")) {
            throw new FieldValidationException("Field 'memberId' not found in the request body.");
        }

		String memberIdStr = (String) requestBody.get("memberId");
		UUID memberId = UUID.fromString(memberIdStr);
		Member member= memberService.getMemberById(memberId);

		String taskId = (String) requestBody.get("taskId");
		HashMap<String, Object> taskMap = taskService.getTaskById(taskId);
		String taskjson = gson.toJson(taskMap);
		
		Task task = gson.fromJson(taskjson, TaskImpl.class);
		String content = (String) requestBody.get("content");


		Comment comment = commentFactory.createComment("taskline.task.taskwithcomment.CommentImpl", content, member, task);
		commentRepository.saveObject(comment);
		
		return comment.toHashMap();
	}

    public HashMap<String, Object> updateComment(Map<String, Object> requestBody){
		if (!requestBody.containsKey("content")) {
            throw new FieldValidationException("Field 'content' not found in the request body.");
        }
		
		if (!requestBody.containsKey("commentId")) {
    		throw new FieldValidationException("Field 'commentId' not found in the request body.");
    	}

		if (!requestBody.containsKey("memberId")) {
    		throw new FieldValidationException("Field 'memberId' not found in the request body.");
    	}

		String commentIdStr = (String) requestBody.get("commentId");
		UUID commentId = UUID.fromString(commentIdStr);

		String memberIdStr = (String) requestBody.get("memberId");
		UUID memberId = UUID.fromString(memberIdStr);
		
		Comment comment  = commentRepository.getObject(commentId);
		if (comment == null) {
	        throw new NotFoundException("Comment with commentId " + commentId +" not found");
	    }

		Member commentBy = comment.getMemberimpl();
		if (!memberId.equals(commentBy.getMemberId())) {
	        throw new NotFoundException("Different Member Id, can't update comment");
	    }

		if (requestBody.containsKey("content")) {
        	String content =  (String) requestBody.get("content");
            comment.setContent(content);
        }
		
		commentRepository.updateObject(comment);
		
		return comment.toHashMap();
		
	}


	public HashMap<String, Object> getCommentById(String commentIdStr){
		UUID commentId = UUID.fromString(commentIdStr);
		Comment comment = commentRepository.getObject(commentId);

		if (comment == null) {
			throw new NotFoundException("Comment with commentId " + commentId +" not found");
		}

		return comment.toHashMap();
	}

    public List<HashMap<String,Object>> getAllComment(){
		List<Comment> commentList = commentRepository.getAllObject("comment_impl");
		
		return transformListToHashMap(commentList);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<Comment> commentList){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(Comment comment : commentList) {
            resultList.add(comment.toHashMap());
        }

        return resultList;
	}

    public HashMap<String,Object> deleteComment(Map<String, Object> requestBody){
		if (!requestBody.containsKey("commentId")) {
    		throw new FieldValidationException("Field 'commentId' not found in the request body.");
    	}

		if (!requestBody.containsKey("memberId")) {
    		throw new FieldValidationException("Field 'memberId' not found in the request body.");
    	}
		
		String memberIdStr = (String) requestBody.get("memberId");
		UUID memberId = UUID.fromString(memberIdStr);

		String commentIdStr = (String) requestBody.get("commentId");
		UUID commentId = UUID.fromString(commentIdStr);
		Comment comment = commentRepository.getObject(commentId);
		
		if (comment == null) {
			throw new NotFoundException("Comment with comment " + commentId +" not found");
		}

		Member commentBy = comment.getMemberimpl();
		if (!memberId.equals(commentBy.getMemberId())) {
	        throw new NotFoundException("Different Member Id, can't delete comment");
	    }

		commentRepository.deleteObject(commentId);
		
		return comment.toHashMap();
 
	}

	public List<HashMap<String,Object>> getCommentByTaskId(String taskIdStr) {
		UUID taskId = UUID.fromString(taskIdStr);
		List<Comment> commentList = commentRepository.getListObject("comment_impl", "taskimpl_taskid", taskId);

		return transformListToHashMap(commentList);
	}
}
