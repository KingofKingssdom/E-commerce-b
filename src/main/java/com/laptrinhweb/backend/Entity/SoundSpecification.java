package com.laptrinhweb.backend.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "SoundSpecifications")
public class SoundSpecification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "SoundTechnology")
    private String soundTechnology;
    @Column(name = "Micro")
    private String micro;
    @Column(name = "Feature")
    private String feature;
    @Column(name = "Bluetooth")
    private String bluetooth;
    @Column(name = "Pin")
    private String pin;
    @Column(name = "Size")
    private String size;
    @Column(name = "Weight")
    private String weight;
    @Column(name = "Scope")
    private String scope;

    @ManyToOne
    @JoinColumn(name = "productId")
    private Product product;

    public SoundSpecification() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSoundTechnology() {
        return soundTechnology;
    }

    public void setSoundTechnology(String soundTechnology) {
        this.soundTechnology = soundTechnology;
    }

    public String getMicro() {
        return micro;
    }

    public void setMicro(String micro) {
        this.micro = micro;
    }

    public String getFeature() {
        return feature;
    }

    public void setFeature(String feature) {
        this.feature = feature;
    }

    public String getBluetooth() {
        return bluetooth;
    }

    public void setBluetooth(String bluetooth) {
        this.bluetooth = bluetooth;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
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

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }
}
