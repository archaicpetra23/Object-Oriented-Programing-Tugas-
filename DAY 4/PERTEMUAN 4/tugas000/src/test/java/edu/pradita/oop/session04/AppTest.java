package edu.pradita.oop.session04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    // =====================
    // Test: increment dasar
    // =====================

    @Test
    void testCounterInitialValue() {
        App app = new App();
        assertEquals(0, app.getCounter());
    }

    @Test
    void testIncrementBasic() {
        App app = new App();
        app.increment();
        app.increment();
        assertEquals(2, app.getCounter());
    }

    @Test
    void testDecrementBasic() {
        App app = new App();
        app.increment();
        app.decrement();
        assertEquals(0, app.getCounter());
    }

    @Test
    void testIncrementAndDecrement() {
        App app = new App();
        app.increment();
        app.increment();
        assertEquals(2, app.getCounter());
        app.decrement();
        assertEquals(1, app.getCounter());
    }

    // ==========================
    // Test: validasi batas atas
    // ==========================

    @Test
    void testIncrementReturnsTrueWhenBelowMax() {
        App app = new App();
        boolean result = app.increment();
        assertTrue(result, "increment() harus return true jika counter belum mencapai 10");
    }

    @Test
    void testIncrementStopsAtMax() {
        App app = new App();
        // Increment sampai batas
        for (int i = 0; i < 10; i++) {
            app.increment();
        }
        assertEquals(10, app.getCounter(), "Counter harus tepat 10");

        // Increment saat sudah di batas → harus return false dan tidak berubah
        boolean result = app.increment();
        assertFalse(result, "increment() harus return false saat counter == 10");
        assertEquals(10, app.getCounter(), "Counter tidak boleh melebihi 10");
    }

    // ============================
    // Test: validasi batas bawah
    // ============================

    @Test
    void testDecrementReturnsTrueWhenAboveMin() {
        App app = new App();
        app.increment(); // counter = 1 dulu biar aman
        boolean result = app.decrement();
        assertTrue(result, "decrement() harus return true jika counter belum mencapai -3");
    }

    @Test
    void testDecrementStopsAtMin() {
        App app = new App();
        // Decrement sampai batas
        for (int i = 0; i < 3; i++) {
            app.decrement();
        }
        assertEquals(-3, app.getCounter(), "Counter harus tepat -3");

        // Decrement saat sudah di batas → harus return false dan tidak berubah
        boolean result = app.decrement();
        assertFalse(result, "decrement() harus return false saat counter == -3");
        assertEquals(-3, app.getCounter(), "Counter tidak boleh kurang dari -3");
    }
}
