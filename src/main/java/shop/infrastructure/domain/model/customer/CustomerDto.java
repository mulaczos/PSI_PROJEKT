package shop.infrastructure.domain.model.customer;

import lombok.Data;
import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
public class CustomerDto {

    @NotNull
    private String username;
    @Min(5)
    private String confirmwithpassword;
    @Min(5)
    private String newpassword;
    @Email
    private String email;
    @NotNull
    private String name;
    @NotNull
    private String lastname;
    private boolean enabled = Boolean.TRUE;

}
