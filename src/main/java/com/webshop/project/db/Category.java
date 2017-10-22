package com.webshop.project.db;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by stanislav on 18.10.17.
 */
@Entity
@Table(name = "category")
public class Category {
    private Long categoryId;
    private String image;
    private boolean status;
    private CategoryDescription categoryDescription;
    private List<GroupCategory> categoryList = new ArrayList<GroupCategory>();


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

    @OneToMany(mappedBy = "category",
    cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    public List<GroupCategory> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<GroupCategory> categoryList) {
        this.categoryList = categoryList;
    }
}
