package edu.pradita.oop.session05;

// ko ken aku gatau disini harus di ganti atau gausah tapi mvn test baru jalan 
// kalo kode di sini aku ganti jadi begini
// https://chatgpt.com/s/t_69aa2f1b30888191a80c0e94ff8b4ae5

/**
 * TUGAS001 – CRUD Buku
 * Model Buku untuk representasi data dari table `buku`
 */
public class Buku {

    private int id;
    private String judul;
    private String penulis;
    private int tahunTerbit;
    private int stok;

    // Constructor kosong
    public Buku() {}

    // Constructor lengkap
    public Buku(int id, String judul, String penulis, int tahunTerbit, int stok) {
        this.id = id;
        this.judul = judul;
        this.penulis = penulis;
        this.tahunTerbit = tahunTerbit;
        this.stok = stok;
    }

    // Getter & Setter id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Getter & Setter judul
    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    // Getter & Setter penulis
    public String getPenulis() {
        return penulis;
    }

    public void setPenulis(String penulis) {
        this.penulis = penulis;
    }

    // Getter & Setter tahunTerbit
    public int getTahunTerbit() {
        return tahunTerbit;
    }

    public void setTahunTerbit(int tahunTerbit) {
        this.tahunTerbit = tahunTerbit;
    }

    // Getter & Setter stok
    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    // toString()
    @Override
    public String toString() {
        return "Buku{id=" + id +
            ", judul='" + judul + '\'' +
            ", penulis='" + penulis + '\'' +
            ", tahun=" + tahunTerbit +
            ", stok=" + stok +
            '}';
    }
}

// ko ken aku gatau disini harus di ganti atau gausah tapi mvn test  baru jalan kalo kode di sini aku ganti jadi begini