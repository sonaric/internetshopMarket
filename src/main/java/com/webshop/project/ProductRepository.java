package com.webshop.project;

import com.webshop.project.db.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by stanislav on 18.10.17.
 */
public interface ProductRepository extends JpaRepository<Product,Long>{
    /*@Query("Select s from Product s ORDER BY s.price")
    List<Product> getOrOrderByPrice();*/
}
