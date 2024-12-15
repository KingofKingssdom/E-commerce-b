package com.laptrinhweb.backend.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "SmartPhoneSpecifications")
public class SmartPhoneSpecification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="ScreenSize")
    private String screenSize;
    @Column(name = "ScreenTechnology")
    private String screenTechnology;
    @Column(name = "resolution")
    private String  resolution;
    @Column(name = "Feature")
    private String feature;
    @Column(name = "RearCamera")
    private String rearCamera;
    @Column(name = "FrontCamera")
    private String frontCamera;
    @Column(name = "GPU")
    private String GPU;
    @Column(name = "GPS")
    private String GPS;
    @Column(name = "OperatingSystem")
    private String operatingSystem;
    @Column(name = "InternalMemory")
    private String internalMemory;
    @Column(name = "Size")
    private String size;
    @Column(name = "Weight")
    private String weight;
    @Column(name = "Pin")
    private String pin;
    @Column(name = "COM")
    private String com;

   @ManyToOne
   @JoinColumn(name = "productId")
    private Product product;

    public SmartPhoneSpecification() {
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

    public String getFeature() {
        return feature;
    }

    public void setFeature(String feature) {
        this.feature = feature;
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

    public String getGPS() {
        return GPS;
    }

    public void setGPS(String GPS) {
        this.GPS = GPS;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public String getInternalMemory() {
        return internalMemory;
    }

    public void setInternalMemory(String internalMemory) {
        this.internalMemory = internalMemory;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getCom() {
        return com;
    }

    public void setCom(String com) {
        this.com = com;
    }
}
