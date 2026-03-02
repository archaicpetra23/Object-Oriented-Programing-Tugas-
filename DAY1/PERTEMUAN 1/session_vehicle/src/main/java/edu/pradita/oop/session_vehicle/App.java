package edu.pradita.oop.session_vehicle;

/**
 * MAIN PROGRAM - JANGAN DIUBAH!
 * Demo polymorphism Vehicle/Car/Motorcycle.
 * Jalankan: mvn exec:java -Dexec.mainClass="edu.pradita.oop.session_vehicle.App"
 */
public class App {
    public static void main(String[] args) {
        System.out.println("=== SESSION VEHICLE OOP DEMO ===\n");

        // Upcasting: Vehicle reference, Car object
        Vehicle car = new Car("Toyota", "Corolla", 2020);
        Vehicle motor = new Motorcycle("Honda", "CBR 150R", 2022);

        System.out.println("🚗 CAR:");
        car.start();      // TODO: Harus print "Car engine..."
        car.honk();       // TODO: Harus print "Car horn..."
        System.out.println(car.getDescription());

        System.out.println("\n🏍️ MOTORCYCLE:");
        motor.start();    // TODO: Harus print "Motorcycle engine..."
        motor.honk();     // TODO: Harus print "Motorcycle horn..."
        System.out.println(motor.getDescription());

        System.out.println("\n✅ Semua method harus override dan getter harus work!");
    }
}
