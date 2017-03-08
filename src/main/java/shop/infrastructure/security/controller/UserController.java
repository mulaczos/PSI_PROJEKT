package shop.infrastructure.security.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * Created by Witu on 07.03.2017.
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("authentication")
public class UserController {

    @GetMapping
    public Principal credentials(Principal principal) {
        return principal;
    }


}
