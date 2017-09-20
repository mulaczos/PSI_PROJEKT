package shop.infrastructure.domain.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import shop.infrastructure.domain.model.base.BaseEntity;

@Entity
@Table(name = "CATEGORIES")
public class Category extends BaseEntity {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
