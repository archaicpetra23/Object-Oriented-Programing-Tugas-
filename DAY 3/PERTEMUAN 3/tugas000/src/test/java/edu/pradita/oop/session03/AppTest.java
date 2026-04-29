package edu.pradita.oop.session03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    @Test
    void testSprintCategory() {
        assertEquals("Kategori Lari Cepat", App.getRank(11.5));
    }

    @Test
    void testMiddleDistanceCategoryLowerBound() {
        assertEquals("Kategori Lari Menengah", App.getRank(12.0));
    }

    @Test
    void testMiddleDistanceCategoryUpperBound() {
        assertEquals("Kategori Lari Menengah", App.getRank(20.0));
    }

    @Test
    void testLongDistanceCategory() {
        assertEquals("Kategori Lari Jarak Jauh", App.getRank(25.0));
    }

    @Test
    void testNegativeTime() {
        assertEquals("Waktu tidak boleh negatif", App.getRank(-5.0));
    }
}
