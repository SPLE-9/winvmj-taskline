package taskline.notes.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="notes_comp")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class NotesComponent implements Notes{
	@Id
	public UUID notesId; 
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

	public abstract UUID getNotesId();
	public abstract void setNotesId(UUID notesId);
	
	public abstract String getTitle();
	public abstract void setTitle(String title);
	
	public abstract String getNotes();
	public abstract void setNotes(String notes);
	
	public abstract MemberImpl getMemberimpl();
	public abstract void setMemberimpl(MemberImpl memberimpl);
	
 

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
