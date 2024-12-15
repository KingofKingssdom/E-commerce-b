package com.laptrinhweb.backend.Entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Brands")
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "description")
    private String description;


    @ManyToMany(fetch = FetchType.EAGER,cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.DETACH})
    @JoinTable(
            name = "Brands_Categories",
            joinColumns =@JoinColumn(name = "BrandId",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "CategoryId", referencedColumnName = "id")
    )
    private List<Category> categories;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "brand")
    private List<Product> products;
    public Brand() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
