package taskline.user.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="user_comp")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class UserComponent implements User{
	@Id
	protected UUID userId; 
	protected UUID userId;
	public String email;
	public String name;
	protected String objectName = UserComponent.class.getName();

	public UserComponent() {

	} 

	public UserComponent(
        UUID userId, String email, String name
    ) {
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
	public abstract String getEmail();
	public abstract void setEmail(String email);
	
	public abstract String getName();
	public abstract void setName(String name);
	
 

	@Override
    public String toString() {
        return "{" +
            " userId='" + getUserId() + "'" +
            " email='" + getEmail() + "'" +
            " name='" + getName() + "'" +
            "}";
    }
	
}
