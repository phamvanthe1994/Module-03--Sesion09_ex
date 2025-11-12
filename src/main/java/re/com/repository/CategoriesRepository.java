package re.com.repository;

import re.com.model.Categories;

import java.util.List;

public interface CategoriesRepository {
    List<Categories> findAll();

    Categories findById(int catalogId);

    boolean save(Categories catalog);

    boolean update(Categories catalog);

    boolean delete(int catalogId);

    // Phân trang
    List<Categories> findByPage(int pageNumber, int pageSize);

    long countAll();


}
