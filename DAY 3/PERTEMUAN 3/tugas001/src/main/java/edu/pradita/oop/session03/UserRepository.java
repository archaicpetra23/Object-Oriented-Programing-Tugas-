package edu.pradita.oop.session03;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * TUGAS 001 – Simulasi ORM: UserRepository
 */
public class UserRepository {

    // Simulasi database: List sebagai "tabel"
    private final List<User> users = new ArrayList<>();
    private long nextId = 1L;   // auto-increment id

    /**
     * Simulasi INSERT
     */
    public User save(User user) {

        // Jika id masih null → anggap data baru (INSERT)
        if (user.getId() == null) {
            user.setId(nextId);
            nextId++;
            users.add(user);
        }

        return user;
    }

    /**
     * Simulasi SELECT * FROM users
     */
    public List<User> findAll() {
        return users;
    }

    /**
     * Simulasi SELECT ... WHERE id = ?
     */
    public Optional<User> findById(Long id) {

        for (User user : users) {
            if (user.getId().equals(id)) {
                return Optional.of(user);
            }
        }

        return Optional.empty();
    }

    /**
     * Simulasi DELETE FROM users WHERE id = ?
     */
    public boolean deleteById(Long id) {

        for (User user : users) {
            if (user.getId().equals(id)) {
                users.remove(user);
                return true;
            }
        }

        return false;
    }

    /**
     * Query custom: cari berdasarkan name
     */
    public List<User> findByName(String name) {
        List<User> result = new ArrayList<>();

        for (User user : users) {
            if (user.getName().equals(name)) {
                result.add(user);
            }
        }

        return result;
    }
}