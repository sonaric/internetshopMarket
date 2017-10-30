package com.webshop.project;

import com.webshop.project.db.UserDetail;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by stanislav on 26.10.17.
 */
public interface UserDetailRepository extends JpaRepository<UserDetail, Long> {
    UserDetail findUserDetailByUsername(String username);
    UserDetail findUserDetailByEmail(String email);
}
