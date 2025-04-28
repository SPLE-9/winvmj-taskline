package taskline.user.core;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import vmj.routing.route.exceptions.*;
import taskline.user.UserFactory;
import prices.auth.vmj.annotations.Restricted;
//add other required packages


public class UserResourceImpl extends UserResourceComponent{
	
	private UserServiceImpl userServiceImpl = new UserServiceImpl();

	// @Restriced(permission = "")
    @Route(url="call/user/save")
    public List<HashMap<String,Object>> saveUser(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		User user = createUser(vmjExchange);
		userRepository.saveObject(user);
		return getAllUser(vmjExchange);
	}

	// @Restriced(permission = "")
    @Route(url="call/user")
    public HashMap<String,Object> user(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			User result = userServiceImpl.createUser(requestBody);
			return result.toHashMap();
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

    public User createUser(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			User result = userServiceImpl.createUser(requestBody);
			return result.toHashMap();
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

    public User createUser(VMJExchange vmjExchange, int id){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			User result = userServiceImpl.createUser(requestBody, id);
			return result.toHashMap();
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

	// @Restriced(permission = "")
    @Route(url="call/user/update")
    public HashMap<String, Object> updateUser(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")){
			return null;
		}
		return userServiceImpl.updateUser(requestBody);
		
	}

	// @Restriced(permission = "")
    @Route(url="call/user/detail")
    public HashMap<String, Object> getUser(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		return userServiceImpl.getUser(requestBody);
	}

	// @Restriced(permission = "")
    @Route(url="call/user/list")
    public List<HashMap<String,Object>> getAllUser(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		return userServiceImpl.getAllUser(requestBody);
	}

	// @Restriced(permission = "")
    @Route(url="call/user/delete")
    public List<HashMap<String,Object>> deleteUser(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		return userServiceImpl.deleteUser(requestBody);
	}


}
