package taskline.user.core;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import java.util.*;

public interface User {
	public UUID getUserId();
	public void setUserId(UUID userId);
	public String getEmail();
	public void setEmail(String email);
	public String getName();
	public void setName(String name);
	HashMap<String, Object> toHashMap();
}
