package shop.infrastructure.domain.model;

import shop.infrastructure.domain.model.base.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Witold on 2017-05-30.
 */
@Entity
@Table(name="CITY")
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
