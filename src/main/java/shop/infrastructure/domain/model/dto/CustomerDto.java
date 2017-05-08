package shop.infrastructure.domain.model.dto;

import lombok.Data;

@Data
public class CustomerDto {

    private String username;
    private String password;
    private String email;
    private String name;
    private String lastname;
    private boolean enabled;
    private String address;
    private String city;
    private Long zipcode;
}
