package shop.infrastructure.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shop.infrastructure.domain.model.Order;
import shop.infrastructure.domain.repository.OrderItemRepository;
import shop.infrastructure.domain.repository.OrderRepository;

import java.util.List;

@Service
@Transactional
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Transactional
    public Order save(Order order) {
        order.getItems().forEach(orderItem -> orderItem.setOrder(order));
        orderRepository.save(order);
        return order;
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

    public List<Order> getMyOrders(String customer) {
        return orderRepository.findAllByCustomer_Username(customer);
    }
}
