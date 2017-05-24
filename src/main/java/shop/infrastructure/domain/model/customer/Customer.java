package shop.infrastructure.domain.model.customer;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import shop.infrastructure.domain.model.Order;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "Users")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Customer {

    @Id
    private String username;
    @Length(min = 3)
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

    public Customer(String username, String password, String email, String name, String lastname, boolean enabled, String address, String city, String zipcode) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.name = name;
        this.lastname = lastname;
        this.enabled = enabled;
        this.address = address;
        this.city = city;
        this.zipcode = zipcode;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    @JsonIgnore
    public List<Order> getOrder() {
        return order;
    }

    public void setOrder(List<Order> order) {
        this.order = order;
    }
}
