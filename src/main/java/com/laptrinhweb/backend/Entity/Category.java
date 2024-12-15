package com.laptrinhweb.backend.Entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "CategoryName")
    private String categoryName;
    @ManyToMany(
            mappedBy = "categories",
            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST},
            fetch = FetchType.EAGER)
    private List<Brand> brands;

    @OneToMany( mappedBy = "category")
    private List<Product> products;

    public Category() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
