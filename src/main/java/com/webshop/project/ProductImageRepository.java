package com.webshop.project;

import com.webshop.project.db.ProductImage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by stanislav on 19.10.17.
 */
public interface ProductImageRepository extends JpaRepository<ProductImage, Long> {
    List<ProductImage> findProductImageByProductId(long id);
}
