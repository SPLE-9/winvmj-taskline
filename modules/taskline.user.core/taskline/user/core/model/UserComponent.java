package taskline.user.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="user_comp", uniqueConstraints = @UniqueConstraint(columnNames = { "email" }))
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class UserComponent implements User{
	@Id
	protected UUID userId;
	public String email;
	public String name;
	protected String objectName = UserComponent.class.getName();

	public UserComponent() { }

	public UserComponent(UUID userId, String email, String name) {
        this.userId = userId;
        this.email = email;
        this.name = name;
    }

	public UUID getUserId() {
		return this.userId;
	}

	public void setUserId(UUID userId) {
		this.userId = userId;
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
            " userId='" + getUserId() + "'" +
            " email='" + getEmail() + "'" +
            " name='" + getName() + "'" +
            "}";
    }

	public HashMap<String, Object> toHashMap() {
		HashMap<String, Object> userMap = new HashMap<String,Object>();
		userMap.put("id", getUserId());
		userMap.put("email", getEmail());
		userMap.put("name", getName());
        return userMap;
	}
	
}
