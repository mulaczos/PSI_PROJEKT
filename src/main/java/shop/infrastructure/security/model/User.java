package shop.infrastructure.security.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
    private boolean enabled = Boolean.TRUE;

}
