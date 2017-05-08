package shop.infrastructure.domain.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import org.hibernate.annotations.Cascade;
import shop.infrastructure.domain.model.base.BaseEntity;

import javax.persistence.*;

@Data
@Entity
@Table(name = "ORDERITEMS")
public class OrderItem extends BaseEntity {

    private String name;
    private Double price;
    private Long quanity;
    private String shortDescription;
    private String fullDescription;
    @ManyToOne
    private Category category;

    @Getter(AccessLevel.NONE)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ORDER_ID")
    @Cascade(value = {org.hibernate.annotations.CascadeType.DETACH})
    private Order order;

}