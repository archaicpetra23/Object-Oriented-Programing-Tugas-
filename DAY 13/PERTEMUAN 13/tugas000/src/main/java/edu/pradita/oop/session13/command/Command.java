package edu.pradita.oop.session13.command;

/**
 * COMMAND PATTERN — Command interface.
 *
 * Every button press on the remote should be represented
 * as a command object with one execute() method.
 */
public interface Command {

    // TODO C1.1
    // Declare execute().
    void execute();
}