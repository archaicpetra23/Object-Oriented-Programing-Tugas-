package edu.pradita.oop.session_vehicle;

/**
 * SUPERCLASS - Lengkapi TODO!
 */
public class Vehicle {

    // TODO 1: Buat 3 private field
     private String model;
     private String brand;
     private int year;

    // TODO 2: Constructor dengan 3 parameter
    public Vehicle(String brand, String model, int year) {
        // TODO: Inisialisasi field dengan parameter
        this.model = model;
        this.brand = brand;
        this.year = year;
    }

    // TODO 3: Method start() - print "Vehicle is starting..."
    public void start() {
        // TODO: Implement
        System.out.println("Vehicle is starting...");
       
        
    }

    // TODO 4: Method honk() - print "Beep!"
    public void honk() {
        // TODO: Implement
        System.out.println("Beep!");
    }

    // TODO 5: Method getDescription() - return "YEAR BRAND MODEL"
    public String getDescription() {
        // TODO: Implement
        return year + " " + brand + " " + model;
    }

    // TODO 6: 3 getter method
     public String getBrand() { return brand; }
     public String getModel() { return model; }
     public int getYear() { return year; }
}