package shop.infrastructure.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shop.infrastructure.domain.exception.UsernameAlreadyUsedException;
import shop.infrastructure.domain.model.customer.User;
import shop.infrastructure.domain.model.customer.UserAuthority;
import shop.infrastructure.domain.repository.UserAuthorityRepository;
import shop.infrastructure.domain.repository.UserRepository;

import java.util.List;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserAuthorityService userAuthorityService;
	
	@Transactional
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
	
	@Transactional
	public boolean grantToModerator(String username) {
		User toDelete = findByUsername(username);
		User toSave = User.getCopy(toDelete);
		if (userAuthorityService.hasUserRole(toDelete)) {
			userAuthorityService.delete(UserAuthority.getUserAuthority(toDelete));
			userAuthorityService.save(UserAuthority.getModeratorAuthority(toSave));
			return true;
		}
		return false;
	}
	
	@Transactional
	public boolean degradeToUser(String username) {
		User toDelete = findByUsername(username);
		User toSave = User.getCopy(toDelete);
		if (userAuthorityService.hasModeratorRole(toDelete)) {
			userAuthorityService.delete(UserAuthority.getModeratorAuthority(toDelete));
			userAuthorityService.save(UserAuthority.getUserAuthority(toSave));
			return true;
		}
		return false;
	}
	
	public boolean grantAdmin(String username) {
		User toDelete = findByUsername(username);
		User toSave = User.getCopy(toDelete);
		if (userAuthorityService.hasModeratorRole(toDelete)) {
			userAuthorityService.delete(UserAuthority.getModeratorAuthority(toDelete));
			userAuthorityService.save(UserAuthority.getAdminAuthority(toSave));
			return true;
		}
		return false;
	}
	
	public boolean degradeToModerator(String username) {
		User toDelete = findByUsername(username);
		User toSave = User.getCopy(toDelete);
		if (userAuthorityService.hasAdminRole(toDelete)) {
			userAuthorityService.delete(UserAuthority.getAdminAuthority(toDelete));
			userAuthorityService.save(UserAuthority.getModeratorAuthority(toSave));
			return true;
		}
		return false;
	}

//	@Transactional
//	public boolean grantToModerator(User user) {
//		if (userAuthorityService.hasUserRole(user)) {
//			userAuthorityService.delete(UserAuthority.getUserAuthority(user));
//			userAuthorityService.save(UserAuthority.getModeratorAuthority(user));
//			return true;
//		}
//		return false;
//	}
	
	
	@Transactional
	public User update(User user) {
		return userRepository.save(user);
	}
	
	@Transactional
	public void delete(Long id) {
		userRepository.delete(id);
	}
	
}

@Service
class UserAuthorityService {
	
	@Autowired
	private UserAuthorityRepository userAuthorityRepository;
	
	@Transactional
	UserAuthority save(UserAuthority userAuthority) {
		return userAuthorityRepository.save(userAuthority);
	}
	
	@Transactional
	boolean hasUserRole(User user) {
		return userAuthorityRepository.findByAuthorityUsername(user).isUserAuthority();
	}
	
	@Transactional(readOnly = true)
	boolean hasModeratorRole(User user) {
		return userAuthorityRepository.findByAuthorityUsername(user).isModeratorAuthority();
	}
	
	@Transactional
	void delete(UserAuthority userAuthority) {
		userAuthorityRepository.delete(userAuthority);
	}
	
	@Transactional(readOnly = true)
	boolean hasAdminRole(User user) {
		return userAuthorityRepository.findByAuthorityUsername(user).isAdminAuthority();
	}
}
