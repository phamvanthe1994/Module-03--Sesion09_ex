package re.com.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;
import re.com.model.Categories;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class ProductDto {
    @NotBlank(message = "Product Id is required")
    private String productId;

    @NotBlank(message = "Product Name is required")
    private String productName;

    @Min(value = 0, message = "Price is more than 0")
    private float price;

    @Size(min = 6, max = 30, message = "Title between 6 and 30 characters")
    private String title;

    private MultipartFile imageFile;


    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate created;

    private Categories catalog;
}
