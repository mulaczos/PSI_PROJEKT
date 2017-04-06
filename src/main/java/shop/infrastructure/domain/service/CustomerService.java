package shop.infrastructure.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.infrastructure.domain.model.Customer;
import shop.infrastructure.domain.repository.CustomerRepository;

import java.util.List;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	public Customer get(Long id) {
		return customerRepository.findOne(id);
	}
	
	public List<Customer> getAll() {
		return customerRepository.findAll();
	}
	
	public Customer save(Customer customer) {
		return customerRepository.save(customer);
	}
	
	public Customer update(Customer customer) {
		return customerRepository.save(customer);
	}
	
	public void delete(Long id) {
		customerRepository.delete(id);
	}
}
