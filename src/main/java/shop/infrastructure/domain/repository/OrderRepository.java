package shop.infrastructure.domain.repository;

import org.springframework.stereotype.Repository;
import shop.infrastructure.domain.model.Order;
import shop.infrastructure.domain.repository.base.BaseRepository;

@Repository
public interface OrderRepository extends BaseRepository<Order, Long> {
}
