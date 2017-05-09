package shop.infrastructure.domain.model;

import lombok.Data;
import shop.infrastructure.domain.model.base.BaseEntity;
import shop.infrastructure.domain.model.customer.Customer;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

import static javax.persistence.CascadeType.PERSIST;

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

}
