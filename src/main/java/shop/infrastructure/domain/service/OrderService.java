package shop.infrastructure.domain.service;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shop.infrastructure.domain.model.Order;
import shop.infrastructure.domain.model.OrderItem;
import shop.infrastructure.domain.model.dto.OrderDto;
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

    @Autowired
    private MapperFacade mapperFacade;

    @Transactional
    public Order save(OrderDto order) {
        List<OrderItem> orderItems = mapperFacade.mapAsList(order.getItems(), OrderItem.class);
        Order orderToSave = mapperFacade.map(order, Order.class);
        orderToSave.setItems(null);
        orderRepository.save(orderToSave);
        orderItems.forEach(orderItem -> orderItem.setOrder(orderToSave));
        saveOrderItems(orderItems);
        return orderToSave;
    }

	@Transactional
	public void saveOrderItems(List<OrderItem> orderItems) {
		orderItemRepository.save(orderItems);
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
