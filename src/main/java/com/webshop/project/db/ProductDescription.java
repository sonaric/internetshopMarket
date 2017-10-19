package com.webshop.project.db;

import javax.persistence.*;

/**
 * Created by stanislav on 19.10.17.
 */
@Entity
@Table(name = "product_description")
public class ProductDescription {
    private Long id;
    private String name;
    private String description;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
