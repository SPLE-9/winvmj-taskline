package taskline.notes.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.OneToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.CascadeType;
//add other required packages

@MappedSuperclass
public abstract class NotesDecorator extends NotesComponent{
    @OneToOne(cascade=CascadeType.ALL)
	protected NotesComponent record;

	public NotesDecorator () {
		super();
		this.record = record;
		this.notesId =  notesId.randomUUID();
		
	public NotesDecorator (NotesComponent record) {
		this.notesId =  notesId.randomUUID();
		this.record = record;
	}

	public NotesDecorator (UUID notesId, NotesComponent record) {
		this.notesId =  notesId;
		this.record = record;
	}
	
	public NotesDecorator (NotesComponent record, String objectName) {
		this.notesId =  notesId.randomUUID();
		this.record = record;	
		this.objectName=objectName;
	}

	public NotesDecorator() { }



	public HashMap<String, Object> toHashMap() {
        return this.record.toHashMap();
    }

}
