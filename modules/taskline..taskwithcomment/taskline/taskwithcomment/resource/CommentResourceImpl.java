package taskline..taskwithcomment;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import taskline.taskwithcomment.CommentFactory;
import prices.auth.vmj.annotations.Restricted;
//add other required packages

public class CommentResourceImpl extends CommentResourceComponent{
	protected CommentResourceComponent record;

	// @Restriced(permission = "")
    @Route(url="call/taskwithcomment/save")
    public List<HashMap<String,Object>> save(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		  = create(vmjExchange);
		Repository.saveObject();
		return getAll(vmjExchange);
	}

    public  create(VMJExchange vmjExchange){
		String content = (String) vmjExchange.getRequestBodyForm("content");
		
		//to do: fix association attributes
		
		  = Factory.create("taskline.taskwithcomment.core.CommentImpl", commentId, content, createdAt, taskimpl, memberimpl);
			return ;
	}

    // @Restriced(permission = "")
    @Route(url="call/taskwithcomment/update")
    public HashMap<String, Object> update(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		String idStr = (String) vmjExchange.getRequestBodyForm("commentId");
		int id = Integer.parseInt(idStr);
		
		  = Repository.getObject(id);
		.setContent((String) vmjExchange.getRequestBodyForm("content"));
		
		Repository.updateObject();
		 = Repository.getObject(id);
		//to do: fix association attributes
		
		return .toHashMap();
		
	}

	// @Restriced(permission = "")
    @Route(url="call/taskwithcomment/detail")
    public HashMap<String, Object> get(VMJExchange vmjExchange){
		String idStr = vmjExchange.getGETParam("commentId"); 
		int id = Integer.parseInt(idStr);
		  = Repository.getObject(id);
		return .toHashMap();
	}

	// @Restriced(permission = "")
    @Route(url="call/taskwithcomment/list")
    public List<HashMap<String,Object>> getAll(VMJExchange vmjExchange){
		List<> List = Repository.getAllObject("_impl");
		return transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<> List){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < List.size(); i++) {
            resultList.add(List.get(i).toHashMap());
        }

        return resultList;
	}

	// @Restriced(permission = "")
    @Route(url="call/taskwithcomment/delete")
    public List<HashMap<String,Object>> delete(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		String idStr = (String) vmjExchange.getRequestBodyForm("commentId");
		int id = Integer.parseInt(idStr);
		Repository.deleteObject(id);
		return getAll(vmjExchange);
	}

}
