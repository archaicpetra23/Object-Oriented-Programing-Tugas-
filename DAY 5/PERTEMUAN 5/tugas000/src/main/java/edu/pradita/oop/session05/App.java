package edu.pradita.oop.session05;

import java.sql.*;

/**
 * TUGAS000 – Koneksi Database XAMPP
 * =================================
 *
 * Tugas:
 * 1. Koneksi ke database "perpustakaan"
 * 2. Query table "test_koneksi" (id, nama)
 * 3. Tampilkan 2 record yang ada di DB
 * 4. Test koneksi harus sukses
 *
 * Data koneksi XAMPP:
 * - Host: localhost
 * - Port: 3306
 * - Database: perpustakaan
 * - Username: root
 * - Password: (kosong)
 */
public class App {

    // TODO 1: Deklarasi 3 konstanta koneksi
    //         - URL: "jdbc:mysql://localhost:3306/perpustakaan?useSSL=false&serverTimezone=UTC"
    //         - USERNAME: "root"
    //         - PASSWORD: "" (kosong untuk XAMPP default)
    private static final String URL = "jdbc:mysql://localhost:3306/perpustakaan?useSSL=false&serverTimezone=UTC";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    public static void main(String[] args) {
        System.out.println("=== TUGAS000: Koneksi Database XAMPP ===");

        // TODO 2: Deklarasi 3 variabel untuk resource management
        //         - Connection connection = null;
        //         - Statement stmt = null;
        //         - ResultSet rs = null;
        Connection connection = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // TODO 3: Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
                    

            // TODO 4: Buat koneksi ke database
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        

            // TODO 5: Buat Statement object
            stmt = connection.createStatement();

            // TODO 6: Execute query SELECT * FROM test_koneksi
            rs = stmt.executeQuery("SELECT * FROM test_koneksi");

            System.out.println("Data dari table test_koneksi:");
            System.out.println("ID\tNama");
            System.out.println("--------");

            // TODO 7: Loop ResultSet dan print id + nama
            while(rs.next()) {
                System.out.println(rs.getInt("id") + "\t" + rs.getString("nama"));
            }

            System.out.println("Koneksi berhasil! 2 record ditemukan.");

        } catch (SQLException e) {
            System.err.println("Warning: Error koneksi atau query:");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.err.println("Warning: Driver MySQL tidak ditemukan:");
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Warning: Error lain:");
            e.printStackTrace();
        } finally {
            // TODO 8: Tutup resource dalam urutan: ResultSet → Statement → Connection
            //         Gunakan try-catch di dalam finally
                    if (rs != null) try { rs.close(); } catch (SQLException ignored) {}
                    if (stmt != null) try { stmt.close(); } catch (SQLException ignored) {}
                    if (connection != null) try { connection.close(); } catch (SQLException ignored) {}
        }
    }
}
