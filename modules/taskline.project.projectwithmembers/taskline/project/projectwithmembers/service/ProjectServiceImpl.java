package taskline.project.projectwithmembers;

import java.util.*;

import vmj.routing.route.VMJExchange;

import taskline.project.core.ProjectServiceDecorator;
import taskline.project.core.ProjectImpl;
import taskline.project.core.ProjectServiceComponent;

public class ProjectServiceImpl extends ProjectServiceDecorator {
    public ProjectServiceImpl (ProjectServiceComponent record) {
        super(record);
    }

    
	public void getProjectsByMember(UUID memberId) {
		// TODO: implement this method
	}

	public void getProjectMembers(UUID projectId) {
		// TODO: implement this method
	}
}
