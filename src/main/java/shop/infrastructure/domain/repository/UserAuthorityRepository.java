package shop.infrastructure.domain.repository;

import org.springframework.stereotype.Repository;
import shop.infrastructure.domain.model.customer.UserAuthority;
import shop.infrastructure.domain.repository.base.BaseRepository;

/**
 * Created by Witu on 20.04.2017.
 */
@Repository
public interface UserAuthorityRepository extends BaseRepository<UserAuthority, Long> {
}
