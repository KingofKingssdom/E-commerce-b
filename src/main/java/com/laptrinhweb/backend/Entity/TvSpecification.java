package com.laptrinhweb.backend.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "TvSpecifications")
public class TvSpecification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "ScreenSize")
    private String screenSize;
    @Column(name = "Resolution")
    private String resolution;
    @Column(name = "ScreenCategory")
    private String screenCategory;
    @Column(name = "ScreenTechnology")
    private String screenTechnology;
    @Column(name = "SoundTechnology")
    private String soundTechnology;
    @Column(name = "Connection")
    private String connection;

    @ManyToOne
    @JoinColumn(name = "productId")
    private Product product;

    public TvSpecification() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(String screenSize) {
        this.screenSize = screenSize;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public String getScreenCategory() {
        return screenCategory;
    }

    public void setScreenCategory(String screenCategory) {
        this.screenCategory = screenCategory;
    }

    public String getScreenTechnology() {
        return screenTechnology;
    }

    public void setScreenTechnology(String screenTechnology) {
        this.screenTechnology = screenTechnology;
    }

    public String getSoundTechnology() {
        return soundTechnology;
    }

    public void setSoundTechnology(String soundTechnology) {
        this.soundTechnology = soundTechnology;
    }

    public String getConnection() {
        return connection;
    }

    public void setConnection(String connection) {
        this.connection = connection;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
