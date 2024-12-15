package com.laptrinhweb.backend.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "ScreenSpecifications")
public class ScreenSpecification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "ScreenSize")
    private String screenSize;
    @Column(name = "ScreenType")
    private String screenType;
    @Column(name = "resolution")
    private String resolution;
    @Column(name = "COM")
    private String com;
    @Column(name = "BasePlate")
    private String basePlate;
    @Column(name = "numberOfColor")
    private String numberOfColor;

    @ManyToOne
    @JoinColumn(name = "productId")
    private Product product;

    public ScreenSpecification() {
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

    public String getScreenType() {
        return screenType;
    }

    public void setScreenType(String screenType) {
        this.screenType = screenType;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public String getCom() {
        return com;
    }

    public void setCom(String com) {
        this.com = com;
    }

    public String getBasePlate() {
        return basePlate;
    }

    public void setBasePlate(String basePlate) {
        this.basePlate = basePlate;
    }

    public String getNumberOfColor() {
        return numberOfColor;
    }

    public void setNumberOfColor(String numberOfColor) {
        this.numberOfColor = numberOfColor;
    }
}
