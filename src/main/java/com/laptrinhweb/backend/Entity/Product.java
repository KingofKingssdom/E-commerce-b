package com.laptrinhweb.backend.Entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "Products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "ProductName")
    private String productName;
    @Column(name = "Description")
    private String description;
    @Column(name = "PricePrevious")
    private double pricePrevious;
    @Column(name = "PriceCurrent")
    private double priceCurrent;
    @Column(name = "DiscountPrice")
    private String discountPrice;
    @Column(name = "Quantity")
    private String quantity;
    @Column(name = "Status")
    private String status;
    @Column(name = "CreateAtTime")
    private LocalDate createAtTime;
    @Lob
    @Column(name = "productImage",columnDefinition = "LONGBLOB")
    private byte[] productImage;

    // Các quan hệ mapping
    @ManyToOne
    @JoinColumn(name = "categoryId", referencedColumnName = "id")
    private Category category;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "BrandId", referencedColumnName = "id")
    private Brand brand;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<LaptopSpecification> laptopSpecifications;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<SmartPhoneSpecification> smartPhoneSpecifications;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<TabletSpecification> tabletSpecifications;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<SoundSpecification> soundSpecifications;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<WatchSpecification> watchSpecifications;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<ScreenSpecification> screenSpecifications;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<TvSpecification> tvSpecifications;


    public Product() {
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPriceCurrent() {
        return priceCurrent;
    }

    public void setPriceCurrent(double priceCurrent) {
        this.priceCurrent = priceCurrent;
    }

    public String getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(String discountPrice) {
        this.discountPrice = discountPrice;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getCreateAtTime() {
        return createAtTime;
    }

    public void setCreateAtTime(LocalDate createAtTime) {
        this.createAtTime = createAtTime;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public double getPricePrevious() {
        return pricePrevious;
    }

    public void setPricePrevious(double pricePrevious) {
        this.pricePrevious = pricePrevious;
    }

    public byte[] getProductImage() {
        return productImage;
    }

    public void setProductImage(byte[] productImage) {
        this.productImage = productImage;
    }

}

