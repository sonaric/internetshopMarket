package com.webshop.project.db;

import javax.persistence.*;

/**
 * Created by stanislav on 19.10.17.
 */
@Entity
@Table(name = "category_description")
public class CategoryDescription {
    private Long categoryId;
    private String name;
    private String description;
    private Category category;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    @Column(name="name")
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

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
