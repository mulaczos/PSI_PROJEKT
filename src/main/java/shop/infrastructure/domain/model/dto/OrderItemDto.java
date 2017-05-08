package shop.infrastructure.domain.model.dto;

import lombok.Data;
import org.hibernate.annotations.Cascade;
import shop.infrastructure.domain.model.Category;
import shop.infrastructure.domain.model.Order;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Created by Witu on 08.05.2017.
 */
@Data
public class OrderItemDto {

    private String name;
    private Double price;
    private Long quanity;
    private String shortDescription;
    private String fullDescription;
    private Category category;
}
