package com.webshop.project;

import com.webshop.project.db.Product;

import java.util.List;

/**
 * Created by stanislav on 18.10.17.
 */
public interface ProductService {
    List<Product> findAll();
    Product findProductById(Long id);
}
