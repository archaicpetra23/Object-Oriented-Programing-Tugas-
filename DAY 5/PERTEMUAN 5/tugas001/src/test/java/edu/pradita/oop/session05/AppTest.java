package edu.pradita.oop.session05;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    private BukuRepository repo;
    private Connection conn;

    @BeforeEach
    void setUp() throws SQLException {
        conn = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/perpustakaan?useSSL=false&serverTimezone=UTC",
            "root", ""
        );
        repo = new BukuRepository();
    }

    @AfterEach
    void tearDown() throws SQLException {
        if (conn != null) conn.close();
    }

    @Test
    void testFindAll() throws SQLException {
        List<Buku> bukus = repo.findAll();
        assertNotNull(bukus);
        assertFalse(bukus.isEmpty(), "Harus ada minimal 3 buku sample");
    }

    @Test
    void testSaveCreatesNewBuku() throws SQLException {
        Buku newBuku = new Buku(0, "Test Buku", "Test Author", 2023, 1);
        repo.save(newBuku);

        // Verify inserted
        List<Buku> all = repo.findAll();
        boolean found = all.stream()
            .anyMatch(b -> b.getJudul().equals("Test Buku"));
        assertTrue(found);
    }

    @Test
    void testUpdateStok() throws SQLException {
        int bookId = 1;  // asumsikan ada buku ID=1
        int oldStok = getStokById(bookId);
        repo.updateStok(bookId, oldStok + 1);

        int newStok = getStokById(bookId);
        assertEquals(oldStok + 1, newStok);
    }

    @Test
    void testDeleteById() throws SQLException {
        // Insert test data
        Buku testBuku = new Buku(0, "Delete Test", "Test", 2023, 1);
        repo.save(testBuku);

        // Cari ID yang baru dibuat
        int testId = findIdByJudul("Delete Test");
        assertTrue(testId > 0);

        // Delete
        boolean deleted = repo.deleteById(testId);
        assertTrue(deleted);

        // Verify deleted
        List<Buku> all = repo.findAll();
        boolean stillExists = all.stream()
            .anyMatch(b -> b.getId() == testId);
        assertFalse(stillExists);
    }

    // Helper methods untuk test
    private int getStokById(int id) throws SQLException {
        String sql = "SELECT stok FROM buku WHERE id = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, id);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            return rs.getInt("stok");
        }
        return -1;
    }

    private int findIdByJudul(String judul) throws SQLException {
        String sql = "SELECT id FROM buku WHERE judul = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, judul);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            return rs.getInt("id");
        }
        return -1;
    }
}
