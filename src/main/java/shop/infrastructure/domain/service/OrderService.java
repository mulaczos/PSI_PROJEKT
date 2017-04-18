package shop.infrastructure.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.infrastructure.domain.model.Order;
import shop.infrastructure.domain.repository.OrderRepository;

import java.util.List;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository orderRepository;
	
	public Order save(Order order) {
		return orderRepository.save(order);
	}
	
	
	public Order get(Long id) {
		return orderRepository.findOne(id);
	}
	
	
	public List<Order> getAll() {
		return orderRepository.findAll();
	}
	
	public Order update(Order order) {
		return orderRepository.save(order);
	}
	
	public void delete(Long id) {
		orderRepository.delete(id);
	}
}
