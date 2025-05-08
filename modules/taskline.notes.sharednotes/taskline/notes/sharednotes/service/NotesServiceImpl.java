package taskline.notes.sharednotes;

import java.util.*;

import vmj.routing.route.VMJExchange;

import taskline.notes.core.NotesServiceDecorator;
import taskline.notes.core.NotesImpl;
import taskline.notes.core.NotesServiceComponent;

public class NotesServiceImpl extends NotesServiceDecorator {
    public NotesServiceImpl (NotesServiceComponent record) {
        super(record);
    }

    
	public void getSharedUsers() {
		// TODO: implement this method
	}
}
