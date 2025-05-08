package taskline.user.core;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

public abstract class UserResourceDecorator extends UserResourceComponent{
	protected UserResourceComponent record;

    public UserResourceDecorator(UserResourceComponent record) {
        this.record = record;
    }

    public User createUser(VMJExchange vmjExchange){
		return record.createUser(vmjExchange);
	}

    public HashMap<String, Object> updateUser(VMJExchange vmjExchange){
		return record.updateUser(vmjExchange);
	}

    public HashMap<String, Object> getUser(VMJExchange vmjExchange){
		return record.getUser(vmjExchange);
	}

    public List<HashMap<String,Object>> getAllUser(VMJExchange vmjExchange){
		return record.getAllUser(vmjExchange);
	}

    public List<HashMap<String,Object>> deleteUser(VMJExchange vmjExchange){
		return record.deleteUser(vmjExchange);
	}

}
