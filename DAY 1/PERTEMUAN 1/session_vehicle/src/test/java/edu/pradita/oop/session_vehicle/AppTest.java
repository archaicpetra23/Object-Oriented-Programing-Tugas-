package edu.pradita.oop.session_vehicle;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    @Test
    void testVehicleDescription() {
        Vehicle v = new Vehicle("Toyota", "Avanza", 2018);
        assertEquals("2018 Toyota Avanza", v.getDescription());
    }

    @Test
    void testCarDefaults() {
        Car c = new Car("Honda", "Civic", 2021);
        assertEquals("Honda", c.getBrand());
        assertEquals("Civic", c.getModel());
        assertEquals(2021, c.getYear());
        assertEquals(4, c.getNumberOfDoors());
    }

    @Test
    void testMotorcycleFairing() {
        Motorcycle m = new Motorcycle("Yamaha", "R15", 2023, true);
        assertTrue(m.hasFairing());
    }

    @Test
    void testPolymorphism() {
        Vehicle[] vehicles = {new Car("BMW", "X5", 2023), new Motorcycle("Ducati", "Panigale", 2024)};
        for (Vehicle v : vehicles) {
            v.start();  // Harus print versi override masing-masing
        }
    }

    @Test
    void testConstructorChaining() {
        Car c = new Car("Tesla", "Model 3", 2022);  // Test this() → super()
        assertEquals(4, c.getNumberOfDoors());
}

}
