package edu.pradita.oop.session01;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class HelloStudentTest {

    @Test
    void testConstructorShouldSetName() {
        HelloStudent student = new HelloStudent("Alice");
        assertEquals("Alice", student.getName(), 
            "Constructor harus set name dengan benar!");
    }

    @Test
    void testGreetShouldReturnCorrectFormat() {
        HelloStudent student = new HelloStudent("Bob");
        assertEquals("Hello, Bob!", student.greet(),
            "Method greet() harus return 'Hello, [name]!'");
    }

    @Test
    void testGreetWithDifferentName() {
        HelloStudent student = new HelloStudent("Charlie");
        assertEquals("Hello, Charlie!", student.greet(),
            "Method greet() harus bisa handle nama yang berbeda!");
    }
}
