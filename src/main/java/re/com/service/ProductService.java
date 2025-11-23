package re.com.service;

import re.com.dto.request.ProductDto;
import re.com.dto.request.UpdateProductDto;
import re.com.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();

    boolean addProduct(ProductDto productDto);

    UpdateProductDto findById(String productId);

    boolean updateProduct(UpdateProductDto updateProductDto);

    boolean deleteProduct(String productId);

}
