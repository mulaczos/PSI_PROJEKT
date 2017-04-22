package shop.infrastructure.domain.model.customer;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by Witu on 07.03.2017.
 */
@Data
@Entity
@Table(name = "Authorities")
@NoArgsConstructor
public class UserAuthority {
	
	@EmbeddedId
	private UserAuthorityPrimaryKey authority;
	
	private UserAuthority(User user, Role role) {
		this.authority = new UserAuthorityPrimaryKey(user, role);
	}
	
	public static UserAuthority getUserAuthority(User user) {
		return new UserAuthority(user, Role.ROLE_USER);
	}
	
	public static UserAuthority getModeratorAuthority(User user) {
		return new UserAuthority(user, Role.ROLE_MODERATOR);
	}
	
	public static UserAuthority getAdminAuthority(User user) {
		return new UserAuthority(user, Role.ROLE_ADMIN);
		
	}
	
	public boolean isUserAuthority() {
		return this.getAuthority().getAuthority().equals(Role.ROLE_USER);
	}
	
	public boolean isModeratorAuthority() {
		return this.getAuthority().getAuthority().equals(Role.ROLE_MODERATOR);
	}
	
	public boolean isAdminAuthority() {
		return this.getAuthority().getAuthority().equals(Role.ROLE_ADMIN);
	}
}

@Data
@Embeddable
@NoArgsConstructor
class UserAuthorityPrimaryKey implements Serializable {
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "username")
	private User username;
	
	@Enumerated(EnumType.STRING)
	private Role authority;
	
	UserAuthorityPrimaryKey(User username, Role authority) {
		this.username = username;
		this.authority = authority;
	}
	
}