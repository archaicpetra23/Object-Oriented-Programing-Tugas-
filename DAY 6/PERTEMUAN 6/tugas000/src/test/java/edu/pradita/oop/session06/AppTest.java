package edu.pradita.oop.session06;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    @Test
    void testTambah() {
        assertEquals(8.0, App.hitung(5, 3, 1), 0.0001);
    }

    @Test
    void testKurang() {
        assertEquals(2.0, App.hitung(5, 3, 2), 0.0001);
    }

    @Test
    void testKali() {
        assertEquals(15.0, App.hitung(5, 3, 3), 0.0001);
    }

    @Test
    void testBagi() {
        assertEquals(5.0, App.hitung(10, 2, 4), 0.0001);
    }

    @Test
    void testBagiNol() {
        assertThrows(IllegalArgumentException.class,
                () -> App.hitung(10, 0, 4));
    }

    @Test
    void testOperasiTidakValid() {
        assertThrows(IllegalArgumentException.class,
                () -> App.hitung(10, 2, 9));
    }
}
