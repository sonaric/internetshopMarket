package com.webshop.project.db;

import javax.persistence.*;

/**
 * Created by stanislav on 18.10.17.
 */
@Entity
@Table(name = "category")
public class Category {
    private Long categoryId;
    private String image;
    private Long parentId;
    private boolean top;
    private boolean status;
    private CategoryDescription categoryDescription;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    @Column(name = "image")
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Column(name = "parent_id")
    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    @Column(name = "top")
    public boolean isTop() {
        return top;
    }

    public void setTop(boolean top) {
        this.top = top;
    }

    @Column(name = "status")
    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id")
    public CategoryDescription getCategoryDescription() {
        return categoryDescription;
    }

    public void setCategoryDescription(CategoryDescription categoryDescription) {
        this.categoryDescription = categoryDescription;
    }
}
