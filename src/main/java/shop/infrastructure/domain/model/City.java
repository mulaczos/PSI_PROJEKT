package shop.infrastructure.domain.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import shop.infrastructure.domain.model.base.BaseEntity;

@Entity
@Table(name = "CITY")
public class City extends BaseEntity {

    private String city;
    private String zipcode;

    public String getCity() {
        return city;
    }

    public String getZipcode() {
        return zipcode;
    }
}
