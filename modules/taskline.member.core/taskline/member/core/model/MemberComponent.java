package taskline.member.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity(name="member_comp")
@Table(name="member_comp", uniqueConstraints = @UniqueConstraint(columnNames = { "email" }))
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class MemberComponent implements Member{
	@Id
	protected UUID memberId;
	public String email;
	public String name;
	protected String objectName = MemberComponent.class.getName();

	public MemberComponent() { }

	public MemberComponent(UUID memberId, String email, String name) {
        this.memberId = memberId;
        this.email = email;
        this.name = name;
    }

	public UUID getMemberId() {
		return this.memberId;
	}

	public void setMemberId(UUID memberId) {
		this.memberId = memberId;
	}

	public String getEmail() {
		return this.email;
	};

	public void setEmail(String email) {
		this.email = email;
	};
	
	public String getName() {
		return this.name;
	};

	public void setName(String name) {
		this.name = name;
	};
	
 
	@Override
    public String toString() {
        return "{" +
            " memberId='" + getMemberId() + "'" +
            " email='" + getEmail() + "'" +
            " name='" + getName() + "'" +
            "}";
    }

	public HashMap<String, Object> toHashMap() {
		HashMap<String, Object> memberMap = new HashMap<String,Object>();
		memberMap.put("id", getMemberId());
		memberMap.put("email", getEmail());
		memberMap.put("name", getName());
        return memberMap;
	}
	
}
