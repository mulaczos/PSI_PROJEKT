package shop.infrastructure.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.infrastructure.domain.exception.UsernameAlreadyUsedException;
import shop.infrastructure.domain.model.customer.User;
import shop.infrastructure.domain.model.customer.UserAuthority;
import shop.infrastructure.domain.repository.UserAuthorityRepository;
import shop.infrastructure.domain.repository.UserRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserAuthorityService userAuthorityService;

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Transactional
    public User save(User user) {
        if (findByUsername(user.getUsername()) != null) {
            throw new UsernameAlreadyUsedException(user.getUsername());
        } else {
            User userToReturn = userRepository.save(user);
            userAuthorityService.save(UserAuthority.getUserAuthority(userRepository.save(userToReturn)));
            return userToReturn;

        }
    }

    public User update(User user) {
        return userRepository.save(user);
    }

    public void delete(Long id) {
        userRepository.delete(id);
    }
}

@Service
class UserAuthorityService {

    @Autowired
    private UserAuthorityRepository userAuthorityRepository;

    public UserAuthority save(UserAuthority userAuthority) {
        return userAuthorityRepository.save(userAuthority);
    }
}
