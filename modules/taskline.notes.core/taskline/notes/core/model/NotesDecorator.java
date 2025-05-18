package taskline.notes.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.OneToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.CascadeType;
import taskline.member.core.MemberImpl;
import taskline.member.core.Member;
//add other required packages

@MappedSuperclass
public abstract class NotesDecorator extends NotesComponent{
    @OneToOne(cascade=CascadeType.ALL)
	protected NotesComponent record;

	public NotesDecorator () {
		super();
		this.record = record;
		this.notesId =  notesId.randomUUID();
	}
		
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
	
	public UUID getNotesId() {
		return this.record.getNotesId();
	}

	public void setNotesId(UUID notesId) {
		this.record.setNotesId(notesId);
	}

	public String getTitle() {
		return this.record.getTitle();
	}
	public void setTitle(String title) {
		this.record.setTitle(title);
	}

	public String getNotes() {
		return this.record.getNotes();
	}

	public void setNotes(String notes) {
		this.record.setNotes(notes);
	}

	public Member getMemberimpl() {
		return this.record.getMemberimpl();
	}

	public void setMemberimpl(MemberImpl memberimpl) {
		this.record.setMemberimpl(memberimpl);
	}


	public HashMap<String, Object> toHashMap() {
        return this.record.toHashMap();
    }

}
