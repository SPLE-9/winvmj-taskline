package taskline.project.core;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import java.util.*;

public interface Project {
	public UUID getProjectId();
	public void setProjectId(UUID projectId);
	public String getTitle();
	public void setTitle(String title);
	public String getDescription();
	public void setDescription(String description);
	public double getCompletion();
	public void setCompletion(double completion);
	HashMap<String, Object> toHashMap();
}
