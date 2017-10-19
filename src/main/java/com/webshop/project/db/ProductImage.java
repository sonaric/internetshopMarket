package com.webshop.project.db;

import javax.persistence.*;

/**
 * Created by stanislav on 19.10.17.
 */
@Entity
@Table(name = "product_image")
public class ProductImage {
    private Long id;
    private Long productId;
    private String image;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_image_id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    @Column(name = "image")
    public String getImage() {
        return image;
    }
    @Column(name = "product_id")
    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
