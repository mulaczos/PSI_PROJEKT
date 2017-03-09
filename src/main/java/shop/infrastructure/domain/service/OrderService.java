package shop.infrastructure.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.infrastructure.domain.model.Order;
import shop.infrastructure.domain.repository.OrderRepository;

/**
 * Created by Witu on 09.03.2017.
 */
@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public Order save(Order order) {
        return orderRepository.save(order);
    }




}
