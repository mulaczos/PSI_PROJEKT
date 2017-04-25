package shop.infrastructure.domain.model.customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * Primary user class used for application authentication
 * <p>
 * Created by Witu on 07.03.2017.
 */
@Data
@Entity
@Table(name = "Users")
@AllArgsConstructor
@NoArgsConstructor
public class User {
	
	@Id
	private String username;
	@Length(min=5)
	private String password;
	@Email
	private String email;
	@NotNull
	private String name;
	@NotNull
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
