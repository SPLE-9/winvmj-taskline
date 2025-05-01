package taskline.notes.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public interface NotesResource {
    List<HashMap<String,Object>> saveNotes(VMJExchange vmjExchange);
    HashMap<String, Object> updateNotes(VMJExchange vmjExchange);
    HashMap<String, Object> getNotes(VMJExchange vmjExchange);
    List<HashMap<String,Object>> getAllNotes(VMJExchange vmjExchange);
    List<HashMap<String,Object>> deleteNotes(VMJExchange vmjExchange);
	HashMap<String, Object> createNotes(VMJExchange vmjExhange);
}
