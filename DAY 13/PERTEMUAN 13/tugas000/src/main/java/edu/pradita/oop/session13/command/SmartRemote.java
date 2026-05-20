package edu.pradita.oop.session13.command;

/**
 * Invoker class.
 *
 * WHY THIS CLASS?
 * The remote should not know the details of Light or Fan.
 * It only stores a Command and executes it.
 */
public class SmartRemote {

    private Command slot;

    // TODO C8.1
    // Implement setCommand(Command command).
    public void setCommand(Command command) {
        this.slot = command;
    }

    // TODO C8.2
    // Implement pressButton().
    // Call execute() on the current slot command.
    public void pressButton() {
        slot.execute();
    }
}