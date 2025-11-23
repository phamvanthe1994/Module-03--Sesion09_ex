package re.com.repository.imp;

import org.springframework.stereotype.Repository;
import re.com.model.Product;
import re.com.repository.ProductRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class ProductRepositoryImp implements ProductRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Product> findAll() {
        return entityManager.createQuery("from Product", Product.class).getResultList();
    }

    @Transactional
    @Override
    public boolean save(Product product) {
        try {
            entityManager.persist(product);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Product findById(String productId) {
//        return entityManager.find(Product.class, productId);
        return entityManager.createQuery("from Product where productId=:productId", Product.class).setParameter("productId", productId).getSingleResult();
    }

    @Override
    @Transactional
    public boolean update(Product product) {
        try {
            entityManager.merge(product);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    @Transactional
    public boolean delete(String productId) {
        try {
            Product product = findById(productId);
            entityManager.remove(product);
            return true;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
