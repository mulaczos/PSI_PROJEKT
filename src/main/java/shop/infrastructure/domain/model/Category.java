package shop.infrastructure.domain.model;

import lombok.Data;
import lombok.ToString;
import shop.infrastructure.domain.model.base.BaseEntity;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "CATEGORIES")
public class Category extends BaseEntity {

    private String name;
}
