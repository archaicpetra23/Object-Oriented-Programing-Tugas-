package edu.pradita.oop.session13;

import edu.pradita.oop.session13.command.*;
import edu.pradita.oop.session13.interpreter.*;
import edu.pradita.oop.session13.observer.*;
import edu.pradita.oop.session13.strategy.*;

public class App {

    public static void main(String[] args) {

        System.out.println("=== INTERPRETER ===");

        // TODO APP1
        // Parse "/mute Alice", interpret it, and print the result.
        CommandParser parser = new CommandParser();
        CommandContext context = new CommandContext("/mute Alice");
        Expression expression = parser.parse(context.getInput());
        System.out.println(expression.interpret(context));

        System.out.println();
        System.out.println("=== OBSERVER ===");

        // TODO APP2
        // Create one channel and two subscribers.
        // Subscribe both users, then upload one video.
        Channel channel = new Channel("PraditaChannel");
        UserSubscriber user1 = new UserSubscriber("Alice");
        UserSubscriber user2 = new UserSubscriber("Bob");
        channel.subscribe(user1);
        channel.subscribe(user2);
        channel.uploadVideo("OOP Observer Pattern");

        System.out.println();
        System.out.println("=== STRATEGY ===");

        // TODO APP3
        // Create ShippingCalculator with RegularShipping.
        // Calculate cost for weight 2.5 and print it.
        ShippingCalculator calculator = new ShippingCalculator(new RegularShipping());
        System.out.println(calculator.calculateCost(2.5));

        // TODO APP4
        // Change strategy to SameDayShipping and calculate again.
        calculator.setStrategy(new SameDayShipping());
        System.out.println(calculator.calculateCost(2.5));

        System.out.println();
        System.out.println("=== COMMAND ===");

        // TODO APP5
        // Create Light, Fan, SmartRemote.
        // Press one light-on command and one fan-on command.
        Light light = new Light();
        Fan fan = new Fan();
        SmartRemote remote = new SmartRemote();

        remote.setCommand(new LightOnCommand(light));
        remote.pressButton();

        remote.setCommand(new FanOnCommand(fan));
        remote.pressButton();
    }
}