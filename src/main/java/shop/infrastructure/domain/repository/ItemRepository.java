package shop.infrastructure.domain.repository;

import java.util.List;
import org.springframework.stereotype.Repository;
import shop.infrastructure.domain.model.Category;
import shop.infrastructure.domain.model.Item;
import shop.infrastructure.domain.repository.base.BaseRepository;

@Repository
public interface ItemRepository extends BaseRepository<Item, Long> {
    List<Item> findAllByCategory(Category category);
}
