package shop.infrastructure.domain.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import shop.infrastructure.domain.model.base.BaseEntity;
import shop.infrastructure.domain.model.customer.Customer;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Witu on 09.03.2017.
 */
@Data
@Entity
@Table(name = "Orders")
public class Order extends BaseEntity {

    @OneToMany(cascade=CascadeType.PERSIST)
    @JoinColumn(name="ORDER_ID")
    private List<OrderItem> items;
    private Double summary;

    @ManyToOne
    @JoinColumn(name = "USER_ID", nullable = false)
    private Customer customer;
}
