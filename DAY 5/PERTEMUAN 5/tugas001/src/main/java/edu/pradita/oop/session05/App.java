package edu.pradita.oop.session05;

import java.sql.SQLException;
import java.util.List;

/**
 * TUGAS001 – Demo CRUD Buku (Console)
 * Test 4 fungsi repository sebelum bikin JavaFX UI.
 */
public class App {

    public static void main(String[] args) {
        BukuRepository repo = new BukuRepository();

        try {
            System.out.println("=== TUGAS001: CRUD Buku ===");

            // TODO 14: Test READ ALL
            System.out.println("\n1. READ ALL:");
            List<Buku> allBuku = repo.findAll();
            for (Buku b : allBuku) {
                System.out.println(b);
            }

            // TODO 15: Test CREATE (tambahkan buku baru)
            System.out.println("\n2. CREATE:");
            Buku newBuku = new Buku(0, "Java The Complete Reference", "Herbert Schildt", 2020, 2);
            repo.save(newBuku);
            System.out.println("Buku baru ditambahkan: " + newBuku);

            // TODO 16: Test UPDATE (ubah stok buku ID=1)
            System.out.println("\n3. UPDATE:");
            repo.updateStok(1, 4);  // misalnya ubah stok jadi 4
            System.out.println("Stok buku ID=1 diupdate");

            // TODO 17: Test DELETE (hapus buku ID=999 jika ada)
            System.out.println("\n4. DELETE:");
            boolean deleted = repo.deleteById(999);
            System.out.println("Berhasil hapus ID=999? " + deleted);

            System.out.println("\nSemua CRUD berhasil!");

        } catch (SQLException e) {
            System.err.println("Database error:");
            e.printStackTrace();
        }
    }
}
