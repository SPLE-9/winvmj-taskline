package taskline.notes.core;

import java.lang.Math;
import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import taskline.member.core.MemberImpl;
import taskline.member.core.Member;


@Entity(name="notes_impl")
@Table(name="notes_impl")
public class NotesImpl extends NotesComponent {

	public NotesImpl(String title, String notes) {
		this.notesId = UUID.randomUUID();
		this.title = title;
		this.notes = notes;
		this.memberimpl = null;
	}

//	public NotesImpl(UUID notesId, String title, String notes, MemberImpl memberimpl) {
//		this.notesId =  notesId.randomUUID();;
//		this.notesId = notesId;
//		this.title = title;
//		this.notes = notes;
//		this.memberimpl = memberimpl;
//	}

	public NotesImpl() { 
		this.notesId = UUID.randomUUID();
		this.title = "";
		this.notes = "";
		this.memberimpl = null;
	}


	
	public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> notesMap = new HashMap<String,Object>();
		notesMap.put("notesId",getNotesId());
		notesMap.put("title",getTitle());
		notesMap.put("notes",getNotes());
		notesMap.put("memberimpl",getMemberimpl());

        return notesMap;
    }

}
