package shop.infrastructure.domain.model.customer;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
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
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Customer {

    @Id
    private String username;
    @Length(min = 5)
    private String password;
    @Email
    private String email;
    @NotNull
    private String name;
    @NotNull
    private String lastname;
    private boolean enabled = Boolean.TRUE;

    public static Customer getCopy(Customer customer) {
        Customer copy = new Customer();
        copy.setUsername(customer.getUsername());
        copy.setPassword(customer.getPassword());
        copy.setName(customer.getName());
        copy.setLastname(customer.getLastname());
        copy.setEmail((customer.getEmail()));
        return copy;
    }

}
