package edu.pradita.oop.session02;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    @Test
    void testReverseString() {
        App app = new App();
        assertEquals("slooT dliuB", app.reverseString("Build Tools"));
    }

    @Test
    void testCapitalizeWords() {
        App app = new App();
        String result = app.capitalizeWords("hello world from maven");
        assertEquals("Hello World From Maven", result);
    }

    @Test
    void testAbbreviateString() {
        App app = new App();
        String result = app.abbreviateString("This is a very long sentence", 15);
        assertEquals("This is a ve...", result);
    }
}
