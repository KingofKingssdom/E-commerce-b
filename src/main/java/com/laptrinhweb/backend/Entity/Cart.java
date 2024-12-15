package com.laptrinhweb.backend.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "carts")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "productName")
        private String productName;
    @Column(name = "priceCurrent")
    private double priceCurrent;

    @Lob
    @Column(name = "productImage", columnDefinition = "LONGBLOB")
    private byte [] productImage;

    public Cart() {
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

    public double getPriceCurrent() {
        return priceCurrent;
    }

    public void setPriceCurrent(double priceCurrent) {
        this.priceCurrent = priceCurrent;
    }

    public byte[] getProductImage() {
        return productImage;
    }

    public void setProductImage(byte[] productImage) {
        this.productImage = productImage;
    }
}
