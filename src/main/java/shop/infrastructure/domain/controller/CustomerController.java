package shop.infrastructure.domain.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import shop.infrastructure.domain.model.Customer;
import shop.infrastructure.domain.service.CustomerService;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequestMapping("customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping(params = "id")
	public Customer get(Long id) {
		return customerService.get(id);
	}
	
	@GetMapping
	public List<Customer> getAllCustomers() {
		return customerService.getAll();
	}
	
	@PostMapping
	public Customer save(Customer customer) {
		return customerService.save(customer);
	}
	
	@PutMapping
	public Customer update(Customer customer) {
		if (customerService.get(customer.getId()) != null) {
			return customerService.update(customer);
		} else {
			throw new EntityNotFoundException();
		}
	}
	
	@DeleteMapping
	public void delete(Long id) {
		customerService.delete(id);
	}
}
