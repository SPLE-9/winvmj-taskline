package taskline.user.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public interface UserService {
	User createUser(Map<String, Object> requestBody);
	User createUser(Map<String, Object> requestBody, Map<String, Object> response);
	HashMap<String, Object> getUser(Map<String, Object> requestBody);
    List<HashMap<String,Object>> saveUser(Map<String, Object> requestBody);
    HashMap<String, Object> updateUser(Map<String, Object> requestBody);
    HashMap<String, Object> getUserById(int id);
    List<HashMap<String,Object>> getAllUser(Map<String, Object> requestBody);
    List<HashMap<String,Object>> deleteUser(Map<String, Object> requestBody);
	List<HashMap<String, Object>> transformListToHashMap(List<Disbursement> List);
}
