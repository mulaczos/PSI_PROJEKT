package shop.infrastructure.domain.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Witu on 08.03.2017.
 */
@Data
@Entity
@Table(name="Items")
public class Item {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Double price;
    private boolean deleted;
}
