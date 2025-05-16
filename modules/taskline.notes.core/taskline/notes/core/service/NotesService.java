package taskline.notes.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public interface NotesService {
	List<HashMap<String,Object>> saveNotes(Map<String, Object> requestBody);
	List<HashMap<String,Object>> deleteNotes(Map<String, Object> requestBody);
	HashMap<String, Object> updateNotes(Map<String, Object> requestBody);
	List<HashMap<String,Object>> getAllNotes(Map<String, Object> requestBody);
    HashMap<String, Object> getNotesById(String notesId);
    
	List<HashMap<String, Object>> transformListToHashMap(List<Disbursement> List);
	
	List<HashMap<String,Object>> getNotesByMemberId(String memberId);
	
//	Notes createNotes(Map<String, Object> requestBody);
//	Notes createNotes(Map<String, Object> requestBody, Map<String, Object> response);
//	HashMap<String, Object> getNotes(Map<String, Object> requestBody);
}
