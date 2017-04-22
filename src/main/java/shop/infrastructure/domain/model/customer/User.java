package shop.infrastructure.domain.model.customer;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Primary user class used for application authentication
 * <p>
 * Created by Witu on 07.03.2017.
 */
@Data
@Entity
@Table(name = "Users")
public class User {
	
	@Id
	private String username;
	private String password;
	private String email;
	private String name;
	private String lastname;
	private boolean enabled = Boolean.TRUE;
	
	public static User getCopy(User user) {
		User copy = new User();
		copy.setUsername(user.getUsername());
		copy.setPassword(user.getPassword());
		copy.setName(user.getName());
		copy.setLastname(user.getLastname());
		copy.setEmail((user.getEmail()));
		return copy;
	}
	
}
