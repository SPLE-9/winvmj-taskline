package taskline.user.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public interface UserService {
	User getUserByEmail(String email);
}
