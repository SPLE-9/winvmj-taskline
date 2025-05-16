package taskline.project.projectwithmembers;

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

import taskline.member.core.*;
import taskline.project.core.*;


@Entity(name="projectmember_impl")
@Table(name="projectmember_impl")
public class ProjectMemberImpl extends ProjectMemberComponent {

	public ProjectMemberImpl(UUID projectMemberId, Project project, Member member) {
		this.projectMemberId = projectMemberId;
		this.project = project;
		this.member = member;
	}

	public ProjectMemberImpl(Project project, Member member) {
		this.projectMemberId = UUID.randomUUID();
		this.project = project;
		this.member = member;
	}

	public ProjectMemberImpl() {
		this.projectMemberId = UUID.randomUUID();
		this.project = null;
		this.member = null;
	}

}
