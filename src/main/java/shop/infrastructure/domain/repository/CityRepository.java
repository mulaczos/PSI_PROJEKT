package shop.infrastructure.domain.repository;

import org.springframework.stereotype.Repository;
import shop.infrastructure.domain.model.City;
import shop.infrastructure.domain.repository.base.BaseRepository;

@Repository
public interface CityRepository extends BaseRepository<City, Long>{
}
