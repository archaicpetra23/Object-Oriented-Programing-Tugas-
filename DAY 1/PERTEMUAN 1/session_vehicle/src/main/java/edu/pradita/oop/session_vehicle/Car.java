package edu.pradita.oop.session_vehicle;

/**
 * CAR CLASS - TODO: Inheritance + Override!
 */
public class Car extends Vehicle {
    
    // TODO 7: Tambah 1 private field khusus Car
     private int number_of_doors;

    // TODO 8: Constructor overload (2 versi)
    // - Car(3 param) → call this()
    // - Car(4 param) → call super()
    public Car(String model, String brand, int year) {
        // TODO: this() atau super()
        super(model, brand, year);
        this.number_of_doors = 4;
    }

    // TODO 9: Override start() → "Car engine is starting..."
    @Override
    public void start() {
        // TODO: Override
        System.out.println("Car engine is starting...");
    }

    // TODO 10: Override honk() → "Car horn: Beep Beep!"
    @Override
    public void honk() {
        // TODO: Override
        System.out.println("Car horn: Beep Beep!");
    }

    // TODO 11: 1 getter khusus Car
     public int getNumberOfDoors() { return number_of_doors; }
}