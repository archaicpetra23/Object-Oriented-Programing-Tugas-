package edu.pradita.oop.session_vehicle;

/**
 * MOTORCYCLE CLASS - TODO: Inheritance + Override!
 */
public class Motorcycle extends Vehicle {
    
    // TODO 12: Tambah 1 private field khusus Motorcycle
     private boolean has_fairing;

    // TODO 13: Constructor overload (2 versi)
    // - Motorcycle(3 param) → call this()
    // - Motorcycle(4 param) → call super()
    public Motorcycle(String model, String brand, int year, boolean has_fairing) {
        // TODO: this() atau super()
        super(model, brand, year);
        this.has_fairing = has_fairing;
    }

    public Motorcycle(String model, String brand, int year) {
        this(model, brand, year, true);
    }

    // TODO 14: Override start() → "Motorcycle engine is starting..."
    @Override
    public void start() {
        // TODO: Override
        System.out.println("Motorcycle engine is starting...");
    }

    // TODO 15: Override honk() → "Motorcycle horn: Beep!"
    @Override
    public void honk() {
        // TODO: Override
        System.out.println("Motorcycle horn: Beep!");
    }

    // TODO 16: 1 getter khusus Motorcycle
     public boolean hasFairing() { return true; }
}