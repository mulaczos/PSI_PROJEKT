package shop.infrastructure.domain.model.customer;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Witu on 07.03.2017.
 */
@Data
@Embeddable
@NoArgsConstructor
public class UserAuthorityPrimaryKey implements Serializable {

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "username")
    private User username;

    @Enumerated(EnumType.STRING)
    private Role authority;

    public UserAuthorityPrimaryKey(User username, Role authority) {
        this.username = username;
        this.authority = authority;
    }

}