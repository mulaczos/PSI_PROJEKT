package shop.infrastructure.domain.model.dto;

import lombok.Data;
import shop.infrastructure.domain.model.customer.Customer;

import java.util.List;

/**
 * Created by Witu on 08.05.2017.
 */
@Data
public class OrderDto {

    private List<OrderItemDto> items;
    private Double summary;
    private CustomerDto customer;

}
