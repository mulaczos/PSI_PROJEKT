package shop.infrastructure.domain.model.customer;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

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
        return new UserAuthority(user, Role.USER);
    }

    public static UserAuthority getModeratorAuthority(User user) {
        return new UserAuthority(user, Role.MODERATOR);
    }

    public static UserAuthority getAdminAuthority(User user) {
        return new UserAuthority(user, Role.ADMIN);
    }

    public boolean isUserAuthority() {
        return this.getAuthority().getAuthority().equals(Role.USER);
    }

    public boolean isModeratorAuthority() {
        return this.getAuthority().getAuthority().equals(Role.MODERATOR);
    }

    public boolean isAdminAuthority() {
        return this.getAuthority().getAuthority().equals(Role.ADMIN);
    }

    public User getUser() {
        return this.authority.getUsername();
    }

    public Role getRole() {
        return this.authority.getAuthority();
    }

    public static UserAuthority getUserAuthorityByRole(User userToSave, Role role) {
        return new UserAuthority(userToSave, role);
    }
}