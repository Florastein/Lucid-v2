/*package com.lucid.models;

public class Vehicle {
    private int id;
    private String brand;
    private String model;
    private int year;
    private String chasis;
    private String color;
    private String engine;
    private Boolean isAvailable;
    private String vehicleLicense;

    // Default constructor
    public Vehicle() {
    }

    // Parameterized constructor
//    public Vehicle(int id, String vehicleLicense, String brand, String model, int year, String engine, String color, Boolean isAvailable, String chasis) {
//        this.id = id;
//        this.vehicleLicense = vehicleLicense;
//        this.brand = brand;
//        this.model = model;
//        this.year = year;
//        this.color = color;
//        this.engine = engine;
//        this.isAvailable = isAvailable;
//        this.chasis = chasis;
//    }

    public Vehicle(int id, String vehicleLicense, String brand, String model, int year, String chasis, String color, boolean isAvailable) {
        this.id = id;
        this.vehicleLicense = vehicleLicense;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.chasis = chasis;
        this.color = color;
        this.isAvailable = isAvailable;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public Boolean getAvailable() {
        return isAvailable;
    }

    public void setAvailable(Boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public String getVehicleLicense() {
        return vehicleLicense;
    }

    public void setVehicleLicense(String vehicleLicense) {
        this.vehicleLicense = vehicleLicense;
    }

    // Alternative isAvailable method
    public boolean isAvailable() {
        return this.isAvailable != null && this.isAvailable;
    }

    public String getChasis() {
        return chasis;
    }

    public void setChasis(String chasis) {
        this.chasis = chasis;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", vehicleLicense='" + vehicleLicense + '\'' +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", chasis='" + chasis + '\'' +
                ", color='" + color + '\'' +
                ", isAvailable=" + isAvailable +
                '}';
    }
}*/

package com.lucid.models;

import javafx.beans.binding.BooleanExpression;

public class Vehicle {
    private int id;
    private String vehicleLicense;
    private String brand;
    private String model;
    private int year;
    private String chasis;
    private String color;
    private boolean isAvailable;

    // Constructor with all fields
    public Vehicle(int id, String vehicleLicense, String brand, String model, int year, String chasis, String color, boolean isAvailable) {
        this.id = id;
        this.vehicleLicense = vehicleLicense;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.chasis = chasis;
        this.color = color;
        this.isAvailable = isAvailable;
    }

    // Default constructor
    public Vehicle() {}

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVehicleLicense() {
        return vehicleLicense;
    }

    public void setVehicleLicense(String vehicleLicense) {
        this.vehicleLicense = vehicleLicense;
    }

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

    public String getChasis() {
        return chasis;
    }

    public void setChasis(String chasis) {
        this.chasis = chasis;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    // Override toString method for better readability
    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", vehicleLicense='" + vehicleLicense + '\'' +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", chasis='" + chasis + '\'' +
                ", color='" + color + '\'' +
                ", isAvailable=" + isAvailable +
                '}';
    }

}

