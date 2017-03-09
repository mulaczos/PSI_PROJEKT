package shop.infrastructure.domain.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import shop.infrastructure.domain.model.Order;

/**
 * Created by Witu on 09.03.2017.
 */
@Repository
public interface OrderRepository extends CrudRepository<Order,Long> {
}
