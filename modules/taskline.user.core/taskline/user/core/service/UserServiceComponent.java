package taskline.user.core;
import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;
//add other required packages

public abstract class UserServiceComponent implements UserService{
	protected RepositoryUtil<User> Repository;

    public UserServiceComponent(){
        this.Repository = new RepositoryUtil<User>(taskline.user.core.UserComponent.class);
    }	

    public abstract List<HashMap<String,Object>> saveUser(VMJExchange vmjExchange);
    public abstract User createUser(Map<String, Object> requestBodye);
	public abstract User createUser(Map<String, Object> requestBody, Map<String, Object> response);    
	public abstract HashMap<String, Object> updateUser(Map<String, Object> requestBody);
    public abstract HashMap<String, Object> getUser(Map<String, Object> requestBody);
    public abstract List<HashMap<String,Object>> getAllUser(Map<String, Object> requestBody);
    public abstract List<HashMap<String,Object>> transformListToHashMap(List<User> List);
    public abstract List<HashMap<String,Object>> deleteUser(Map<String, Object> requestBody);
	public abstract HashMap<String, Object> getUserById(int id);

}
