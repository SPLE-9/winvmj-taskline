package taskline.notes.core;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import java.util.*;

public interface Notes {
	public UUID getNotesId();
	public void setNotesId(UUID notesId);
	public String getTitle();
	public void setTitle(String title);
	public String getNotes();
	public void setNotes(String notes);
	public UserImpl getUserimpl();
	public void setUserimpl(UserImpl userimpl);
	org.eclipse.uml2.uml.internal.impl.ClassImpl@621c85c (name: NotesImpl, visibility: package) (isLeaf: false, isAbstract: false, isFinalSpecialization: false) (isActive: false)
	HashMap<String, Object> toHashMap();
}
