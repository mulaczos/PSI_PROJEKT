package shop.infrastructure.domain.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import shop.infrastructure.domain.model.customer.User;
import shop.infrastructure.domain.service.UserService;

import javax.persistence.EntityNotFoundException;
import java.security.Principal;
import java.util.List;

import static org.springframework.http.MediaType.ALL_VALUE;

@RestController
@RequestMapping("user")
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

//    @PostMapping(consumes = "text/plain;charset=UTF-8")
    @RequestMapping(method = RequestMethod.POST, consumes = ALL_VALUE, produces = ALL_VALUE)
    public User save(User user, @RequestHeader HttpHeaders a) {
        System.out.println(a);
        return userService.save(user);
    }

    @PutMapping
    public User update(User user) {
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

}
