package shop.infrastructure.domain.repository;

import org.springframework.stereotype.Repository;
import shop.infrastructure.domain.model.Customer;
import shop.infrastructure.domain.repository.base.BaseRepository;

@Repository
public interface CustomerRepository extends BaseRepository<Customer, Long> {
}
