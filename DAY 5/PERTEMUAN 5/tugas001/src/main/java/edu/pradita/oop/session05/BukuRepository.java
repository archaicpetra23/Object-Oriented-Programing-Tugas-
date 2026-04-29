package edu.pradita.oop.session05;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * TUGAS001 – CRUD Buku
 * Repository untuk 4 operasi: READ, CREATE, UPDATE, DELETE
 */
public class BukuRepository {

    /**
     * TODO 10: READ ALL – Ambil semua buku dari DB
     *
     * Query: SELECT * FROM buku
     * Return: List<Buku>
     */
    public List<Buku> findAll() throws SQLException {
        List<Buku> bukus = new ArrayList<>();

        // TODO: 
        // 1. Dapatkan connection
        // 2. Buat statement
        // 3. ExecuteQuery "SELECT * FROM buku"
        // 4. Loop ResultSet → buat Buku object → tambah ke list
        // 5. Close resource
        // 6. Return list

    String sql = "SELECT * FROM buku";
    
    try(
        Connection conn = DatabaseUtils.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql)
    ) {
        while (rs.next()) {
            Buku buku = new Buku();

            buku.setId(rs.getInt("id"));
            buku.setJudul(rs.getString("judul"));
            buku.setPenulis(rs.getString("penulis"));
            buku.setTahunTerbit(rs.getInt("tahun_terbit"));
            buku.setStok(rs.getInt("stok"));

            bukus.add(buku);
            }
        }

        return bukus;
    }

    /**
     * TODO 11: CREATE – Tambah buku baru
     *
     * Query: INSERT INTO buku (judul, penulis, tahun_terbit, stok) VALUES (?, ?, ?, ?)
     */
    public void save(Buku buku) throws SQLException {

        String sql = "INSERT INTO buku (judul, penulis, tahun_terbit, stok) VALUES (?, ?, ?, ?)";

        try(
            Connection conn = DatabaseUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)
        )  {
            ps.setString(1, buku.getJudul() );
            ps.setString(2, buku.getPenulis());
            ps.setInt(3, buku.getTahunTerbit());    
            ps.setInt(4,  buku.getStok());

            ps.executeUpdate();
        }
        // TODO:
        // 1. Dapatkan connection
        // 2. PreparedStatement dengan INSERT
        // 3. Set parameter: judul, penulis, tahun_terbit, stok
        // 4. executeUpdate()
        // 5. Close resource
    }

    /**
     * TODO 12: UPDATE – Update stok buku
     *
     * Query: UPDATE buku SET stok = ? WHERE id = ?
     */
    public void updateStok(int id, int newStok) throws SQLException {
        // TODO: PreparedStatement UPDATE
        String sql = "UPDATE buku SET stok = ? WHERE id = ?";
        
        try(
            Connection conn = DatabaseUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)
        ) {
            ps.setInt(1, newStok);
            ps.setInt(2, id);

            ps.executeUpdate();
        }
    }
    /**
     * TODO 13: DELETE – Hapus buku berdasarkan ID
     *
     * Query: DELETE FROM buku WHERE id = ?
     *
     * Return: true jika berhasil hapus 1 row, false jika tidak ada
     */
    public boolean deleteById(int id) throws SQLException {
    // TODO:
    // 1. PreparedStatement DELETE
    // 2. executeUpdate()
    // 3. Return rowsAffected > 0

    String sql = "DELETE FROM buku WHERE id = ?";
    
    try(
        Connection conn = DatabaseUtils.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql)
    ) {
        ps.setInt(1, id);

        int rows = ps.executeUpdate();

        return rows > 0;
        }
    }
}