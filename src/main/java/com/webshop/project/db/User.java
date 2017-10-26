package com.webshop.project.db;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by stanislav on 25.10.17.
 */
@Entity
@Table(name = "users")
public class User {
    private String username;
    private String password;
    private boolean enabled;
    private UserDetail userDetail;
    private List<UserRoles> roles = new ArrayList<UserRoles>();

    @Id
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "enabled")
    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "username")
    public UserDetail getUserDetail() {
        return userDetail;
    }

    public void setUserDetail(UserDetail userDetail) {
        this.userDetail = userDetail;
    }

    @Transient
    public List<UserRoles> getRoles() {
        return roles;
    }

    public void setRoles(List<UserRoles> roles) {
        this.roles = roles;
    }
}
