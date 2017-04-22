package shop.infrastructure.domain.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import shop.infrastructure.domain.model.customer.User;
import shop.infrastructure.domain.service.UserService;

import javax.persistence.EntityNotFoundException;
import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping(value = "user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping(params = "username")
	public User get(String username) {
		return userService.findByUsername(username);
	}
	
	@GetMapping
	public List<User> getAllUsers() {
		return userService.getAll();
	}
	
	@PostMapping
	public User save(@RequestBody User user) {
		return userService.save(user);
	}
	
	@PutMapping
	public User update(@RequestBody User user) {
		if (userService.findByUsername(user.getUsername()) != null) {
			return userService.update(user);
		} else {
			throw new EntityNotFoundException();
		}
	}
	
	@DeleteMapping
	public void delete(Long id) {
		userService.delete(id);
	}
	
	@GetMapping(value = "credentials")
	public Principal credentials(Principal principal) {
		return principal;
	}
	
	@PostMapping("grantmoderator")
	public boolean grantModerator(@RequestBody String username) {
		return userService.grantToModerator(username);
	}
	
	@PostMapping("degradetouser")
	public boolean degradeToUser(@RequestBody String username) {
		return userService.degradeToUser(username);
	}
	@PostMapping("grantadmin")
	public boolean grantAdmin(@RequestBody String username) {
		return userService.grantAdmin(username);
	}
	@PostMapping("degradetomoderator")
	public boolean degradeToModerator(@RequestBody String username) {
		return userService.degradeToModerator(username);
	}
	
	
}
