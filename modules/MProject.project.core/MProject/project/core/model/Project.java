package MProject.project.core;
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
	public EDouble getCompletion();
	public void setCompletion(EDouble completion);
	org.eclipse.uml2.uml.internal.impl.ClassImpl@35aefe48 (name: ProjectImpl, visibility: <unset>) (isLeaf: false, isAbstract: false, isFinalSpecialization: false) (isActive: false)
	HashMap<String, Object> toHashMap();
}
