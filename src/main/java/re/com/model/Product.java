package re.com.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Product")
public class Product {
    @Id
    @Column(name = "product_id", columnDefinition = "char(5)")
    private int productId;

    @Column(name = "product_name", columnDefinition = "varchar(100)", nullable = false, unique = true)
    private String productName;

    @Column(name = "product_price", columnDefinition = "float check(product_price > 0)")
    private float price;

    @Column(name = "product_title", columnDefinition = "text")
    private String title;

    @Column(name = "product_status")
    private boolean status;

    @ManyToOne
    @JoinColumn(name = "catalog_id", referencedColumnName = "catalog_id")
    private Categories catalog;
}
