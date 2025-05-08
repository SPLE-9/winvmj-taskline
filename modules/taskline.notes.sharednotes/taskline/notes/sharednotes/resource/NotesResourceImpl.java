package taskline.notes.sharednotes;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import taskline.notes.core.NotesResourceDecorator;
import taskline.notes.core.NotesImpl;
import taskline.notes.core.NotesResourceComponent;

public class NotesResourceImpl extends NotesResourceDecorator {
    public NotesResourceImpl (NotesResourceComponent record) {
        super(record);
    }

    // @Restriced(permission = "")
    @Route(url="call/sharednotes/save")
    public List<HashMap<String,Object>> save(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		  = create(vmjExchange);
		Repository.saveObject();
		return getAll(vmjExchange);
	}

    public Notes create(VMJExchange vmjExchange){
		
		  = record.create(vmjExchange);
		 deco = Factory.create("taskline.sharednotes.core.NotesImpl", , userimpl);
			return deco;
	}

    public Notes create(VMJExchange vmjExchange, int id){
		  = Repository.getObject(id);
		int recordId = (((Decorator) saved.getRecord()).getId();
		
		  = record.create(vmjExchange);
		 deco = Factory.create("taskline.sharednotes.core.NotesImpl", id, , userimpl);
			return deco;
	}

    // @Restriced(permission = "")
    @Route(url="call/sharednotes/update")
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
    @Route(url="call/sharednotes/detail")
    public HashMap<String, Object> get(VMJExchange vmjExchange){
		return record.getNotes(vmjExchange);
	}

	// @Restriced(permission = "")
    @Route(url="call/sharednotes/list")
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
    @Route(url="call/sharednotes/delete")
    public List<HashMap<String,Object>> deleteNotes(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		String idStr = (String) vmjExchange.getRequestBodyForm("");
		int id = Integer.parseInt(idStr);
		Repository.deleteObject(id);
		return getAll(vmjExchange);
	}

	public void getSharedUsers() {
		// TODO: implement this method
	}
}
