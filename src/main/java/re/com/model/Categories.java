package re.com.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Categories")
public class Categories {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "catalog_id")
    private int catalogId;

    @Column(name = "catalog_name", columnDefinition = "varchar(100)", nullable = false, unique = true)
    private String catalogName;

    @Column(name = "catalog_description", columnDefinition = "text")
    private String description;

    @Column(name = "catalog_status", columnDefinition = "bit default 1")
    private boolean status;

    @OneToMany(mappedBy = "catalog", fetch = FetchType.LAZY)
    private List<Product> listProduct = new ArrayList<>();

}
