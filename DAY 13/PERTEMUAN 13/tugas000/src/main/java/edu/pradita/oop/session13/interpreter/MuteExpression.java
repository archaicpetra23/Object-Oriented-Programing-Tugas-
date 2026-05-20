package edu.pradita.oop.session13.interpreter;

/**
 * Terminal expression for /mute.
 */
public class MuteExpression implements Expression {

    // TODO I3.1
    // Interpret input like: "/mute Alice"
    // Split by space and return: "Muted user: Alice"
    @Override
    public String interpret(CommandContext context) {
        String[] parts = context.getInput().split(" ");
        return "Muted user: " + parts[1];
    }
}