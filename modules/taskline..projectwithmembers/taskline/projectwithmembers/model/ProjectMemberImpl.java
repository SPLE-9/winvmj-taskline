package taskline..projectwithmembers;

import java.lang.Math;
import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity(name="projectmember_impl")
@Table(name="projectmember_impl")
public class ProjectMemberImpl extends ProjectMemberComponent {

	public ProjectMemberImpl(UUID projectMemberId, ProjectImpl projectimpl, MemberImpl memberimpl) {
		this.projectMemberId = projectMemberId;
		this.projectimpl = projectimpl;
		this.memberimpl = memberimpl;
	}

	public void getProjectsByMember(UUID memberId) {
		// TODO: implement this method
	}

	public void getProjectMembers(UUID projectId) {
		// TODO: implement this method
	}

}
