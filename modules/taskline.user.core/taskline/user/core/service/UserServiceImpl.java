package taskline.user.core;
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
import taskline.user.UserFactory;
import prices.auth.vmj.annotations.Restricted;
//add other required packages

public class UserServiceImpl extends UserServiceComponent{

    public List<HashMap<String,Object>> saveUser(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		User user = createUser(vmjExchange);
		userRepository.saveObject(user);
		return getAllUser(vmjExchange);
	}

    public User createUser(Map<String, Object> requestBody){
		String email = (String) requestBody.get("email");
		String name = (String) requestBody.get("name");
		
		//to do: fix association attributes
		User User = UserFactory.createUser(
			"taskline.user.core.UserImpl",
		userId
		, email
		, name
		);
		Repository.saveObject(user);
		return user;
	}

    public User createUser(Map<String, Object> requestBody, int id){
		String email = (String) vmjExchange.getRequestBodyForm("email");
		String name = (String) vmjExchange.getRequestBodyForm("name");
		
		//to do: fix association attributes
		
		User user = UserFactory.createUser("taskline.user.core.UserImpl", userId, email, name);
		return user;
	}

    public HashMap<String, Object> updateUser(Map<String, Object> requestBody){
		String idStr = (String) requestBody.get("userId");
		int id = Integer.parseInt(idStr);
		User user = Repository.getObject(id);
		
		user.setEmail((String) requestBody.get("email"));
		user.setName((String) requestBody.get("name"));
		
		Repository.updateObject(user);
		
		//to do: fix association attributes
		
		return user.toHashMap();
		
	}

    public HashMap<String, Object> getUser(Map<String, Object> requestBody){
		List<HashMap<String, Object>> userList = getAllUser("user_impl");
		for (HashMap<String, Object> user : userList){
			int record_id = ((Double) user.get("record_id")).intValue();
			if (record_id == id){
				return user;
			}
		}
		return null;
	}

	public HashMap<String, Object> getUserById(int id){
		String idStr = vmjExchange.getGETParam("userId"); 
		int id = Integer.parseInt(idStr);
		User user = userRepository.getObject(id);
		return user.toHashMap();
	}

    public List<HashMap<String,Object>> getAllUser(Map<String, Object> requestBody){
		String table = (String) requestBody.get("table_name");
		List<User> List = Repository.getAllObject(table);
		return transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<User> List){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < List.size(); i++) {
            resultList.add(List.get(i).toHashMap());
        }

        return resultList;
	}

    public List<HashMap<String,Object>> deleteUser(Map<String, Object> requestBody){
		String idStr = ((String) requestBody.get("id"));
		int id = Integer.parseInt(idStr);
		Repository.deleteObject(id);
		return getAllUser(requestBody);
	}

}
