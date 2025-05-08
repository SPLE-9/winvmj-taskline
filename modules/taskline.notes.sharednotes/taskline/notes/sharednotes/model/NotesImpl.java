package taskline.notes.sharednotes;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;

import taskline.notes.core.NotesDecorator;
import taskline.notes.core.Notes;
import taskline.notes.core.NotesComponent;

@Entity(name="notes_sharednotes")
@Table(name="notes_sharednotes")
public class NotesImpl extends NotesDecorator {

	public NotesImpl(
        super();
        this.objectName = NotesImpl.class.getName();
    }
    
    public NotesImpl(UserImpl userimpl) {
    	super();
		this.objectName = NotesImpl.class.getName();
    }
	
	public NotesImpl(NotesComponent record, UserImpl userimpl) {
		super(record);
		this.objectName = NotesImpl.class.getName();
	}


	public void getSharedUsers() {
		// TODO: implement this method
	}

}
