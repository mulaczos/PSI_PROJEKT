package shop.infrastructure.domain.model;

import lombok.Data;
import shop.infrastructure.domain.model.base.BaseEntity;

import javax.persistence.*;

/**
 * Created by Witu on 08.03.2017.
 */
@Data
@Entity
@Table(name="Items")
public class Item extends BaseEntity {

    private String name;
    private Double price;
    @ManyToOne(fetch = FetchType.LAZY)
    private Order order;
}
