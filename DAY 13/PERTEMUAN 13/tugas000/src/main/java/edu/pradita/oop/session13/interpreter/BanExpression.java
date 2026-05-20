package edu.pradita.oop.session13.interpreter;

/**
 * Terminal expression for /ban.
 */
public class BanExpression implements Expression {

    // TODO I5.1
    // Interpret input like: "/ban Charlie"
    // Return: "Banned user: Charlie"
    @Override
    public String interpret(CommandContext context) {
        String[] parts = context.getInput().split(" ");
        return "Banned user: " + parts[1];
    }
}