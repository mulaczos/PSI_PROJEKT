package shop.infrastructure.domain.model.customer;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Primary user class used for application authentication
 *
 * Created by Witu on 07.03.2017.
 */
@Data
@Entity
@Table(name="Users")
public class User {

    @Id
    private String username;
    private String password;
    private String email;
    private String name;
    private boolean enabled = Boolean.TRUE;
    @Transient
    private Role role;

}
