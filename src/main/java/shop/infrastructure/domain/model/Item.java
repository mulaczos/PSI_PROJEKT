package shop.infrastructure.domain.model;

import lombok.Data;
import shop.infrastructure.domain.model.base.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "Items")
public class Item extends BaseEntity {

    private String name;
    private Double price;
    private Integer quantity;
    private String shortDescription;
    private String fullDescription;
    @ManyToOne(fetch = FetchType.LAZY)
    private Order order;
    @ManyToOne
    private Category category;
}
