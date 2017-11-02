package com.webshop.project;

import com.webshop.project.db.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by stanislav on 31.10.17.
 */
public interface UserRepository extends JpaRepository<User, Long> {
}
