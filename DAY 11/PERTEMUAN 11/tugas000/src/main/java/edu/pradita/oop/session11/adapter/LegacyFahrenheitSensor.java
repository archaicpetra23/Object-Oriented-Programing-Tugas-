package edu.pradita.oop.session11.adapter;

/**
 * Legacy class — already exists and cannot be changed.
 *
 * PROBLEM:
 * The old sensor only knows how to return Fahrenheit.
 * But the new system expects Celsius through TemperatureSensor.
 *
 * This mismatch is exactly why Adapter exists.
 */
public class LegacyFahrenheitSensor {

    // TODO A2.1
    // Return 86.0 as the sample Fahrenheit reading.
    public double getTemperatureInFahrenheit() {
        return 86.0;
    }
}