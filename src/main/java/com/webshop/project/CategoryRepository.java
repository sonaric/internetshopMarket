package com.webshop.project;

import com.webshop.project.db.Category;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by stanislav on 19.10.17.
 */
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
