package edu.pradita.oop.session13.interpreter;

/**
 * Parser / dispatcher for tiny chat commands.
 *
 * WHY THIS CLASS?
 * Without it, App.java would become a growing if/else parser.
 * This class decides which expression object should interpret the input.
 *
 * DO: Return the proper expression based on the command prefix.
 * DONT: Hardcode execution logic directly in main().
 */
public class CommandParser {

    // TODO I6.1
    // Implement parse(String input).
    //
    // Rules:
    // - if input startsWith "/mute" -> return new MuteExpression()
    // - if input startsWith "/kick" -> return new KickExpression()
    // - if input startsWith "/ban" -> return new BanExpression()
    // - otherwise throw IllegalArgumentException("Unknown command")
    public Expression parse(String input) {
        if (input.startsWith("/mute")) {
            return new MuteExpression();
        } else if (input.startsWith("/kick")) {
            return new KickExpression();
        } else if (input.startsWith("/ban")) {
            return new BanExpression();
        }
        throw new IllegalArgumentException("Unknown command");
    }
}