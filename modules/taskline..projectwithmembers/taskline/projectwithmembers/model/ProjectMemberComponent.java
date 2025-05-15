package taskline..projectwithmembers;;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="projectmember_comp")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class ProjectMemberComponent implements ProjectMember{
	
	@Id
	public UUID projectMemberId; 
	public UUID projectMemberId;
	public ProjectImpl projectimpl;
	public MemberImpl memberimpl;

	public ProjectMemberComponent() {

	} 
 
	public abstract void getProjectsByMember(UUID memberId);

	public abstract void getProjectMembers(UUID projectId);
}
