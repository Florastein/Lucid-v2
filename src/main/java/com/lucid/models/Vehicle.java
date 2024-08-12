package com.lucid.models;

public class Vehicle {
    private String brand;
    private String model;
    private int year;
    private String color;
    private String engine;
    private Boolean isAvailable;


    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }

    public String getEngine() {
        return engine;
    }
    public void setEngine(String engine) {
        this.engine = engine;
    }

    public Boolean getIsAvailable() {
        return isAvailable;
    }
    public void setIsAvailable(Boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public Vehicle(String brand, String model, int year, String color, String engine, Boolean isAvailable) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.color = color;
        this.engine = engine;
        this.isAvailable = isAvailable;
    }
    public Vehicle() {}
}
