package shop.infrastructure.domain.model.customer;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import shop.infrastructure.domain.model.Item;
import shop.infrastructure.domain.model.Order;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Primary user class used for application authentication
 * <p>
 * Created by Witu on 07.03.2017.
 */
@Data
@Entity
@Table(name = "Users")
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
    @NotNull
    private boolean enabled = Boolean.TRUE;

    private String address;
    private String city;
    private String zipcode;

    @Getter(onMethod = @__( @JsonIgnore))
    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
    private List<Order> order;

    public Customer() {
    }

    public static Customer getCopy(Customer customer) {
        Customer copy = new Customer();
        copy.setUsername(customer.getUsername());
        copy.setPassword(customer.getPassword());
        copy.setName(customer.getName());
        copy.setLastname(customer.getLastname());
        copy.setEmail((customer.getEmail()));
        return copy;
    }

    public Customer(String username, String password, String email, String name, String lastname, boolean enabled) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.name = name;
        this.lastname = lastname;
        this.enabled = enabled;
    }
}
