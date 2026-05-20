package edu.pradita.oop.session11.adapter;

/**
 * Client class.
 *
 * IMPORTANT:
 * WeatherMonitor depends only on TemperatureSensor.
 * It does NOT know or care whether the real object is a modern sensor
 * or a legacy one hidden behind an adapter.
 */
public class WeatherMonitor {

    // TODO A4.1
    // Complete method to read temperature from the interface.
    public double readTemperature(TemperatureSensor sensor) {
        return sensor.getTemperatureInCelsius();
    }
}