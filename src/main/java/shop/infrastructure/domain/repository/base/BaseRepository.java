package shop.infrastructure.domain.repository.base;

import org.springframework.data.repository.CrudRepository;

import java.io.Serializable;
import java.util.List;

public interface BaseRepository<ENTITY, ID extends Serializable> extends CrudRepository<ENTITY, ID> {
	List<ENTITY> findAll();
}
