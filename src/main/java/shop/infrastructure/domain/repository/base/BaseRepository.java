package shop.infrastructure.domain.repository.base;

import java.io.Serializable;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseRepository<ENTITY, ID extends Serializable> extends CrudRepository<ENTITY, ID> {
    List<ENTITY> findAll();
}
