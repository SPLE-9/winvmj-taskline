package taskline.notes.core;
import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;

//add other required packages

public abstract class NotesServiceComponent implements NotesService{
	protected RepositoryUtil<Notes> notesRepository;

    public NotesServiceComponent(){
        this.notesRepository = new RepositoryUtil<Notes>(taskline.notes.core.NotesComponent.class);
    }	

    public abstract HashMap<String,Object> saveNotes(Map<String, Object> requestBody);
	public abstract HashMap<String, Object> updateNotes(Map<String, Object> requestBody);
    public abstract List<HashMap<String,Object>> getAllNotes();
    public abstract HashMap<String,Object> deleteNotes(Map<String, Object> requestBody);
	public abstract HashMap<String, Object> getNotesById(String notesId);
	public abstract List<HashMap<String,Object>> getNotesByMemberId(String projectId);
	
	public abstract List<HashMap<String,Object>> transformListToHashMap(List<Notes> List);
}
