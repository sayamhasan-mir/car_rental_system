package model;

public class Vehicle {
    private String barcode;
    private String licensePlate;
    private String model;
    private String make;
    private int capacity;
    private double mileage;
    private String parkingStall;
    private String status; // Available, Reserved, Rented

    public Vehicle(String barcode, String licensePlate, String model, String make, int capacity) {
        this.barcode = barcode;
        this.licensePlate = licensePlate;
        this.model = model;
        this.make = make;
        this.capacity = capacity;
        this.status = "Available";
    }

    // Add these public getters
    public String getModel() { return model; }
    public String getStatus() { return status; }

    // Setter for status
    public void setStatus(String status) { this.status = status; }

    @Override
    public String toString() {
        return model + " (" + make + ") - " + status;
    }
}
