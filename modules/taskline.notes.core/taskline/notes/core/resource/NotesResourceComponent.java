package taskline.notes.core;
import java.util.*;

import taskline.notes.core.Notes;
import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;
//add other required packages

public abstract class NotesResourceComponent implements NotesResource{
	
	protected RepositoryUtil<Notes> notesRepository;
	
	public NotesResourceComponent() {
		this.notesRepository = new RepositoryUtil<Notes>(taskline.notes.core.NotesComponent.class);
	}
 
	public abstract HashMap<String,Object> saveNotes(VMJExchange vmjExchange);
	public abstract HashMap<String, Object> updateNotes(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> getAllNotes(VMJExchange vmjExchange);
    public abstract HashMap<String,Object> deleteNotes(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> getNotesByMemberId(VMJExchange vmjExchange);

//	public abstract void getNotesByMemberId(UUID memberId);
}
