package taskline.task.taskwithcomment;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import taskline.task.core.TaskResourceDecorator;
import taskline.task.core.TaskImpl;
import taskline.task.core.TaskResourceComponent;

public class TaskResourceImpl extends TaskResourceDecorator {
    public TaskResourceImpl (TaskResourceComponent record) {
        super(record);
    }

    // @Restriced(permission = "")
    @Route(url="call/taskwithcomment/save")
    public List<HashMap<String,Object>> save(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		TaskTaskWIthComment tasktaskwithcomment = createTaskTaskWIthComment(vmjExchange);
		tasktaskwithcommentRepository.saveObject(tasktaskwithcomment);
		return getAllTaskTaskWIthComment(vmjExchange);
	}

    public Task createTaskTaskWIthComment(VMJExchange vmjExchange){
		
		TaskTaskWIthComment tasktaskwithcomment = record.createTaskTaskWIthComment(vmjExchange);
		TaskTaskWIthComment tasktaskwithcommentdeco = TaskTaskWIthCommentFactory.createTaskTaskWIthComment("taskline.taskwithcomment.core.TaskImpl", tasktaskwithcomment, taskId, title, description, status, createdAt, userimpl, projectimpl
		);
			return tasktaskwithcommentdeco;
	}


    public Task createTaskTaskWIthComment(VMJExchange vmjExchange, int id){
		TaskTaskWIthComment tasktaskwithcomment = tasktaskwithcommentRepository.getObject(id);
		int recordTaskTaskWIthCommentId = (((TaskTaskWIthCommentDecorator) savedTaskTaskWIthComment.getRecord()).getId();
		
		TaskTaskWIthComment tasktaskwithcomment = record.createTaskTaskWIthComment(vmjExchange);
		TaskTaskWIthComment tasktaskwithcommentdeco = TaskTaskWIthCommentFactory.createTaskTaskWIthComment("taskline.taskwithcomment.core.TaskImpl", id, tasktaskwithcomment, taskId, title, description, status, createdAt, userimpl, projectimpl
		);
			return tasktaskwithcommentdeco;
	}

	// @Restriced(permission = "")
    @Route(url="call/taskwithcomment/update")
    public HashMap<String, Object> updateTaskTaskWIthComment(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		String idStr = (String) vmjExchange.getRequestBodyForm("taskId");
		int id = Integer.parseInt(idStr);
		
		TaskTaskWIthComment tasktaskwithcomment = tasktaskwithcommentRepository.getObject(id);
		tasktaskwithcomment = createTaskTaskWIthComment(vmjExchange, id);
		
		tasktaskwithcommentRepository.updateObject(tasktaskwithcomment);
		tasktaskwithcomment = tasktaskwithcommentRepository.getObject(id);
		//to do: fix association attributes
		
		return tasktaskwithcomment.toHashMap();
		
	}

	// @Restriced(permission = "")
    @Route(url="call/taskwithcomment/detail")
    public HashMap<String, Object> getTaskTaskWIthComment(VMJExchange vmjExchange){
		return record.getTaskTaskWIthComment(vmjExchange);
	}

	// @Restriced(permission = "")
    @Route(url="call/taskwithcomment/list")
    public List<HashMap<String,Object>> getAllTaskTaskWIthComment(VMJExchange vmjExchange){
		List<TaskTaskWIthComment> tasktaskwithcommentList = tasktaskwithcommentRepository.getAllObject("tasktaskwithcomment_impl");
		return transformTaskTaskWIthCommentListToHashMap(tasktaskwithcommentList);
	}

    public List<HashMap<String,Object>> transformTaskTaskWIthCommentListToHashMap(List<TaskTaskWIthComment> TaskTaskWIthCommentList){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < TaskTaskWIthCommentList.size(); i++) {
            resultList.add(TaskTaskWIthCommentList.get(i).toHashMap());
        }

        return resultList;
	}

	// @Restriced(permission = "")
    @Route(url="call/taskwithcomment/delete")
    public List<HashMap<String,Object>> deleteTaskTaskWIthComment(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		String idStr = (String) vmjExchange.getRequestBodyForm("taskId");
		int id = Integer.parseInt(idStr);
		tasktaskwithcommentRepository.deleteObject(id);
		return getAllTaskTaskWIthComment(vmjExchange);
	}

	
}
