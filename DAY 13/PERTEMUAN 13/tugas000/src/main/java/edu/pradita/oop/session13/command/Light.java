package edu.pradita.oop.session13.command;

/**
 * Receiver class.
 *
 * The Light knows how to perform the actual action.
 * The command object will call these methods.
 */
public class Light {

    // TODO C2.1
    // Implement turnOn().
    // Print: "Light is ON"
    public void turnOn() {
        System.out.println("Light is ON");
    }

    // TODO C2.2
    // Implement turnOff().
    // Print: "Light is OFF"
    public void turnOff() {
        System.out.println("Light is OFF");
    }
}