package edu.pradita.oop.session13.command;

/**
 * Concrete command for turning light off.
 */
public class LightOffCommand implements Command {

    private final Light light;

    // TODO C5.1
    // Complete constructor assignment.
    public LightOffCommand(Light light) {
        this.light = light;
    }

    // TODO C5.2
    // Call light.turnOff().
    @Override
    public void execute() {
        light.turnOff();
    }
}