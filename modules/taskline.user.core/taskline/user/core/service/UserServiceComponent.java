package taskline.user.core;
import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;
//add other required packages

public abstract class UserServiceComponent implements UserService{
	protected RepositoryUtil<User> userRepository;

    public UserServiceComponent(){
        this.userRepository = new RepositoryUtil<User>(taskline.user.core.UserComponent.class);
    }	

    public abstract User getUserByEmail(String email);

}
