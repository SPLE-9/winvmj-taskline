package taskline.notes.core;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import vmj.routing.route.exceptions.*;
import taskline.notes.NotesFactory;
import prices.auth.vmj.annotations.Restricted;
//add other required packages


public class NotesResourceImpl extends NotesResourceComponent{
	
	private NotesServiceImpl notesServiceImpl = new NotesServiceImpl();

	// @Restriced(permission = "")
    @Route(url="call/notes/save")
    public List<HashMap<String,Object>> saveNotes(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		Notes notes = createNotes(vmjExchange);
		notesRepository.saveObject(notes);
		return getAllNotes(vmjExchange);
	}

	// @Restriced(permission = "")
    @Route(url="call/notes")
    public HashMap<String,Object> notes(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			Notes result = notesServiceImpl.createNotes(requestBody);
			return result.toHashMap();
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

    public Notes createNotes(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			Notes result = notesServiceImpl.createNotes(requestBody);
			return result.toHashMap();
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

    public Notes createNotes(VMJExchange vmjExchange, int id){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			Notes result = notesServiceImpl.createNotes(requestBody, id);
			return result.toHashMap();
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

	// @Restriced(permission = "")
    @Route(url="call/notes/update")
    public HashMap<String, Object> updateNotes(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")){
			return null;
		}
		return notesServiceImpl.updateNotes(requestBody);
		
	}

	// @Restriced(permission = "")
    @Route(url="call/notes/detail")
    public HashMap<String, Object> getNotes(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		return notesServiceImpl.getNotes(requestBody);
	}

	// @Restriced(permission = "")
    @Route(url="call/notes/list")
    public List<HashMap<String,Object>> getAllNotes(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		return notesServiceImpl.getAllNotes(requestBody);
	}

	// @Restriced(permission = "")
    @Route(url="call/notes/delete")
    public List<HashMap<String,Object>> deleteNotes(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		return notesServiceImpl.deleteNotes(requestBody);
	}


}
