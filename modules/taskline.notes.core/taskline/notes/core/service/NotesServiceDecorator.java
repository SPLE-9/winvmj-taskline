package taskline.notes.core;
import java.util.*;


public abstract class NotesServiceDecorator extends NotesServiceComponent{
	protected NotesServiceComponent record;

    public NotesServiceDecorator(NotesServiceComponent record) {
        this.record = record;
    }

	public List<HashMap<String,Object>> getAllNotes(){
		return record.getAllNotes();
	}

    public HashMap<String,Object> saveNotes(Map<String, Object> requestBody){
		return record.saveNotes(requestBody);
	}

    public HashMap<String, Object> updateNotes(Map<String, Object> requestBody){
		return record.updateNotes(requestBody);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<Notes> List){
		return record.transformListToHashMap(List);
	}

    public HashMap<String,Object> deleteNotes(Map<String, Object> requestBody){
		return record.deleteNotes(requestBody);
	}

	public HashMap<String, Object> getNotesById(String notesId){
        return record.getNotesById(notesId);
    }
	
	public List<HashMap<String, Object>> getNotesByMemberId(String projectId){
        return record.getNotesByMemberId(projectId);
    }

//	public void getNotesByMemberId(UUID memberId) {
//		return record.getNotesByMemberId(memberId);
//	}
}
