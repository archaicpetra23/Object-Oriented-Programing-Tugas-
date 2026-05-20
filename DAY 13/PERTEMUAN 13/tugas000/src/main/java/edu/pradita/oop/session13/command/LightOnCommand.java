package edu.pradita.oop.session13.command;

/**
 * Concrete command for turning light on.
 */
public class LightOnCommand implements Command {

    private final Light light;

    // TODO C4.1
    // Complete constructor assignment.
    public LightOnCommand(Light light) {
        this.light = light;
    }

    // TODO C4.2
    // Call light.turnOn().
    @Override
    public void execute() {
        light.turnOn();
    }
}