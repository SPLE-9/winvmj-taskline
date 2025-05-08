package taskline.user.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public abstract class UserServiceDecorator extends UserServiceComponent{
	protected UserServiceComponent record;

    public UserServiceDecorator(UserServiceComponent record) {
        this.record = record;
    }

	public UserImpl createUser(Map<String, Object> requestBody){
		return record.createUser(requestBody);
	}

    public User createUser(Map<String, Object> requestBody, Map<String, Object> response){
		return record.createUser(requestBody, response);
	}

	public HashMap<String, Object> getUser(Map<String, Object> requestBody){
		return record.getUser(requestBody);
	}

	public List<HashMap<String,Object>> getAllUser(Map<String, Object> requestBody){
		return record.getAllUser(requestBody);
	}

    public List<HashMap<String,Object>> saveUser(VMJExchange vmjExchange){
		return record.saveUser(vmjExchange);
	}

    public HashMap<String, Object> updateUser(Map<String, Object> requestBody){
		return record.updateUser(requestBody);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<User> List){
		return record.transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> deleteUser(Map<String, Object> requestBody){
		return record.deleteUser(requestBody);
	}

	public HashMap<String, Object> getUserById(int id){
        return record.getUserById(id);
    }

}
