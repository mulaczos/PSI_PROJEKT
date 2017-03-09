package shop.infrastructure.domain.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import shop.infrastructure.domain.model.Order;
import shop.infrastructure.domain.service.OrderService;

/**
 * Created by Witu on 09.03.2017.
 */
@RestController
@RequestMapping("order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public Order save (Order order) {
        return orderService.save(order);
    }

}
