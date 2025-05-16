package taskline.notes.core;
import java.util.*;

public abstract class NotesResourceDecorator extends NotesResourceComponent{
	protected NotesResourceComponent record;

    public NotesResourceDecorator(NotesResourceComponent record) {
        this.record = record;
    }
    
    public HashMap<String,Object> saveNotes(VMJExchange vmjExchange) {
		return record.saveNotes(vmjExchange);
	}

    public HashMap<String, Object> updateNotes(VMJExchange vmjExchange){
		return record.updateNotes(vmjExchange);
	}

    public HashMap<String, Object> getNotesById(VMJExchange vmjExchange){
		return record.getNotesById(vmjExchange);
	}

    public List<HashMap<String,Object>> getAllNotes(VMJExchange vmjExchange){
		return record.getAllNotes(vmjExchange);
	}

    public HashMap<String,Object> deleteNotes(VMJExchange vmjExchange){
		return record.deleteNotes(vmjExchange);
	}
    
    public List<HashMap<String,Object>> getNotesByMemberId(VMJExchange vmjExchange) {
		return record.getAllNotes(vmjExchange);
	}

//	public void getNotesByMemberId(UUID memberId) {
//		return record.getNotesByMemberId(memberId);
//	}
}
