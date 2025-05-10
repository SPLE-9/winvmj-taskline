package taskline.project.projectwithmembers;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import taskline.project.core.ProjectResourceDecorator;
import taskline.project.core.ProjectImpl;
import taskline.project.core.ProjectResourceComponent;

public class ProjectResourceImpl extends ProjectResourceDecorator {
    public ProjectResourceImpl (ProjectResourceComponent record) {
        super(record);
    }

    // @Restriced(permission = "")
    @Route(url="call/projectwithmembers/save")
    public List<HashMap<String,Object>> save(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		  = create(vmjExchange);
		Repository.saveObject();
		return getAll(vmjExchange);
	}

    public Project create(VMJExchange vmjExchange){
		
		  = record.create(vmjExchange);
		 deco = Factory.create("taskline.projectwithmembers.core.ProjectImpl", , memberimpl);
			return deco;
	}

    public Project create(VMJExchange vmjExchange, int id){
		  = Repository.getObject(id);
		int recordId = (((Decorator) saved.getRecord()).getId();
		
		  = record.create(vmjExchange);
		 deco = Factory.create("taskline.projectwithmembers.core.ProjectImpl", id, , memberimpl);
			return deco;
	}

    // @Restriced(permission = "")
    @Route(url="call/projectwithmembers/update")
    public HashMap<String, Object> update(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		String idStr = (String) vmjExchange.getRequestBodyForm("");
		int id = Integer.parseInt(idStr);
		
		  = Repository.getObject(id);
		 = create(vmjExchange, id);
		
		Repository.updateObject();
		 = Repository.getObject(id);
		//to do: fix association attributes
		
		return .toHashMap();
		
	}

	// @Restriced(permission = "")
    @Route(url="call/projectwithmembers/detail")
    public HashMap<String, Object> get(VMJExchange vmjExchange){
		return record.getProject(vmjExchange);
	}

	// @Restriced(permission = "")
    @Route(url="call/projectwithmembers/list")
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
    @Route(url="call/projectwithmembers/delete")
    public List<HashMap<String,Object>> deleteProject(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		String idStr = (String) vmjExchange.getRequestBodyForm("");
		int id = Integer.parseInt(idStr);
		Repository.deleteObject(id);
		return getAll(vmjExchange);
	}

	public void getProjectsByMember(UUID memberId) {
		// TODO: implement this method
	}

	public void getProjectMembers(UUID projectId) {
		// TODO: implement this method
	}
}
