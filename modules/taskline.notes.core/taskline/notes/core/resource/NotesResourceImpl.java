package taskline.notes.core;
import java.util.*;

import taskline.notes.core.NotesService;

//import prices.auth.vmj.annotations.Restricted;
//add other required packages

public class NotesResourceImpl extends NotesResourceComponent{
	
	private NotesService notesService = new NotesServiceImpl();
    
	@Route(url="call/notes/save")
    public HashMap<String,Object> saveNotes(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			return notesService.saveNotes(requestBody);
		}

		throw new NotFoundException("Route tidak ditemukan");
	}

    // @Restriced(permission = "")
    @Route(url="call/notes/update")
    public HashMap<String, Object> updateNotes(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("PUT")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			return notesService.updateNotes(requestBody);
		}

		throw new NotFoundException("Route tidak ditemukan");
		
	}

	// @Restriced(permission = "")
    @Route(url="call/notes/detail")
    public HashMap<String, Object> getNotesById(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("GET")) {
		    String notesIdStr = vmjExchange.getGETParam("notesId");
			return notesService.getNotesById(notesIdStr);
		}

		throw new NotFoundException("Route tidak ditemukan");
	}

	// @Restriced(permission = "")
    @Route(url="call/notes/list")
    public List<HashMap<String,Object>> getAllNotes(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("GET")) {
			return notesService.getAllNotes();
		}

		throw new NotFoundException("Route tidak ditemukan");
	}
    
	// @Restriced(permission = "")
    @Route(url="call/notes/delete")
    public HashMap<String,Object> deleteNotes(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("DELETE")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			return notesService.deleteNotes(requestBody);
		}

		throw new NotFoundException("Route tidak ditemukan");
	}
    
	@Route(url="call/member-notes/list")
	public List<HashMap<String,Object>> getNotesByMemberId(VMJExchange vmjExchange) {
		if (vmjExchange.getHttpMethod().equals("GET")) {
		    String memberIdStr = vmjExchange.getGETParam("memberId");
			return taskService.getNotesByMemberId(memberIdStr);
		}

		throw new NotFoundException("Route tidak ditemukan");
	}

}
