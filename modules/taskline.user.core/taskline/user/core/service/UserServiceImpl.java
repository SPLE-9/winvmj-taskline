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
//add other required packages

public class UserServiceImpl extends UserServiceComponent{

    public User getUserByEmail(String email) {
		try {
			List<User> users = userRepository.getListObject("user_comp", "email", email);
			
			if (users == null || users.isEmpty()) {
				throw new NotFoundException("User with email " + email + " does not exist.");
			}

			return users.get(0);
		} catch (NotFoundException e) {
			throw e;
		} catch (Exception e) {
			throw new RuntimeException("Failed to retrieve user due to system error.", e);
		}
	}

}
