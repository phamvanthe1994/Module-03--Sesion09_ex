package re.com.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import re.com.dto.request.ProductDto;
import re.com.dto.request.UpdateProductDto;
import re.com.model.Product;
import re.com.repository.ProductRepository;
import re.com.service.ProductService;
import re.com.service.UploadFileService;

import java.util.List;

@Service
public class ProductServiceImp implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UploadFileService uploadFileService;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public boolean addProduct(ProductDto productDto) {
        // 1.Upload ảnh lên cloudiary và lấy đường dẫn ảnh
        String imageURL = uploadFileService.uploadFile(productDto.getImageFile());
        // 2.productDto ->   product
        Product product = new Product();
        product.setProductId(productDto.getProductId());
        product.setProductName(productDto.getProductName());
        product.setPrice(productDto.getPrice());
        product.setAvatar(imageURL);
        product.setCreated(productDto.getCreated());
        product.setTitle(productDto.getTitle());
        product.setCatalog(productDto.getCatalog());
        // 3.Gọi repository để thêm mới sản phẩm
        return productRepository.save(product);
    }

    @Override
    public UpdateProductDto findById(String productId) {
        // Chuyển từ model sang DTO
        Product product = productRepository.findById(productId);
        if (product == null) {
            throw new RuntimeException("Product not found");
        }
        UpdateProductDto updateProductDto = new UpdateProductDto();
        updateProductDto.setProductId(product.getProductId());
        updateProductDto.setProductName(product.getProductName());
        updateProductDto.setPrice(product.getPrice());
        updateProductDto.setTitle(product.getTitle());
        updateProductDto.setImageFile(null);
        updateProductDto.setAvatar(product.getAvatar());
        updateProductDto.setCreated(product.getCreated());
        updateProductDto.setCatalog(product.getCatalog());
        return updateProductDto;
    }

    @Override
    public boolean updateProduct(UpdateProductDto updateProductDto) {
        Product product = productRepository.findById(updateProductDto.getProductId());
        if (product == null) {
            throw new RuntimeException("Product not found");
        }

        String imageURL = product.getAvatar();

        if (updateProductDto.getImageFile() != null && !updateProductDto.getImageFile().isEmpty()) {
            imageURL = uploadFileService.uploadFile(updateProductDto.getImageFile());
        }

        product.setProductName(updateProductDto.getProductName());
        product.setPrice(updateProductDto.getPrice());
        product.setTitle(updateProductDto.getTitle());
        product.setCatalog(updateProductDto.getCatalog());
        product.setAvatar(imageURL);
        product.setCreated(updateProductDto.getCreated());

        return productRepository.update(product);

    }

    @Override
    public boolean deleteProduct(String productId) {
        return productRepository.delete(productId);
    }
}
