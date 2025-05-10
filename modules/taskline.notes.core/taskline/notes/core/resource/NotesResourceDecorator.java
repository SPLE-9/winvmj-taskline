package taskline.notes.core;
import java.util.*;

public abstract class NotesResourceDecorator extends NotesResourceComponent{
	protected NotesResourceComponent record;

    public NotesResourceDecorator(NotesResourceComponent record) {
        this.record = record;
    }

    public Notes createNotes(VMJExchange vmjExchange){
		return record.createNotes(vmjExchange);
	}

    public HashMap<String, Object> updateNotes(VMJExchange vmjExchange){
		return record.updateNotes(vmjExchange);
	}

    public HashMap<String, Object> getNotes(VMJExchange vmjExchange){
		return record.getNotes(vmjExchange);
	}

    public List<HashMap<String,Object>> getAllNotes(VMJExchange vmjExchange){
		return record.getAllNotes(vmjExchange);
	}

    public List<HashMap<String,Object>> deleteNotes(VMJExchange vmjExchange){
		return record.deleteNotes(vmjExchange);
	}

	public void getNotesByMemberId(UUID memberId) {
		return record.getNotesByMemberId(memberId);
	}
}
