package shop.infrastructure.domain.service;

import java.time.LocalDate;
import java.util.List;
import javax.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shop.infrastructure.domain.model.Order;
import shop.infrastructure.domain.repository.OrderRepository;

import static shop.infrastructure.domain.model.OrderState.CONFIRMED;
import static shop.infrastructure.domain.model.OrderState.REJECTED;

@Service
@Transactional
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Transactional
    public Order save(Order order) {
        order.setDate(LocalDate.now());
        order.getItems().forEach(orderItem -> orderItem.setOrder(order));
        orderRepository.save(order);
        return order;
    }

    public Order get(Long id) {
        return orderRepository.findOne(id);
    }

    public List<Order> getAll() {
        return orderRepository.findAll(new Sort(Sort.Direction.ASC, "state"));
    }

    @Transactional
    public Order update(Order order) {
        if (get(order.getId()) != null) {
            return save(order);
        } else {
            throw new EntityNotFoundException();
        }
    }

    public void delete(Long id) {
        orderRepository.delete(id);
    }

    public List<Order> getMyOrders(String customer) {
        return orderRepository.findAllByCustomer_Username(customer, new Sort(Sort.Direction.ASC, "state"));
    }

    public Order confirmOrder(Order order) {
        Order orderToConfirm = get(order.getId());
        orderToConfirm.setState(CONFIRMED);
        return update(orderToConfirm);
    }

    public Order rejectOrder(Order order) {
        Order orderToReject = get(order.getId());
        orderToReject.setState(REJECTED);
        return update(orderToReject);
    }
}
