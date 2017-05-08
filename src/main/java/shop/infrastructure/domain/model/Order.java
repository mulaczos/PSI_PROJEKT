package shop.infrastructure.domain.model;

import shop.infrastructure.domain.model.base.BaseEntity;
import shop.infrastructure.domain.model.customer.Customer;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Witu on 09.03.2017.
 */

@Entity
@Table(name = "Orders")
public class Order extends BaseEntity {

    @OneToMany(mappedBy = "order")
    private List<OrderItem> items;
    private Double summary;

    @ManyToOne
    @JoinColumn(name = "USER_ID", nullable = false)
    private Customer customer;

    public List<OrderItem> getItems() {
        return items;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }

    public Double getSummary() {
        return summary;
    }

    public void setSummary(Double summary) {
        this.summary = summary;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
