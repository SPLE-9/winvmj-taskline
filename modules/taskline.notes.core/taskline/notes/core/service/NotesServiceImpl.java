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

public class NotesServiceImpl extends NotesServiceComponent{

    public List<HashMap<String,Object>> saveNotes(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		Notes notes = createNotes(vmjExchange);
		notesRepository.saveObject(notes);
		return getAllNotes(vmjExchange);
	}

    public Notes createNotes(Map<String, Object> requestBody){
		String title = (String) requestBody.get("title");
		String notes = (String) requestBody.get("notes");
		
		//to do: fix association attributes
		Notes Notes = NotesFactory.createNotes(
			"taskline.notes.core.NotesImpl",
		notesId
		, title
		, notes
		, userimpl
		);
		Repository.saveObject(notes);
		return notes;
	}

    public Notes createNotes(Map<String, Object> requestBody, int id){
		String title = (String) vmjExchange.getRequestBodyForm("title");
		String notes = (String) vmjExchange.getRequestBodyForm("notes");
		
		//to do: fix association attributes
		
		Notes notes = NotesFactory.createNotes("taskline.notes.core.NotesImpl", notesId, title, notes, userimpl);
		return notes;
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

    public HashMap<String, Object> getNotes(Map<String, Object> requestBody){
		List<HashMap<String, Object>> notesList = getAllNotes("notes_impl");
		for (HashMap<String, Object> notes : notesList){
			int record_id = ((Double) notes.get("record_id")).intValue();
			if (record_id == id){
				return notes;
			}
		}
		return null;
	}

	public HashMap<String, Object> getNotesById(int id){
		String idStr = vmjExchange.getGETParam("notesId"); 
		int id = Integer.parseInt(idStr);
		Notes notes = notesRepository.getObject(id);
		return notes.toHashMap();
	}

    public List<HashMap<String,Object>> getAllNotes(Map<String, Object> requestBody){
		String table = (String) requestBody.get("table_name");
		List<Notes> List = Repository.getAllObject(table);
		return transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<Notes> List){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < List.size(); i++) {
            resultList.add(List.get(i).toHashMap());
        }

        return resultList;
	}

    public List<HashMap<String,Object>> deleteNotes(Map<String, Object> requestBody){
		String idStr = ((String) requestBody.get("id"));
		int id = Integer.parseInt(idStr);
		Repository.deleteObject(id);
		return getAllNotes(requestBody);
	}

}
