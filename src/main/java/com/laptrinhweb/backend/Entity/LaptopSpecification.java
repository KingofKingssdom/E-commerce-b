package com.laptrinhweb.backend.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "LaptopSpecifications")
public class LaptopSpecification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "GPU")
    private String gpu;
    @Column(name = "CPU")
    private String cpu;
    @Column(name = "RAM")
    private String ram;
    @Column(name = "RAMCapacity")
    private String ramCapacity;
    @Column(name = "HardDrive")
    private String  hardDrive;
    @Column(name = "Screen")
    private String screen;
    @Column(name = "ScreenSize")
    private String screenSize;
    @Column(name = "ScreenResolution")
    private String screenResolution;
    @Column(name = "Sound")
    private String sound;
    @Column(name = "GateConnection")
    private String gateConnection;
    @Column(name = "Source")
    private String source;
    @Column(name = "Pin")
    private String pin;
    @Column(name = "OperatingSystem")
    private String operatingSystem;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "productId")
    private Product product;

    public LaptopSpecification() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGpu() {
        return gpu;
    }

    public void setGpu(String gpu) {
        this.gpu = gpu;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getRamCapacity() {
        return ramCapacity;
    }

    public void setRamCapacity(String ramCapacity) {
        this.ramCapacity = ramCapacity;
    }

    public String getHardDrive() {
        return hardDrive;
    }

    public void setHardDrive(String hardDrive) {
        this.hardDrive = hardDrive;
    }

    public String getScreen() {
        return screen;
    }

    public void setScreen(String screen) {
        this.screen = screen;
    }

    public String getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(String screenSize) {
        this.screenSize = screenSize;
    }

    public String getScreenResolution() {
        return screenResolution;
    }

    public void setScreenResolution(String screenResolution) {
        this.screenResolution = screenResolution;
    }

    public String getSound() {
        return sound;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }

    public String getGateConnection() {
        return gateConnection;
    }

    public void setGateConnection(String gateConnection) {
        this.gateConnection = gateConnection;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }
}
