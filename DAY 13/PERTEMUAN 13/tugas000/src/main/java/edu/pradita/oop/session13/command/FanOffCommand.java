package edu.pradita.oop.session13.command;

/**
 * Concrete command for turning fan off.
 */
public class FanOffCommand implements Command {

    private final Fan fan;

    // TODO C7.1
    // Complete constructor assignment.
    public FanOffCommand(Fan fan) {
        this.fan = fan;
    }

    // TODO C7.2
    // Call fan.turnOff().
    @Override
    public void execute() {
        fan.turnOff();
    }
}