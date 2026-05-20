package edu.pradita.oop.session11.adapter;

/**
 * Concrete adapter.
 *
 * JOB:
 * Make LegacyFahrenheitSensor look like a TemperatureSensor.
 *
 * FORMULA:
 * Celsius = (Fahrenheit - 32) * 5 / 9
 */
public class FahrenheitToCelsiusAdapter implements TemperatureSensor {

    // TODO A3.1
    // Store the adaptee (legacy sensor) in a private final field.
    private final LegacyFahrenheitSensor legacySensor;

    // TODO A3.2
    // Complete constructor assignment.
    public FahrenheitToCelsiusAdapter(LegacyFahrenheitSensor legacySensor) {
        this.legacySensor = legacySensor;
    }

    // TODO A3.3
    // Read Fahrenheit from legacySensor, convert it to Celsius, then return it.
    // Formula: (fahrenheit - 32) * 5 / 9
    @Override
    public double getTemperatureInCelsius() {
        double fahrenheit = legacySensor.getTemperatureInFahrenheit();
        return (fahrenheit - 32) * 5 / 9;
    }
}