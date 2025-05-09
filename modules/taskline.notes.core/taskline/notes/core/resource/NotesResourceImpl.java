package taskline.notes.core;
import java.util.*;

//import prices.auth.vmj.annotations.Restricted;
//add other required packages

public class NotesResourceImpl extends NotesResourceComponent{
	
	private NotesServiceImpl notesServiceImpl = new NotesServiceImpl();

	// @Restriced(permission = "")
    @Route(url="call/notes")
    public HashMap<String,Object> createnotes(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			Notes result = notesServiceImpl.createNotes(requestBody);
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
    
    @Route(url="call/notes/id}")
    public HashMap<String, Object> getNotesByUserId(VMJExchange vmjExchange) {
    	 String idStr = vmjExchange.getGETParam("id");
         if (idStr == null) {
             throw new IllegalArgumentException("Invalid id");
         }
    	UUID userId = UUID.fromString(idStr);
    	return notesServiceImpl.getNotesByUserId(userId);
    }

}
