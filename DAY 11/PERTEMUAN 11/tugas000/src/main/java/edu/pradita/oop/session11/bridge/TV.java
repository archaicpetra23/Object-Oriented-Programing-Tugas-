package edu.pradita.oop.session11.bridge;

public class TV implements Device {

    private boolean on = false;
    private int volume = 10;

    // TODO B2.1
    // Toggle the TV power.
    @Override
    public void power() {
        on = !on;
    }

    // TODO B2.2
    // Increase volume by 1.
    @Override
    public void volumeUp() {
        volume++;
    }

    // TODO B2.3
    // Decrease volume by 1.
    @Override
    public void volumeDown() {
        volume--;
    }

    // TODO B2.4
    // Return status in format: "TV -> ON, volume: 11"
    @Override
    public String getStatus() {
        return "TV -> " + (on ? "ON" : "OFF") + ", volume: " + volume;
    }
}