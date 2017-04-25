package shop.infrastructure.domain.model.customer;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Embeddable
@NoArgsConstructor
public class UserAuthorityPrimaryKey implements Serializable {

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
