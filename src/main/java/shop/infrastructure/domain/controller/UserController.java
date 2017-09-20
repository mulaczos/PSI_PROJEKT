package shop.infrastructure.domain.controller;

import java.security.Principal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import shop.infrastructure.domain.model.customer.BackendUser;
import shop.infrastructure.domain.model.customer.Customer;
import shop.infrastructure.domain.model.customer.CustomerDto;
import shop.infrastructure.domain.model.customer.Role;
import shop.infrastructure.domain.service.UserService;

@RestController
@RequestMapping(value = "user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("{username}")
    public Customer get(@PathVariable String username) {
        return userService.findByUsername(username);
    }

    @GetMapping()
    public List<BackendUser> getAllUserAuthorities() {
        return userService.getAllBackendUsers();
    }

    @PostMapping
    public Customer save(@RequestBody Customer customer) {
        return userService.save(customer);
    }

    @PutMapping
    public Customer updateUser(@RequestBody CustomerDto customerDto) {
        return userService.updateUser(customerDto);
    }

    @GetMapping(value = "credentials")
    public Principal credentials(Principal principal) {
        return principal;
    }

    @GetMapping(value = "profile")
    public Customer profile(Principal principal) {
        Customer customer = get(principal.getName());
        customer.setPassword(null);
        return customer;
    }

    @PostMapping("assignmoderator")
    public boolean assignModerator(@RequestBody String username) {
        return userService.assignModerator(username);
    }

    @PostMapping("degradetouser")
    public boolean degradeToUser(@RequestBody String username) {
        return userService.degradeToUser(username);
    }

    @PostMapping("grantadmin")
    public boolean grantAdmin(@RequestBody String username) {
        return userService.grantAdmin(username);
    }

    @PostMapping("toggledisable")
    public boolean toggleDisable(@RequestBody String username) {
        return userService.toggleDisable(username);
    }

    @GetMapping(value = "role")
    public Role role(Principal principal) {
        return userService.getRole(principal.getName());
    }

    @DeleteMapping("{username}")
    public void delete(@PathVariable String username) {
        userService.delete(username);
    }

}
