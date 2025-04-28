package taskline.notes.core;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

public abstract class NotesResourceDecorator extends NotesResourceComponent{
	protected NotesResourceComponent record;

    public NotesResourceDecorator(NotesResourceComponent record) {
        this.record = record;
    }

    public List<HashMap<String,Object>> saveNotes(VMJExchange vmjExchange){
		return record.saveNotes(vmjExchange);
	}

    public Notes createNotes(VMJExchange vmjExchange){
		return record.createNotes(vmjExchange);
	}

    public Notes createNotes(VMJExchange vmjExchange, int id){
		return record.createNotes(vmjExchange, id);
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

}
