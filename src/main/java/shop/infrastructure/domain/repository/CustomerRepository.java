package shop.infrastructure.domain.repository;

import org.springframework.data.repository.CrudRepository;
import shop.infrastructure.domain.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
}
