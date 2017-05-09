package shop.infrastructure.domain.model;

import lombok.Data;
import shop.infrastructure.domain.model.base.BaseEntity;
import shop.infrastructure.domain.model.customer.Customer;

import javax.persistence.*;
import java.util.List;

import static javax.persistence.CascadeType.PERSIST;
import static javax.persistence.EnumType.STRING;
import static shop.infrastructure.domain.model.OrderState.PLACED;

@Data
@Entity
@Table(name = "Orders")
public class Order extends BaseEntity {

    @OneToMany(mappedBy = "order", cascade = PERSIST)
    private List<OrderItem> items;
    private Double summary;
    @ManyToOne
    @JoinColumn(name = "USER_ID", nullable = false)
    private Customer customer;
    @Embedded
    private CustomerDetails customerDetails;
    @Enumerated(STRING)
    private OrderState state = PLACED;

}
