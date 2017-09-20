package shop.infrastructure.domain.repository;

import org.springframework.stereotype.Repository;
import shop.infrastructure.domain.model.customer.Customer;
import shop.infrastructure.domain.repository.base.BaseRepository;

@Repository
public interface CustomerRepository extends BaseRepository<Customer, String> {
    Customer findByUsername(String username);
}
