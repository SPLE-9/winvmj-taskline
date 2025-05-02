package taskline.user.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public abstract class UserServiceDecorator extends UserServiceComponent{
	protected UserServiceComponent record;

    public UserServiceDecorator(UserServiceComponent record) {
        this.record = record;
    }

	public User getUserByEmail(String email) {
		return record.getUserByEmail(email);
	}

}
