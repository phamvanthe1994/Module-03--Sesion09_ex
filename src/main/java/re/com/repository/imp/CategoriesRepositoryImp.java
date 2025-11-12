package re.com.repository.imp;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import re.com.model.Categories;
import re.com.repository.CategoriesRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class CategoriesRepositoryImp implements CategoriesRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Categories> findAll() {
        return entityManager.createQuery("from Categories", Categories.class).getResultList();
    }

    @Override
    public Categories findById(int catalogId) {
        return entityManager.createQuery("from Categories where catalogId = :catalogId", Categories.class).setParameter("catalogId", catalogId).getSingleResult();
    }

    @Override
    // Khi thêm , sửa , xóa bắt buộc phải quản lý transaction (Spring)
    @Transactional
    public boolean save(Categories catalog) {
        try {
            entityManager.persist(catalog);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    @Transactional
    public boolean update(Categories catalog) {
        try {
            entityManager.merge(catalog);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    @Transactional
    public boolean delete(int catalogId) {
        try {
            Categories catalog = entityManager.find(Categories.class, catalogId);
            entityManager.remove(catalog);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    // Phân trang
    @Override
    public List<Categories> findByPage(int pageNumber, int pageSize) {
        return entityManager.createQuery("from Categories", Categories.class)
                .setFirstResult((pageNumber - 1) * pageSize)
                .setMaxResults(pageSize)
                .getResultList();
    }

    @Override
    public long countAll() {
        return entityManager.createQuery("SELECT COUNT (c) from Categories c", Long.class)
                .getSingleResult();
    }
}
