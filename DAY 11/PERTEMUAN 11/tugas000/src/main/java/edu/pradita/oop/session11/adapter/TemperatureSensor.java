package edu.pradita.oop.session11.adapter;

/**
 * ADAPTER PATTERN — Target interface.
 *
 * This is the interface expected by the modern monitoring system.
 * The client wants every sensor to provide temperature in Celsius.
 */
public interface TemperatureSensor {

    // TODO A1.1
    // Declare getTemperatureInCelsius().
    double getTemperatureInCelsius();
}