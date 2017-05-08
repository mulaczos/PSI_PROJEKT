package shop.infrastructure.domain.repository;

import org.springframework.stereotype.Repository;
import shop.infrastructure.domain.model.Order;
import shop.infrastructure.domain.repository.base.BaseRepository;

import java.util.List;

@Repository
public interface OrderRepository extends BaseRepository<Order, Long> {
    List<Order> findAllByCustomer_Username(String customer);
}
