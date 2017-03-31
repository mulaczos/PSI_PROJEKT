package shop.infrastructure.domain.model;

import lombok.Data;
import shop.infrastructure.domain.model.base.BaseEntity;

import javax.persistence.*;

@Data
@Entity
public class Customer extends BaseEntity {

    @Column
    private String firstName;
    @Column
    private String secondName;
    @Column
    private String lastName;
}
