package taskline.notes.core;
import java.util.*;

//add other required packages

public abstract class NotesServiceComponent implements NotesService{
	protected RepositoryUtil<Notes> Repository;

    public NotesServiceComponent(){
        this.Repository = new RepositoryUtil<Notes>(taskline.notes.core.NotesComponent.class);
    }	

    public abstract List<HashMap<String,Object>> saveNotes(VMJExchange vmjExchange);
    public abstract Notes createNotes(Map<String, Object> requestBodye);
	public abstract Notes createNotes(Map<String, Object> requestBody, Map<String, Object> response);    
	public abstract HashMap<String, Object> updateNotes(Map<String, Object> requestBody);
    public abstract HashMap<String, Object> getNotes(Map<String, Object> requestBody);
    public abstract List<HashMap<String,Object>> getAllNotes(Map<String, Object> requestBody);
    public abstract List<HashMap<String,Object>> transformListToHashMap(List<Notes> List);
    public abstract List<HashMap<String,Object>> deleteNotes(Map<String, Object> requestBody);
	public abstract HashMap<String, Object> getNotesById(int id);

	public abstract void getNotesByUserId(UUID userId);
}
