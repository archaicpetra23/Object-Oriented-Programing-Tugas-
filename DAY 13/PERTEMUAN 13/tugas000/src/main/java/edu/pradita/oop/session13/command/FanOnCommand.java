package edu.pradita.oop.session13.command;

/**
 * Concrete command for turning fan on.
 */
public class FanOnCommand implements Command {

    private final Fan fan;

    // TODO C6.1
    // Complete constructor assignment.
    public FanOnCommand(Fan fan) {
        this.fan = fan;
    }

    // TODO C6.2
    // Call fan.turnOn().
    @Override
    public void execute() {
        fan.turnOn();
    }
}