package shop.infrastructure.domain.repository.base;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;
import java.util.List;

@NoRepositoryBean
public interface BaseRepository<ENTITY, ID extends Serializable> extends CrudRepository<ENTITY, ID> {
	
	List<ENTITY> findAll();
	
}
