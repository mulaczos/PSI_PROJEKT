package shop.infrastructure.domain.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import shop.infrastructure.domain.model.Order;
import shop.infrastructure.domain.service.OrderService;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequestMapping("order")
public class OrderController {

    @Autowired
    private OrderService orderService;
    
    @GetMapping(params = "{id}")
    public Order get(Long id) {
        return orderService.get(id);
    }
    
    @GetMapping
    public List<Order> getAllOrders() {
        return orderService.getAll();
    }
    
    @PostMapping
    public Order save(Order order) {
        return orderService.save(order);
    }
    
    @PutMapping
    public Order update(Order order) {
        if (orderService.get(order.getId()) != null) {
            return orderService.update(order);
        } else {
            throw new EntityNotFoundException();
        }
    }
    
    @DeleteMapping
    public void delete(Long id) {
        orderService.delete(id);
    }

}
