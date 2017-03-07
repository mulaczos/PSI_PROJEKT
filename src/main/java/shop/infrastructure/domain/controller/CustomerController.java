package shop.infrastructure.domain.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import shop.infrastructure.domain.model.Customer;
import shop.infrastructure.domain.service.CustomerService;

/**
 * Created by Witu on 04.03.2017.
 */
@RestController
@RequestMapping("customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping(method= RequestMethod.POST)
    public Customer save(Customer customer) {
        return customerService.save(customer);
    }
}
