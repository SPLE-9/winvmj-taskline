package taskline..projectwithmembers;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.OneToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.CascadeType;
//add other required packages

@MappedSuperclass
public abstract class ProjectMemberDecorator extends ProjectMemberComponent{
	protected ProjectMemberComponent record;
		
	public ProjectMemberDecorator (ProjectMemberComponent record) {
		this.record = record;
	}


	public void getProjectsByMember(UUID memberId) {
		return record.getProjectsByMember(memberId);
	}

	public void getProjectMembers(UUID projectId) {
		return record.getProjectMembers(projectId);
	}

}
