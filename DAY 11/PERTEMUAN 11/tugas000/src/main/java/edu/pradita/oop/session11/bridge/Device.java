package edu.pradita.oop.session11.bridge;

/**
 * BRIDGE PATTERN — Implementation interface.
 *
 * The remote control (abstraction) should work with any kind of device,
 * as long as the device supports these operations.
 */
public interface Device {

    // TODO B1.1
    // Declare power(), volumeUp(), volumeDown(), and getStatus().
    void power();

    void volumeUp();

    void volumeDown();

    String getStatus();
}