package com.webshop.project.db;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by stanislav on 18.10.17.
 */
@Entity
@Table(name = "product")
public class Product {
    private Long id;
    private int quantity;
    private String image;
    private Long manufacturer_id;
    private double price;
    private boolean starus;
    private int viewed;
    private ProductDescription description;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "quantity")
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Column(name = "image")
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Column(name = "manufacturer_id")
    public Long getManufacturer_id() {
        return manufacturer_id;
    }

    public void setManufacturer_id(Long manufacturer_id) {
        this.manufacturer_id = manufacturer_id;
    }

    @Column(name = "price")
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Column(name = "status")
    public boolean isStarus() {
        return starus;
    }

    public void setStarus(boolean starus) {
        this.starus = starus;
    }

    @Column(name = "viewed")
    public int getViewed() {
        return viewed;
    }

    public void setViewed(int viewed) {
        this.viewed = viewed;
    }

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id")
    public ProductDescription getDescription() {
        return description;
    }

    public void setDescription(ProductDescription description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || this == null) return false;
        Product product = (Product) obj;
        return this.getPrice()>product.getPrice()?true:false;
    }

}
