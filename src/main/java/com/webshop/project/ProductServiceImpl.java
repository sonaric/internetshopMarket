package com.webshop.project;

import com.webshop.project.db.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by stanislav on 18.10.17.
 */
@Repository
@Transactional
@Service("productService")
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    @Transactional(readOnly = true)
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Product findProductById(Long id) {
        return productRepository.findOne(id);
    }

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
}
