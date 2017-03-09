package shop.infrastructure.domain.model;

import lombok.Data;
import shop.infrastructure.domain.model.base.BaseEntity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Witu on 09.03.2017.
 */
@Data
@Entity
@Table(name="Orders")
public class Order extends BaseEntity {

    @OneToMany(mappedBy = "order")
    private List<Item> items;
    private Double summary;
}
