package com.webshop.project.db;

import javax.persistence.*;

/**
 * Created by stanislav on 25.10.17.
 */
@Entity
@Table(name = "authorities")
public class UserRoles {
    private Long id;
    private String username;
    private String role;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "authorities_id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(name = "authority")
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
