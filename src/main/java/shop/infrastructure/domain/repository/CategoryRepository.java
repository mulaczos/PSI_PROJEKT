package shop.infrastructure.domain.repository;

import org.springframework.stereotype.Repository;
import shop.infrastructure.domain.model.Category;
import shop.infrastructure.domain.repository.base.BaseRepository;

/**
 * Created by Witu on 26.04.2017.
 */
@Repository
public interface CategoryRepository extends BaseRepository<Category, Long> {
}
