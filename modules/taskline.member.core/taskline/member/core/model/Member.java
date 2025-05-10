package taskline.member.core;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import java.util.*;

public interface Member {
	public UUID getMemberId();
	public void setMemberId(UUID memberId);
	public String getEmail();
	public void setEmail(String email);
	public String getName();
	public void setName(String name);
	HashMap<String, Object> toHashMap();
}
