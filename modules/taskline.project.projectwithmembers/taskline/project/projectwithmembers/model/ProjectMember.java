package taskline.project.projectwithmembers;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import java.util.*;

import taskline.member.core.*;
import taskline.project.core.*;

public interface ProjectMember {
    public UUID getProjectMemberId();
	public void setProjectMemberId(UUID projectMemberId);
    public Project getProject();
    public void setProject(Project project);
    public Member getMember();
    public void setMember(Member member);
    HashMap<String, Object> toHashMap();
}
