package shop.infrastructure.domain.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import shop.infrastructure.domain.model.Item;

/**
 * Created by Witu on 09.03.2017.
 */
@Repository
public interface ItemRepository extends CrudRepository<Item, Long> {
}
