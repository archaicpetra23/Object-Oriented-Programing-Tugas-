package edu.pradita.oop.session13.interpreter;

/**
 * INTERPRETER PATTERN — Abstract expression.
 *
 * WHY THIS EXISTS:
 * Every command expression should be interpreted through the same method.
 * That lets the parser treat /mute, /kick, and /ban uniformly.
 *
 * DO:   Keep a common interpret() contract for all command expressions.
 * DONT: Put command-specific parsing logic directly into App.java.
 */
public interface Expression {

    // TODO I1.1
    // Declare interpret(CommandContext context).
    // Each concrete expression will read data from the context
    // and return a text result of what command was executed.
    String interpret(CommandContext context);
}