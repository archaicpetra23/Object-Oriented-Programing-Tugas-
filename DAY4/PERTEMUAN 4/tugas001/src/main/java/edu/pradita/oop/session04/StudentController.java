package edu.pradita.oop.session04;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * TUGAS001 - MVC CRUD Mahasiswa
 * ================================
 * CONTROLLER: Mengelola logika dan data mahasiswa.
 *
 * Berperan sebagai "jembatan" antara Model (Student)
 * dan View (App.java / JavaFX UI).
 *
 * Simulasi database menggunakan ObservableList (in-memory).
 */
public class StudentController {
    private final ObservableList<Student> students =
    FXCollections.observableArrayList();

    // TODO 8: Deklarasi ObservableList<Student> sebagai "tabel" in-memory
    //         Gunakan FXCollections.observableArrayList()
    //         private final ObservableList<Student> students = ...;

    /**
     * TODO 9: Implementasikan getStudents()
     * Return seluruh data mahasiswa (dipakai langsung oleh TableView).
     *
     * @return ObservableList<Student>
     */
    public ObservableList<Student> getStudents() {
        // TODO: implement
        return students;
    }

    /**
     * TODO 10: Implementasikan addStudent()
     *
     * Aturan validasi:
     * - nim harus > 0
     * - name tidak boleh null atau kosong (isBlank)
     * - major tidak boleh null atau kosong (isBlank)
     * - Jika salah satu tidak valid → throw IllegalArgumentException
     *   dengan pesan: "NIM harus > 0 dan Nama/Prodi tidak boleh kosong"
     * - Jika valid → buat object Student baru dan tambahkan ke list
     *
     * @param nim   nomor induk mahasiswa (int)
     * @param name  nama mahasiswa
     * @param major program studi
     */
    public void addStudent(int nim, String name, String major) {
        // TODO: implement validasi dan add ke list
        if (nim <= 0 || name == null || name.isBlank()
            || major == null || major.isBlank() ) {

                throw new IllegalArgumentException(
                    "NIM harus > 0 dan Nama/Prodi tida bleh kosong "
                );
        }
    Student student = new Student(nim, name, major);
    students.add(student);
    }

    /**
     * TODO 11: Implementasikan removeStudent()
     *
     * Hapus object Student dari list.
     * Gunakan: students.remove(student)
     *
     * @param student object yang ingin dihapus
     */
    public void removeStudent(Student student) {
        // TODO: implement
        students.remove(student);
    }

    /**
     * TODO 12: Implementasikan clearAll()
     *
     * Hapus semua data mahasiswa dari list.
     * Gunakan: students.clear()
     */
    public void clearAll() {
        // TODO: implement
        students.clear();
    }

    /**
     * TODO 13 (Opsional): Implementasikan findByNim()
     *
     * Cari mahasiswa berdasarkan nim.
     * - Loop students, cari yang nim-nya cocok
     * - Jika ketemu → return Student tersebut
     * - Jika tidak → return null
     *
     * @param nim nomor induk yang dicari
     * @return Student atau null
     */
    public Student findByNim(int nim) {
        // TODO: implement (opsional)
        for (Student student : students) {
            if (student.getNim() == nim) {
                return student;
            }
        }
        return null;
    }
}
