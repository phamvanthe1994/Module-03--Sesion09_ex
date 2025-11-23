package re.com.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Product")
public class Product {
    @Id
    @Column(name = "product_id", columnDefinition = "char(5)")
    private String productId;

    @Column(name = "product_name", columnDefinition = "varchar(100)", nullable = false, unique = true)
    private String productName;

    @Column(name = "product_price", columnDefinition = "float check(product_price > 0)")
    private float price;

    @Column(name = "product_title", columnDefinition = "text")
    private String title;

    @Column(name = "product_status", columnDefinition = "bit default(1)")
    private boolean status;

    @Column(name = "product_avatar", columnDefinition = "text")
    private String avatar;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "product_created")
    private LocalDate created;

    @ManyToOne
    @JoinColumn(name = "catalog_id", referencedColumnName = "catalog_id")
    private Categories catalog;
}
