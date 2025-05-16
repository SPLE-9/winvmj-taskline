package taskline.notes.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public interface NotesResource {
    HashMap<String,Object> saveNotes(VMJExchange vmjExchange);
    HashMap<String, Object> updateNotes(VMJExchange vmjExchange);
    HashMap<String, Object> getNotesById(VMJExchange vmjExchange);
    List<HashMap<String,Object>> getAllNotes(VMJExchange vmjExchange);
    HashMap<String,Object> deleteNotes(VMJExchange vmjExchange);
	List<HashMap<String,Object>> getNotesByMemberId(VMJExchange vmjExchange);
}
