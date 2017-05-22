package shop.infrastructure.domain.model;

import shop.infrastructure.domain.model.base.BaseEntity;
import shop.infrastructure.domain.model.customer.Customer;
import shop.infrastructure.domain.model.customer.CustomerDetails;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

import static javax.persistence.CascadeType.PERSIST;
import static javax.persistence.EnumType.ORDINAL;
import static shop.infrastructure.domain.model.OrderState.PLACED;

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
    @Enumerated(ORDINAL)
    private OrderState state = PLACED;
    private LocalDate date;

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

    public CustomerDetails getCustomerDetails() {
        return customerDetails;
    }

    public void setCustomerDetails(CustomerDetails customerDetails) {
        this.customerDetails = customerDetails;
    }

    public OrderState getState() {
        return state;
    }

    public void setState(OrderState state) {
        this.state = state;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
