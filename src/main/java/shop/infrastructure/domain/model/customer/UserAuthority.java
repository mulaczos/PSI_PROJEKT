package shop.infrastructure.domain.model.customer;

import lombok.Data;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/** *
 * Created by Witu on 07.03.2017.
 */
@Data
@Entity
@Table(name="Authorities")
public class UserAuthority {

    @EmbeddedId
    private UserAuthorityPrimaryKey authority;
}
