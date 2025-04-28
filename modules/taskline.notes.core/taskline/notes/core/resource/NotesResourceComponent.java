package taskline.notes.core;
import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;
//add other required packages

public abstract class NotesResourceComponent implements NotesResource{
	
	public NotesResourceComponent() { }
 
    public abstract List<HashMap<String,Object>> saveNotes(VMJExchange vmjExchange);
    public abstract Notes createNotes(VMJExchange vmjExchange);
	public abstract Notes createNotes(VMJExchange vmjExchange, int id);    
	public abstract HashMap<String, Object> updateNotes(VMJExchange vmjExchange);
    public abstract HashMap<String, Object> getNotes(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> getAllNotes(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> deleteNotes(VMJExchange vmjExchange);

}
