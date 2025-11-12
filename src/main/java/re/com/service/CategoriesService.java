package re.com.service;

import re.com.model.Categories;

import java.util.List;

public interface CategoriesService {
    List<Categories> findAll();

    Categories findById(int catalogId);

    boolean save(Categories catalog);

    boolean delete(int catalogId);

    boolean update(Categories catalog);

    // Phân trang
    List<Categories> findByPage(int pageNumber, int pageSize);

    long countAll();
}
