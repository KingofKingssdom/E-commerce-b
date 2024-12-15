package com.laptrinhweb.backend.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "TabletSpecifications")
public class TabletSpecification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    @Column(name = "ScreenSize")
    private String screenSize;
    @Column(name = "ScreenTechnology")
    private String screenTechnology;
    @Column(name = "Resolution")
    private String resolution;
    @Column(name = "ScreenFeature")
    private String screenFeature;
    @Column(name = "RearCamera")
    private String rearCamera;
    @Column(name = "FrontCamera")
    private String frontCamera;
    @Column(name = "GPU")
    private String GPU;
    @Column(name = "RAM")
    private String ram;
    @Column (name = "PIN")
    private String pin;
    @Column(name = "Feature")
    private String feature;
    @ManyToOne
    @JoinColumn(name = "productId")
    private Product product;

    public TabletSpecification() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(String screenSize) {
        this.screenSize = screenSize;
    }

    public String getScreenTechnology() {
        return screenTechnology;
    }

    public void setScreenTechnology(String screenTechnology) {
        this.screenTechnology = screenTechnology;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public String getScreenFeature() {
        return screenFeature;
    }

    public void setScreenFeature(String screenFeature) {
        this.screenFeature = screenFeature;
    }

    public String getRearCamera() {
        return rearCamera;
    }

    public void setRearCamera(String rearCamera) {
        this.rearCamera = rearCamera;
    }

    public String getFrontCamera() {
        return frontCamera;
    }

    public void setFrontCamera(String frontCamera) {
        this.frontCamera = frontCamera;
    }

    public String getGPU() {
        return GPU;
    }

    public void setGPU(String GPU) {
        this.GPU = GPU;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getFeature() {
        return feature;
    }

    public void setFeature(String feature) {
        this.feature = feature;
    }
}
