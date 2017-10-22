package com.webshop.project;

import com.webshop.project.db.ProductToSubCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by stanislav on 22.10.17.
 */
public interface ProductCatalogRepository extends JpaRepository<ProductToSubCategory, Long> {
    List<ProductToSubCategory> findBySubcategoryId(long subcategory);
}
