package shop.infrastructure.domain.controller;

import java.security.Principal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import shop.infrastructure.domain.model.Order;
import shop.infrastructure.domain.service.OrderService;

@RestController
@RequestMapping("api/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("{id}")
    public Order get(@PathVariable Long id) {
        return orderService.get(id);
    }

    @GetMapping
    public List<Order> getAllOrders() {
        return orderService.getAll();
    }

    @PostMapping
    public Order save(@RequestBody Order order) {
        return orderService.save(order);
    }

    @PutMapping
    public Order update(@RequestBody Order order) {
        return orderService.update(order);
    }

    @DeleteMapping
    public void delete(Long id) {
        orderService.delete(id);
    }

    @GetMapping("my")
    public List<Order> getMyOrders(Principal principal) {
        return orderService.getMyOrders(principal.getName());
    }

    @PostMapping("confirm")
    public Order confirmOrder(@RequestBody Order order) {
        return orderService.confirmOrder(order);
    }

    @PostMapping("reject")
    public Order rejectOrder(@RequestBody Order order) {
        return orderService.rejectOrder(order);
    }

}
