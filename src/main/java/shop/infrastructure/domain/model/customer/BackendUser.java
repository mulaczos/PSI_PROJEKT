package shop.infrastructure.domain.model.customer;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Witu on 07.03.2017.
 */
@Data
@Entity
@Table(name = "Authorities")
@NoArgsConstructor
public class BackendUser {

    @EmbeddedId
    private BackendUserPK backendUser;

    private BackendUser(Customer customer, Role role) {
        this.backendUser = new BackendUserPK(customer, role);
    }

    public static BackendUser getUserAuthority(Customer customer) {
        return new BackendUser(customer, Role.USER);
    }

    public static BackendUser getModeratorAuthority(Customer customer) {
        return new BackendUser(customer, Role.MODERATOR);
    }

    public static BackendUser getAdminAuthority(Customer customer) {
        return new BackendUser(customer, Role.ADMIN);
    }

    @JsonIgnore
    public boolean isUser() {
        return this.getBackendUser().getAuthority().equals(Role.USER);
    }

    @JsonIgnore
    public boolean isMod() {
        return this.getBackendUser().getAuthority().equals(Role.MODERATOR);
    }

    @JsonIgnore
    public boolean isAdmin() {
        return this.getBackendUser().getAuthority().equals(Role.ADMIN);
    }

    @JsonIgnore
    public Customer getCustomer() {
        return this.backendUser.getUsername();
    }

    @JsonIgnore
    public Role getRole() {
        return this.backendUser.getAuthority();
    }

    public static BackendUser getUserAuthorityByRole(Customer customerToSave, Role role) {
        return new BackendUser(customerToSave, role);
    }

    public static BackendUser getWithAuthority(Customer customer, Role role) {
        return new BackendUser(customer, role);
    }
}