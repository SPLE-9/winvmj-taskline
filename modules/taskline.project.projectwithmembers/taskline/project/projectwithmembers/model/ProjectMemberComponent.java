package taskline.project.projectwithmembers;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.ManyToOne;

import taskline.member.core.*;
import taskline.project.core.*;

@Entity(name="projectmember_comp")
@Table(name="projectmember_comp")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class ProjectMemberComponent implements ProjectMember{
	@Id
	public UUID projectMemberId;
	@ManyToOne(targetEntity=taskline.project.core.ProjectComponent.class)
	public Project project;
	@ManyToOne(targetEntity=taskline.member.core.MemberComponent.class)
	public Member member;
	protected String objectName = ProjectMemberComponent.class.getName();

	public ProjectMemberComponent() {

	}

	public ProjectMemberComponent(UUID projectMemberId, Project project, Member member) {
		this.projectMemberId = projectMemberId;
		this.project = project;
		this.member = member;
	}

	public UUID getProjectMemberId() {
		return this.projectMemberId;
	}

	public void setProjectMemberId(UUID projectMemberId) {
		this.projectMemberId = projectMemberId;
	}

	public Project getProject() {
		return this.project;
	}

    public void setProject(Project project) {
		this.project = project;
	}

    public Member getMember() {
		return this.member;
	}

    public void setMember(Member member) {
		this.member = member;
	}


	@Override
    public String toString() {
        return "{" +
            " projectMemberId='" + getProjectMemberId() + "'" +
            " projectId='" + getProject().getProjectId() + "'" +
            " memberId='" + getMember().getMemberId() + "'" +
			" name='" + getMember().getName() + "'" +
			" emeil='" + getMember().getEmail() + "'" +
            "}";
    }

	public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> projectMemberMap = new HashMap<String,Object>();
		projectMemberMap.put("projectMemberId", getProjectMemberId());
		projectMemberMap.put("projectId", getProject().getProjectId());
		projectMemberMap.put("memberId", getMember().getMemberId());
		projectMemberMap.put("name", getMember().getName());
		projectMemberMap.put("email", getMember().getEmail());

        return projectMemberMap;
    }
	
}
