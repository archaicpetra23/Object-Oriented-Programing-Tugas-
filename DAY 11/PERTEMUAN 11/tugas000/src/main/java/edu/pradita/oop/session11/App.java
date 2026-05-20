package edu.pradita.oop.session11;

import edu.pradita.oop.session11.decorator.*;
import edu.pradita.oop.session11.adapter.*;
import edu.pradita.oop.session11.bridge.*;

public class App {

    public static void main(String[] args) {

        System.out.println("=== DECORATOR: ICE CREAM TOPPINGS ===");

        // TODO APP1
        // Build this order step by step using decorators:
        // Vanilla Ice Cream + Wafer + Sprinkles + Chocolate Syrup
        IceCream order1 = new VanillaIceCream();
        order1 = new WaferDecorator(order1);
        order1 = new SprinklesDecorator(order1);
        order1 = new ChocolateSyrupDecorator(order1);
        System.out.println(order1.getDescription());
        System.out.println(order1.getCost());

        System.out.println();
        System.out.println("=== ADAPTER: LEGACY SENSOR ===");

        // TODO APP2
        // Wrap LegacyFahrenheitSensor so WeatherMonitor can read Celsius.
        LegacyFahrenheitSensor legacy = new LegacyFahrenheitSensor();
        TemperatureSensor adapter = new FahrenheitToCelsiusAdapter(legacy);
        WeatherMonitor monitor = new WeatherMonitor();
        System.out.println(monitor.readTemperature(adapter));

        System.out.println();
        System.out.println("=== BRIDGE: REMOTE CONTROL ===");

        // TODO APP3
        // Create an AdvancedRemoteControl for a TV.
        // Turn it on, increase volume once, mute it, then print status.
        Device tv = new TV();
        AdvancedRemoteControl remote = new AdvancedRemoteControl(tv);
        remote.togglePower();
        remote.volumeUp();
        remote.mute();
        System.out.println(remote.getStatus());
    }
}