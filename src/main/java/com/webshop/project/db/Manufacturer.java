package com.webshop.project.db;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by stanislav on 22.10.17.
 */
@Entity
@Table(name = "manufacturer")
public class Manufacturer {
    private Long id;
    private String name;
    private String image;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "manufacturer_id")
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

    @Column(name = "image")
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

}

