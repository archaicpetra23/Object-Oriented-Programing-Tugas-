package edu.pradita.oop.session04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentControllerTest {

    @Test
    void testAddStudent() {
        StudentController controller = new StudentController();
        controller.addStudent(12345, "Budi", "Informatika");

        assertEquals(1, controller.getStudents().size());
        assertEquals(12345, controller.getStudents().get(0).getNim());
        assertEquals("Budi", controller.getStudents().get(0).getName());
        assertEquals("Informatika", controller.getStudents().get(0).getMajor());
    }

    @Test
    void testAddStudentInvalidNim() {
        StudentController controller = new StudentController();
        assertThrows(IllegalArgumentException.class,
                () -> controller.addStudent(0, "Budi", "Informatika"),
                "NIM 0 harus throw IllegalArgumentException");

        assertThrows(IllegalArgumentException.class,
                () -> controller.addStudent(-1, "Budi", "Informatika"),
                "NIM negatif harus throw IllegalArgumentException");
    }

    @Test
    void testAddStudentInvalidName() {
        StudentController controller = new StudentController();
        assertThrows(IllegalArgumentException.class,
                () -> controller.addStudent(12345, "", "Informatika"),
                "Nama kosong harus throw IllegalArgumentException");

        assertThrows(IllegalArgumentException.class,
                () -> controller.addStudent(12345, "  ", "Informatika"),
                "Nama spasi harus throw IllegalArgumentException");
    }

    @Test
    void testAddStudentInvalidMajor() {
        StudentController controller = new StudentController();
        assertThrows(IllegalArgumentException.class,
                () -> controller.addStudent(12345, "Budi", ""),
                "Prodi kosong harus throw IllegalArgumentException");
    }

    @Test
    void testRemoveStudent() {
        StudentController controller = new StudentController();
        controller.addStudent(12345, "Budi", "Informatika");
        Student s = controller.getStudents().get(0);

        controller.removeStudent(s);
        assertTrue(controller.getStudents().isEmpty());
    }

    @Test
    void testClearAll() {
        StudentController controller = new StudentController();
        controller.addStudent(111, "A", "Informatika");
        controller.addStudent(222, "B", "Sistem Informasi");
        controller.addStudent(333, "C", "Teknik Elektro");

        controller.clearAll();
        assertEquals(0, controller.getStudents().size());
    }

    @Test
    void testFindByNim() {
        StudentController controller = new StudentController();
        controller.addStudent(12345, "Budi", "Informatika");
        controller.addStudent(67890, "Siti", "Sistem Informasi");

        Student found = controller.findByNim(67890);
        assertNotNull(found);
        assertEquals("Siti", found.getName());

        Student notFound = controller.findByNim(99999);
        assertNull(notFound);
    }
}
