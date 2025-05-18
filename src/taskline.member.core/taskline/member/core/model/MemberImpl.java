package taskline.member.core;

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


@Entity(name="member_impl")
@Table(name="member_impl")
public class MemberImpl extends MemberComponent {

	public MemberImpl(UUID memberId, String email, String name) {
		this.memberId = memberId;
		this.email = email;
		this.name = name;
	}

	public MemberImpl(String email, String name) {
		this.memberId =  UUID.randomUUID();
		this.email = email;
		this.name = name;
	}

	public MemberImpl() {
		this.memberId = UUID.randomUUID();
		this.email = "";
		this.name = "";
	}

}
