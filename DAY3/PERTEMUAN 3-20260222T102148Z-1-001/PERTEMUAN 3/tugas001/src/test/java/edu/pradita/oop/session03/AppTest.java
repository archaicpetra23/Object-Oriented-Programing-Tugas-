package edu.pradita.oop.session03;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class UserRepositoryTest {

    @Test
    void testSaveAssignsId() {
        UserRepository repo = new UserRepository();
        User u = new User("Test");
        User saved = repo.save(u);

        assertNotNull(saved.getId());
        assertEquals("Test", saved.getName());
    }

    @Test
    void testFindAll() {
        UserRepository repo = new UserRepository();
        repo.save(new User("A"));
        repo.save(new User("B"));

        List<User> all = repo.findAll();
        assertEquals(2, all.size());
    }

    @Test
    void testFindById() {
        UserRepository repo = new UserRepository();
        User u1 = repo.save(new User("A"));
        Long id = u1.getId();

        Optional<User> found = repo.findById(id);
        assertTrue(found.isPresent());
        assertEquals("A", found.get().getName());
    }

    @Test
    void testDeleteById() {
        UserRepository repo = new UserRepository();
        User u1 = repo.save(new User("A"));
        Long id = u1.getId();

        boolean deleted = repo.deleteById(id);
        assertTrue(deleted);
        assertTrue(repo.findById(id).isEmpty());
    }
}
