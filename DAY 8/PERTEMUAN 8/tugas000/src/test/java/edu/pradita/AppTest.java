package edu.pradita;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AppTest {

    private final PrintStream originalOut = System.out;
    private ByteArrayOutputStream outContent;

    @BeforeEach
    void setUp() {
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    void shouldShowRefactoredSRP() {
        App.main(new String[0]);
        String output = outContent.toString();

        assertTrue(output.contains("[SRP] Member registered: Alice"));
        assertTrue(output.contains("[SRP] Printing member: Alice"));
        assertTrue(output.contains("[SRP] Saving member: Alice"));
    }

    @Test
    void shouldShowRefactoredOCP() {
        App.main(new String[0]);
        String output = outContent.toString();

        assertTrue(output.contains("[OCP] Starting Yoga session"));
        assertTrue(output.contains("[OCP] Starting Cardio session"));
        assertTrue(output.contains("[OCP] Starting Spinning session"));
    }

    @Test
    void shouldShowRefactoredLSP() {
        App.main(new String[0]);
        String output = outContent.toString();

        assertTrue(output.contains("[LSP] Treadmill is now available"));
        assertTrue(output.contains("[LSP] Locked equipment: Barbell Rack"));
    }

    @Test
    void shouldShowRefactoredISP() {
        App.main(new String[0]);
        String output = outContent.toString();

        assertTrue(output.contains("[ISP] Bob booked class: Yoga"));
    }

    @Test
    void shouldShowRefactoredDIP() {
        App.main(new String[0]);
        String output = outContent.toString();

        assertTrue(output.contains("[DIP] Weight training plan for Alice"));
        assertTrue(output.contains("[DIP] Cardio training plan for Bob"));
    }
}