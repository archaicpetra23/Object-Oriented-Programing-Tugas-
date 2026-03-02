package edu.pradita.oop.session03;

/**
 * TUGAS 001 – Simulasi ORM: Entity User
 *
 * Mirip konsep JPA @Entity, tapi tanpa anotasi dulu.
 */
public class User {

    private Long id;       // simulasi primary key
    private String name;   // nama user

    // Constructor tanpa parameter (default)
    public User() {
        // kosong
    }

    // Constructor dengan parameter name
    public User(String name) {
        this.name = name;
    }

    // Getter & Setter untuk id dan name

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
       return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}