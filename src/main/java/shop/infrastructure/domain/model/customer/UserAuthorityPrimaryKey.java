package shop.infrastructure.domain.model.customer;

import lombok.Data;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.io.Serializable;

/**
 * Created by Witu on 07.03.2017.
 */
@Data
@Embeddable
public class UserAuthorityPrimaryKey implements Serializable {
    private String username;

    @Enumerated(EnumType.STRING)
    private Role authority;
}