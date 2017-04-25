package shop.infrastructure.domain.repository;

import org.springframework.stereotype.Repository;
import shop.infrastructure.domain.model.customer.Customer;
import shop.infrastructure.domain.model.customer.BackendUser;
import shop.infrastructure.domain.repository.base.BaseRepository;

/**
 * Created by Witu on 20.04.2017.
 */
@Repository
public interface BackendUserRepository extends BaseRepository<BackendUser, Long> {
	BackendUser findByBackendUser_Username(Customer username);}
