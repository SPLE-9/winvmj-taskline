package taskline.notes.core;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import java.util.*;
import taskline.member.core.MemberImpl;
import taskline.member.core.Member;

public interface Notes {
	public UUID getNotesId();
	public void setNotesId(UUID notesId);
	public String getTitle();
	public void setTitle(String title);
	public String getNotes();
	public void setNotes(String notes);
	public Member getMemberimpl();
	public void setMemberimpl(MemberImpl memberimpl);
	HashMap<String, Object> toHashMap();
}
