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
        return new UserAuthority(user, Role.ROLE_USER);
    }

    public static UserAuthority getModeratorAuthority(User user) {
        return new UserAuthority(user, Role.ROLE_MODERATOR);
    }

    public static UserAuthority getAdminAuthority(User user) {
        return new UserAuthority(user, Role.ROLE_ADMIN);

    }


}
