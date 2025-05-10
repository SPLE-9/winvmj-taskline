package taskline.member.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.OneToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.CascadeType;
//add other required packages

@MappedSuperclass
public abstract class MemberDecorator extends MemberComponent{
	@OneToOne(cascade=CascadeType.ALL)
    protected MemberComponent record;

	public MemberDecorator (MemberComponent record) {
		this.record = record;
	}

	public MemberDecorator (UUID memberId, MemberComponent record) {
		this.memberId =  memberId;
		this.record = record;
	}

	public MemberDecorator() {
		super();
		this.memberId = UUID.randomUUID();
	}

	public UUID getMemberId() {
		return this.record.getMemberId();
	}

	public void setMemberId(UUID memberId) {
		this.record.setMemberId(memberId);
	}

	public String getEmail() {
        return this.record.getEmail();
    }

    public void setEmail(String email) {
        this.record.setEmail(email);
    }

	public String getName() {
        return this.record.getName();
    }

    public void setName(String name) {
        this.record.setName(name);
    }

	public HashMap<String, Object> toHashMap() {
        return this.record.toHashMap();
    }

}
