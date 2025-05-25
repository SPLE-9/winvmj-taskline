package taskline.notes.core;
import java.util.*;
import com.google.gson.Gson;
import java.util.*;
import java.util.logging.Logger;
import java.io.File;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import vmj.routing.route.exceptions.*;
import taskline.notes.NotesFactory;
//add other required packages
import taskline.notes.core.Notes;
import taskline.member.core.MemberService;
import taskline.member.core.MemberImpl;
import taskline.member.core.Member;
import taskline.member.core.MemberServiceImpl;


public class NotesServiceImpl extends NotesServiceComponent{
	
	private NotesFactory notesFactory = new NotesFactory();
	private MemberService memberServices = new MemberServiceImpl();
	private final Gson gson = new Gson();

    public HashMap<String,Object> saveNotes(Map<String, Object> requestBody){
		String title = (String) requestBody.get("title");
		String notes = (String) requestBody.get("notes");

		Notes notesF = notesFactory.createNotes("taskline.notes.core.NotesImpl", title, notes);
		notesRepository.saveObject(notesF);
		
		return notesF.toHashMap();
	}

    public HashMap<String, Object> updateNotes(Map<String, Object> requestBody){
    	String notesIdStr = (String) requestBody.get("notesId");
		UUID notesId = UUID.fromString(notesIdStr);
    	Notes notes = notesRepository.getObject(notesId);
    	
		if (requestBody.containsKey("title")) {
        	String title =  (String) requestBody.get("title");
            notes.setTitle(title);
        }

		if (requestBody.containsKey("notes")) {
        	String description =  (String) requestBody.get("notes");
            notes.setNotes(description);
        }
		
		notesRepository.updateObject(notes);
		
		return notes.toHashMap();
		
	}

	public HashMap<String, Object> getNotesById(String notesIdStr){
		UUID notesId = UUID.fromString(notesIdStr);
		Notes notes = notesRepository.getObject(notesId);
		
		if (notes == null) {
			throw new NotFoundException("Notes with notesId " + notesId +" not found");
		}

		return notes.toHashMap();
	}

    public List<HashMap<String,Object>> getAllNotes(){
    	List<Notes> notesList = notesRepository.getAllObject("notes_impl");

		return transformListToHashMap(notesList);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<Notes> notesList){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(Notes notes: notesList) {
            resultList.add(notes.toHashMap());
        }

        return resultList;
	}
    
    public HashMap<String,Object> deleteNotes(Map<String, Object> requestBody){
		String notesIdStr = (String) requestBody.get("notesId");
		UUID notesId = UUID.fromString(notesIdStr);
		Notes notes = notesRepository.getObject(notesId);
		
		if (notes == null) {
			throw new NotFoundException("Notes with notesId " + notesId +" not found");
		}

		notesRepository.deleteObject(notesId);
		
		return notes.toHashMap();

	}

//	public Notes getNotesByMemberId(UUID memberId) {
//		return Repository.getObject(memberId);
//	}
	
	public List<HashMap<String,Object>> getNotesByMemberId(String memberIdStr) {
		UUID memberId = UUID.fromString(memberIdStr);
		List<Notes> notesList = notesRepository.getListObject("notes_impl", "memberimpl_memberid", memberId);

		return transformListToHashMap(notesList);
	}
}
