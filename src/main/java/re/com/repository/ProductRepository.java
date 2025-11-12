package re.com.repository;

import re.com.model.Product;

import java.util.List;

public interface ProductRepository {
    List<Product> findAll();

}
