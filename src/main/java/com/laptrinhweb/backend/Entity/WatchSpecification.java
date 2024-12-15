package com.laptrinhweb.backend.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "WatchSpecifications")
public class WatchSpecification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "ScreenTechnology")
    private String screenTechnology;
    @Column(name = "ScreenSize")
    private String screenSize;
    @Column(name = "Resolution")
    private String resolution;
    @Column(name = "WireMaterial")
    private String wireMaterial;
    @Column(name = "connection")
    private String connection;
    @Column(name = "Competible")
    private String competible;
    @Column(name = "PIN")
    private String pin;
    @Column(name = "Feature")
    private String feature;

    @ManyToOne
    @JoinColumn(name = "productId")
    private Product product;

    public WatchSpecification() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getScreenTechnology() {
        return screenTechnology;
    }

    public void setScreenTechnology(String screenTechnology) {
        this.screenTechnology = screenTechnology;
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

    public String getWireMaterial() {
        return wireMaterial;
    }

    public void setWireMaterial(String wireMaterial) {
        this.wireMaterial = wireMaterial;
    }

    public String getConnection() {
        return connection;
    }

    public void setConnection(String connection) {
        this.connection = connection;
    }

    public String getCompetible() {
        return competible;
    }

    public void setCompetible(String competible) {
        this.competible = competible;
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
