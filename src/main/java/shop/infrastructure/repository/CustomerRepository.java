package shop.infrastructure.repository;

import org.springframework.data.repository.CrudRepository;
import shop.infrastructure.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
}
