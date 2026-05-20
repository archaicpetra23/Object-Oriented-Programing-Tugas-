package edu.pradita.oop.session13;

import edu.pradita.oop.session13.command.*;
import edu.pradita.oop.session13.interpreter.*;
import edu.pradita.oop.session13.observer.*;
import edu.pradita.oop.session13.strategy.*;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class Session13Test {

    // ══════════════════════════════════════════════════════════════════
    // INTERPRETER TESTS
    // Checks command parsing and interpretation results.
    // ══════════════════════════════════════════════════════════════════

    @Test
    void commandContextShouldStoreInput() {
        CommandContext context = new CommandContext("/mute Alice");
        assertEquals("/mute Alice", context.getInput());
    }

    @Test
    void parserShouldReturnMuteExpression() {
        CommandParser parser = new CommandParser();
        Expression expression = parser.parse("/mute Alice");
        assertTrue(expression instanceof MuteExpression);
    }

    @Test
    void parserShouldReturnKickExpression() {
        CommandParser parser = new CommandParser();
        Expression expression = parser.parse("/kick Bob");
        assertTrue(expression instanceof KickExpression);
    }

    @Test
    void parserShouldReturnBanExpression() {
        CommandParser parser = new CommandParser();
        Expression expression = parser.parse("/ban Charlie");
        assertTrue(expression instanceof BanExpression);
    }

    @Test
    void parserShouldThrowForUnknownCommand() {
        CommandParser parser = new CommandParser();
        assertThrows(IllegalArgumentException.class, () -> parser.parse("/dance Alice"));
    }

    @Test
    void muteExpressionShouldInterpretCorrectly() {
        Expression expression = new MuteExpression();
        CommandContext context = new CommandContext("/mute Alice");
        assertEquals("Muted user: Alice", expression.interpret(context));
    }

    @Test
    void kickExpressionShouldInterpretCorrectly() {
        Expression expression = new KickExpression();
        CommandContext context = new CommandContext("/kick Bob");
        assertEquals("Kicked user: Bob", expression.interpret(context));
    }

    @Test
    void banExpressionShouldInterpretCorrectly() {
        Expression expression = new BanExpression();
        CommandContext context = new CommandContext("/ban Charlie");
        assertEquals("Banned user: Charlie", expression.interpret(context));
    }

    // ══════════════════════════════════════════════════════════════════
    // OBSERVER TESTS
    // Checks subscribe, unsubscribe, and notification flow.
    // ══════════════════════════════════════════════════════════════════

    @Test
    void channelShouldStoreName() {
        Channel channel = new Channel("PraditaChannel");
        assertEquals("PraditaChannel", channel.getName());
    }

    @Test
    void subscriberShouldStoreUsername() {
        UserSubscriber user = new UserSubscriber("Alice");
        assertEquals("Alice", user.getUsername());
    }

    @Test
    void uploadVideoShouldNotifySubscriber() {
        Channel channel = new Channel("PraditaChannel");
        UserSubscriber user = new UserSubscriber("Alice");

        channel.subscribe(user);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream original = System.out;
        System.setOut(new PrintStream(out));

        channel.uploadVideo("OOP Observer Pattern");

        System.setOut(original);

        String result = out.toString();
        assertTrue(result.contains("Alice got notified"));
        assertTrue(result.contains("PraditaChannel"));
        assertTrue(result.contains("OOP Observer Pattern"));
    }

    @Test
    void uploadVideoShouldNotifyMultipleSubscribers() {
        Channel channel = new Channel("PraditaChannel");
        UserSubscriber user1 = new UserSubscriber("Alice");
        UserSubscriber user2 = new UserSubscriber("Bob");

        channel.subscribe(user1);
        channel.subscribe(user2);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream original = System.out;
        System.setOut(new PrintStream(out));

        channel.uploadVideo("New Design Pattern Video");

        System.setOut(original);

        String result = out.toString();
        assertTrue(result.contains("Alice got notified"));
        assertTrue(result.contains("Bob got notified"));
    }

    @Test
    void unsubscribeShouldStopNotifications() {
        Channel channel = new Channel("PraditaChannel");
        UserSubscriber user1 = new UserSubscriber("Alice");
        UserSubscriber user2 = new UserSubscriber("Bob");

        channel.subscribe(user1);
        channel.subscribe(user2);
        channel.unsubscribe(user2);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream original = System.out;
        System.setOut(new PrintStream(out));

        channel.uploadVideo("Observer Testing");

        System.setOut(original);

        String result = out.toString();
        assertTrue(result.contains("Alice got notified"));
        assertFalse(result.contains("Bob got notified"));
    }

    // ══════════════════════════════════════════════════════════════════
    // STRATEGY TESTS
    // Checks each shipping formula and runtime strategy switching.
    // ══════════════════════════════════════════════════════════════════

    @Test
    void regularShippingShouldCalculateCorrectly() {
        ShippingStrategy strategy = new RegularShipping();
        assertEquals(15000.0, strategy.calculate(2.5));
    }

    @Test
    void expressShippingShouldCalculateCorrectly() {
        ShippingStrategy strategy = new ExpressShipping();
        assertEquals(28750.0, strategy.calculate(2.5));
    }

    @Test
    void sameDayShippingShouldCalculateCorrectly() {
        ShippingStrategy strategy = new SameDayShipping();
        assertEquals(62500.0, strategy.calculate(2.5));
    }

    @Test
    void calculatorShouldUseInitialStrategy() {
        ShippingCalculator calculator = new ShippingCalculator(new RegularShipping());
        assertEquals(15000.0, calculator.calculateCost(2.5));
    }

    @Test
    void calculatorShouldSwitchStrategyAtRuntime() {
        ShippingCalculator calculator = new ShippingCalculator(new RegularShipping());
        assertEquals(15000.0, calculator.calculateCost(2.5));

        calculator.setStrategy(new SameDayShipping());
        assertEquals(62500.0, calculator.calculateCost(2.5));
    }

    @Test
    void calculatorShouldWorkWithExpressStrategy() {
        ShippingCalculator calculator = new ShippingCalculator(new ExpressShipping());
        assertEquals(27000.0, calculator.calculateCost(2.0));
    }

    // ══════════════════════════════════════════════════════════════════
    // COMMAND TESTS
    // Checks receiver output, command delegation, and remote execution.
    // ══════════════════════════════════════════════════════════════════

    @Test
    void lightShouldTurnOn() {
        Light light = new Light();

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream original = System.out;
        System.setOut(new PrintStream(out));

        light.turnOn();

        System.setOut(original);

        assertTrue(out.toString().contains("Light is ON"));
    }

    @Test
    void lightShouldTurnOff() {
        Light light = new Light();

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream original = System.out;
        System.setOut(new PrintStream(out));

        light.turnOff();

        System.setOut(original);

        assertTrue(out.toString().contains("Light is OFF"));
    }

    @Test
    void fanShouldTurnOn() {
        Fan fan = new Fan();

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream original = System.out;
        System.setOut(new PrintStream(out));

        fan.turnOn();

        System.setOut(original);

        assertTrue(out.toString().contains("Fan is ON"));
    }

    @Test
    void fanShouldTurnOff() {
        Fan fan = new Fan();

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream original = System.out;
        System.setOut(new PrintStream(out));

        fan.turnOff();

        System.setOut(original);

        assertTrue(out.toString().contains("Fan is OFF"));
    }

    @Test
    void lightOnCommandShouldExecuteReceiverAction() {
        Light light = new Light();
        Command command = new LightOnCommand(light);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream original = System.out;
        System.setOut(new PrintStream(out));

        command.execute();

        System.setOut(original);

        assertTrue(out.toString().contains("Light is ON"));
    }

    @Test
    void lightOffCommandShouldExecuteReceiverAction() {
        Light light = new Light();
        Command command = new LightOffCommand(light);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream original = System.out;
        System.setOut(new PrintStream(out));

        command.execute();

        System.setOut(original);

        assertTrue(out.toString().contains("Light is OFF"));
    }

    @Test
    void fanOnCommandShouldExecuteReceiverAction() {
        Fan fan = new Fan();
        Command command = new FanOnCommand(fan);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream original = System.out;
        System.setOut(new PrintStream(out));

        command.execute();

        System.setOut(original);

        assertTrue(out.toString().contains("Fan is ON"));
    }

    @Test
    void fanOffCommandShouldExecuteReceiverAction() {
        Fan fan = new Fan();
        Command command = new FanOffCommand(fan);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream original = System.out;
        System.setOut(new PrintStream(out));

        command.execute();

        System.setOut(original);

        assertTrue(out.toString().contains("Fan is OFF"));
    }

    @Test
    void smartRemoteShouldExecuteAssignedCommand() {
        Light light = new Light();
        SmartRemote remote = new SmartRemote();
        remote.setCommand(new LightOnCommand(light));

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream original = System.out;
        System.setOut(new PrintStream(out));

        remote.pressButton();

        System.setOut(original);

        assertTrue(out.toString().contains("Light is ON"));
    }

    @Test
    void smartRemoteShouldAllowCommandReplacement() {
        Light light = new Light();
        Fan fan = new Fan();
        SmartRemote remote = new SmartRemote();

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream original = System.out;
        System.setOut(new PrintStream(out));

        remote.setCommand(new LightOnCommand(light));
        remote.pressButton();

        remote.setCommand(new FanOnCommand(fan));
        remote.pressButton();

        System.setOut(original);

        String result = out.toString();
        assertTrue(result.contains("Light is ON"));
        assertTrue(result.contains("Fan is ON"));
    }
}