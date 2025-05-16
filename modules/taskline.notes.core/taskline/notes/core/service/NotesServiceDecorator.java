package taskline.notes.core;
import java.util.*;


public abstract class NotesServiceDecorator extends NotesServiceComponent{
	protected NotesServiceComponent record;

    public NotesServiceDecorator(NotesServiceComponent record) {
        this.record = record;
    }

	public NotesImpl createNotes(Map<String, Object> requestBody){
		return record.createNotes(requestBody);
	}

    public Notes createNotes(Map<String, Object> requestBody, Map<String, Object> response){
		return record.createNotes(requestBody, response);
	}

	public HashMap<String, Object> getNotes(Map<String, Object> requestBody){
		return record.getNotes(requestBody);
	}

	public List<HashMap<String,Object>> getAllNotes(Map<String, Object> requestBody){
		return record.getAllNotes(requestBody);
	}

    public List<HashMap<String,Object>> saveNotes(VMJExchange vmjExchange){
		return record.saveNotes(vmjExchange);
	}

    public HashMap<String, Object> updateNotes(Map<String, Object> requestBody){
		return record.updateNotes(requestBody);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<Notes> List){
		return record.transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> deleteNotes(Map<String, Object> requestBody){
		return record.deleteNotes(requestBody);
	}

	public HashMap<String, Object> getNotesById(int id){
        return record.getNotesById(id);
    }

	public void getNotesByMemberId(UUID memberId) {
		return record.getNotesByMemberId(memberId);
	}
}
