package edu.pradita.oop.session03;

import java.util.List;
import java.util.Optional;

/**
 * Demo sederhana penggunaan UserRepository.
 * Mahasiswa bisa lihat alur "mirip ORM" tanpa DB.
 */
public class App {

    public static void main(String[] args) {
        System.out.println("=== TUGAS 001: Simulasi ORM UserRepository ===");

        UserRepository repo = new UserRepository();

        // Simulasi INSERT
        User u1 = new User("Alice");
        User u2 = new User("Bob");
        User u3 = new User("Charlie");

        repo.save(u1);
        repo.save(u2);
        repo.save(u3);

        // Simulasi SELECT *
        List<User> all = repo.findAll();
        System.out.println("Semua user:");
        for (User u : all) {
            System.out.println(u);
        }

        // Simulasi SELECT WHERE id = 2
        System.out.println("\nCari user dengan id = 2:");
        Optional<User> maybeUser = repo.findById(2L);
        maybeUser.ifPresentOrElse(
            user -> System.out.println("Ditemukan: " + user),
            () -> System.out.println("Tidak ditemukan")
        );

        // Simulasi DELETE
        System.out.println("\nHapus user dengan id = 1:");
        boolean deleted = repo.deleteById(1L);
        System.out.println("Berhasil dihapus? " + deleted);

        System.out.println("\nUser setelah dihapus:");
        for (User u : repo.findAll()) {
            System.out.println(u);
        }
    }
}
