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
import prices.auth.vmj.annotations.Restricted;
//add other required packages
import taskline.task.core.Task;
import taskline.project.core.ProjectService;
import taskline.project.core.ProjectServiceImpl;
import taskline.member.core.MemberService;
import taskline.member.core.MemberImpl;
import taskline.project.core.ProjectImpl;
import taskline.member.core.Member;
import taskline.project.core.Project;

public class NotesServiceImpl extends NotesServiceComponent{
	
	private NotesFactory notesFactory = new NotesFactory();
//	private ProjectService projectService = new ProjectServiceImpl();
	private MemberService memberServices = new MemberServiceImpl();
	private final Gson gson = new Gson();

    public List<HashMap<String,Object>> saveNotes(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		Notes notes = createNotes(vmjExchange);
		notesRepository.saveObject(notes);
		return getAllNotes(vmjExchange);
	}

    public HashMap<String, Object> updateNotes(Map<String, Object> requestBody){
		String idStr = (String) requestBody.get("notesId");
		int id = Integer.parseInt(idStr);
		Notes notes = Repository.getObject(id);
		
		notes.setTitle((String) requestBody.get("title"));
		notes.setNotes((String) requestBody.get("notes"));
		
		Repository.updateObject(notes);
		
		//to do: fix association attributes
		
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
    	List<Notes> notesList = notesRepository.getAllObject("notesImpl");

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
