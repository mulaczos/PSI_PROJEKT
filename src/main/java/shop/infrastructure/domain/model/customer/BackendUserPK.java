package shop.infrastructure.domain.model.customer;

import java.io.Serializable;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Embeddable
public class BackendUserPK implements Serializable {

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "username")
    private Customer username;

    @Enumerated(EnumType.STRING)
    private Role authority;

    BackendUserPK(Customer username, Role authority) {
        this.username = username;
        this.authority = authority;
    }

    public BackendUserPK() {
    }

    public Customer getUsername() {
        return username;
    }

    public void setUsername(Customer username) {
        this.username = username;
    }

    public Role getAuthority() {
        return authority;
    }

    public void setAuthority(Role authority) {
        this.authority = authority;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BackendUserPK that = (BackendUserPK) o;

        if (!username.equals(that.username)) return false;
        return authority == that.authority;
    }

    @Override
    public int hashCode() {
        int result = username.hashCode();
        result = 31 * result + (authority != null ? authority.hashCode() : 0);
        return result;
    }
}
