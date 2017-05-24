package shop.infrastructure.domain.repository;

import org.springframework.stereotype.Repository;
import shop.infrastructure.domain.model.customer.BackendUserPK;
import shop.infrastructure.domain.model.customer.Customer;
import shop.infrastructure.domain.model.customer.BackendUser;
import shop.infrastructure.domain.repository.base.BaseRepository;

@Repository
public interface BackendUserRepository extends BaseRepository<BackendUser, BackendUserPK> {
    BackendUser findByBackendUser_Username(Customer username);
    void deleteByBackendUserUsername(Customer username);
}
