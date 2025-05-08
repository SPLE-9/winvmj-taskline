package taskline.notes.core;
import java.util.*;
//add other required packages

public abstract class NotesResourceComponent implements NotesResource{
	
	public NotesResourceComponent() { }
 
    public abstract Notes createNotes(VMJExchange vmjExchange);    
	public abstract HashMap<String, Object> updateNotes(VMJExchange vmjExchange);
    public abstract HashMap<String, Object> getNotes(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> getAllNotes(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> deleteNotes(VMJExchange vmjExchange);

	public abstract void getNotesByUserId(UUID userId);
}
