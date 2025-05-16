package taskline.notes.core;
import java.util.*;

//add other required packages

public abstract class NotesServiceComponent implements NotesService{
	protected RepositoryUtil<Notes> Repository;

    public NotesServiceComponent(){
        this.Repository = new RepositoryUtil<Notes>(taskline.notes.core.NotesComponent.class);
    }	

    public abstract List<HashMap<String,Object>> saveNotes(VMJExchange vmjExchange);
	public abstract HashMap<String, Object> updateNotes(Map<String, Object> requestBody);
    public abstract List<HashMap<String,Object>> getAllNotes();
    public abstract List<HashMap<String,Object>> deleteNotes(Map<String, Object> requestBody);
	public abstract HashMap<String, Object> getNotesById(string notesId);
	public abstract List<HashMap<String,Object>> getNotesByMemberId(String projectId);
	
	public abstract List<HashMap<String,Object>> transformListToHashMap(List<Notes> List);
}
