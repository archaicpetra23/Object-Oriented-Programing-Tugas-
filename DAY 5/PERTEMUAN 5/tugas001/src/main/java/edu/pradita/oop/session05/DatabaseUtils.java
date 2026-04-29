package edu.pradita.oop.session05;

import java.sql.*;

/**
 * Helper class untuk koneksi database.
 * TODO: Mahasiswa bisa pakai atau buat sendiri.
 */
public class DatabaseUtils {

    private static final String URL = "jdbc:mysql://localhost:3306/perpustakaan?useSSL=false&serverTimezone=UTC";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    /**
     * TODO 9: Buat method getConnection() yang return Connection
     */
    public static Connection getConnection() throws SQLException {
        // TODO: implement DriverManager.getConnection(URL, USERNAME, PASSWORD)
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
}
