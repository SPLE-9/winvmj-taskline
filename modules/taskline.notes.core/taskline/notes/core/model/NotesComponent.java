package taskline.notes.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.CascadeType;
import javax.persistence.Table;

import taskline.member.core.MemberImpl;
import taskline.member.core.Member;
import taskline.member.core.MemberComponent;

@Entity
@Table(name="notes_comp")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class NotesComponent implements Notes{
	@Id
	public UUID notesId; 
	public String title;
	public String notes;
	@ManyToOne(targetEntity=taskline.member.core.MemberComponent.class)
	public Member memberimpl;
	protected String objectName = NotesComponent.class.getName();

	public NotesComponent() {

	} 

	public NotesComponent(
        UUID notesId, String title, String notes, MemberImpl memberimpl
    ) {
        this.notesId = notesId;
        this.title = title;
        this.notes = notes;
        this.memberimpl = memberimpl;
    }

	public UUID getNotesId() {
		return this.notesId;
	}
	public void setNotesId(UUID notesId) {
		this.notesId = notesId;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public void setTitle(String title){
		this.title = title;
	}
	
	public String getNotes() {
		return this.notes;
	}
	
	public void setNotes(String notes) {
		this.notes = notes;
	}
	
	public Member getMemberimpl() {
		return this.memberimpl;
	}
	public void setMemberimpl(MemberImpl memberimpl) {
		this.memberimpl = memberimpl;
	}
	
 

	@Override
    public String toString() {
        return "{" +
            " notesId='" + getNotesId() + "'" +
            " title='" + getTitle() + "'" +
            " notes='" + getNotes() + "'" +
            " memberimpl='" + getMemberimpl() + "'" +
            "}";
    }
	
}
