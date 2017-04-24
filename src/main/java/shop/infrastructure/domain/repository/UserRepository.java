package shop.infrastructure.domain.repository;

import org.springframework.stereotype.Repository;
import shop.infrastructure.domain.model.customer.User;
import shop.infrastructure.domain.repository.base.BaseRepository;

@Repository
public interface UserRepository extends BaseRepository <User, String> {
    User findByUsername(String username);
}
