package edu.pradita.oop.session13.interpreter;

/**
 * Terminal expression for /kick.
 */
public class KickExpression implements Expression {

    // TODO I4.1
    // Interpret input like: "/kick Bob"
    // Return: "Kicked user: Bob"
    @Override
    public String interpret(CommandContext context) {
        String[] parts = context.getInput().split(" ");
        return "Kicked user: " + parts[1];
    }
}