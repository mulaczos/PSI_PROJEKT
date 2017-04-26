package shop.infrastructure.domain.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import shop.infrastructure.domain.model.customer.BackendUser;
import shop.infrastructure.domain.model.customer.Customer;
import shop.infrastructure.domain.model.customer.CustomerDto;
import shop.infrastructure.domain.service.UserService;

import java.security.Principal;
import java.util.List;

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

    @DeleteMapping
    public void delete(String username) {
        userService.delete(username);
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

}
