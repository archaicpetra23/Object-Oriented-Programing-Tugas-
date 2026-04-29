package edu.pradita.oop.session05;

import org.junit.jupiter.api.Test;

import java.sql.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test koneksi dan query.
 * Harus 3 test hijau untuk lolos.
 */
class AppTest {

    private static final String URL = "jdbc:mysql://localhost:3306/perpustakaan?useSSL=false&serverTimezone=UTC";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    @Test
    void testDatabaseConnection() throws SQLException {
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            assertNotNull(conn, "Koneksi ke database harus berhasil");
            assertFalse(conn.isClosed(), "Connection harus terbuka");
        }
    }

    @Test
    void testTableExists() throws SQLException {
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT COUNT(*) FROM test_koneksi")) {

            assertTrue(rs.next(), "Query harus return result");
            int count = rs.getInt(1);
            assertTrue(count >= 2, "Table test_koneksi harus punya minimal 2 record");
        }
    }

    @Test
    void testFetchData() throws SQLException {
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT id, nama FROM test_koneksi")) {

            int rowCount = 0;
            while (rs.next()) {
                rowCount++;
                int id = rs.getInt("id");
                String nama = rs.getString("nama");
                assertTrue(id > 0, "ID harus > 0");
                assertNotNull(nama, "Nama tidak boleh null");
                assertFalse(nama.trim().isEmpty(), "Nama tidak boleh kosong");
            }
            assertEquals(2, rowCount, "Harus tepat 2 record");
        }
    }
}
