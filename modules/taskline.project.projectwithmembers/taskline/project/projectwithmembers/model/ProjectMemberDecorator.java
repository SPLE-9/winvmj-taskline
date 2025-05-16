package taskline.project.projectwithmembers;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.OneToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.CascadeType;
//add other required packages

import taskline.member.core.*;
import taskline.project.core.*;

@MappedSuperclass
public abstract class ProjectMemberDecorator extends ProjectMemberComponent{
	@OneToOne(cascade=CascadeType.ALL)
	protected ProjectMemberComponent record;
		
	public ProjectMemberDecorator (ProjectMemberComponent record) {
		this.record = record;
	}

	public ProjectMemberDecorator (UUID projectMemberId, ProjectMemberComponent record) {
		this.projectMemberId =  projectMemberId;
		this.record = record;
	}

	public ProjectMemberDecorator() {
		super();
		this.projectMemberId =  UUID.randomUUID();
	}

	public UUID getProjectMemberId() {
		return this.record.projectMemberId;
	}

	public void setProjectMemberId(UUID projectMemberId) {
		this.record.projectMemberId = projectMemberId;
	}

	public Project getProject() {
		return this.record.project;
	}

    public void setProject(Project project) {
		this.record.project = project;
	}

    public Member getMember() {
		return this.record.member;
	}

    public void setMember(Member member) {
		this.record.member = member;
	}


	public HashMap<String, Object> toHashMap() {
        return this.record.toHashMap();
    }

}
