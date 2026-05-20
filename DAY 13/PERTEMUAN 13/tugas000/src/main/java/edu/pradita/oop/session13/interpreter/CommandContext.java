package edu.pradita.oop.session13.interpreter;

/**
 * CommandContext stores the raw command text to be interpreted.
 *
 * EXAMPLE:
 * "/mute Alice"
 * "/kick Bob"
 * "/ban Charlie"
 *
 * The expression objects read the context to decide what to do.
 */
public class CommandContext {

    // TODO I2.1
    // Declare one private final field:
    // input (String)
    private final String input;

    // TODO I2.2
    // Complete the constructor assignment.
    public CommandContext(String input) {
        this.input = input;
    }

    // TODO I2.3
    // Create getInput().
    public String getInput() {
        return input;
    }
}