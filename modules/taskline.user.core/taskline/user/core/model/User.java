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
	org.eclipse.uml2.uml.internal.impl.ClassImpl@53abf5d7 (name: UserImpl, visibility: package) (isLeaf: false, isAbstract: false, isFinalSpecialization: false) (isActive: false)
	HashMap<String, Object> toHashMap();
}
