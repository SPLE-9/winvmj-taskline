package taskline.notes.core;
import java.util.*;

import taskline.notes.core.Notes;
import vmj.routing.route.VMJExchange;

public interface NotesService {
	HashMap<String,Object> saveNotes(Map<String, Object> requestBody);
	HashMap<String,Object> deleteNotes(Map<String, Object> requestBody);
	HashMap<String, Object> updateNotes(Map<String, Object> requestBody);
	List<HashMap<String,Object>> getAllNotes();
    HashMap<String, Object> getNotesById(String notesId);
    
    List<HashMap<String,Object>> transformListToHashMap(List<Notes> notesList);
	
	List<HashMap<String,Object>> getNotesByMemberId(String memberId);
	
//	Notes createNotes(Map<String, Object> requestBody);
//	Notes createNotes(Map<String, Object> requestBody, Map<String, Object> response);
//	HashMap<String, Object> getNotes(Map<String, Object> requestBody);
}
