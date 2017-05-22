package shop.infrastructure.domain.model.customer;

import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;


public class CustomerDto {

    @NotNull
    private String username;
    @Min(5)
    private String confirmwithpassword;
    @Min(5)
    private String newpassword;
    @Email
    private String email;
    @NotNull
    private String name;
    @NotNull
    private String lastname;
    private boolean enabled = Boolean.TRUE;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getConfirmwithpassword() {
        return confirmwithpassword;
    }

    public void setConfirmwithpassword(String confirmwithpassword) {
        this.confirmwithpassword = confirmwithpassword;
    }

    public String getNewpassword() {
        return newpassword;
    }

    public void setNewpassword(String newpassword) {
        this.newpassword = newpassword;
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
}
