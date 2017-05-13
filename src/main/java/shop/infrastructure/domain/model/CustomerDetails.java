package shop.infrastructure.domain.model;

import lombok.Data;

import javax.persistence.Embeddable;

@Data
@Embeddable
public class CustomerDetails {

    private String customerName;
    private String customerLastname;
    private String customerEmail;
    private String customerAddress;
    private String customerCity;
    private String customerZipcode;
}
