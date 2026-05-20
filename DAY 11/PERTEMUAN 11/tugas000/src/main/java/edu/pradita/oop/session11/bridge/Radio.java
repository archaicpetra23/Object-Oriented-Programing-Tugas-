package edu.pradita.oop.session11.bridge;

public class Radio implements Device {

    private boolean on = false;
    private int volume = 5;

    @Override
    public void power() {
        on = !on;
    }

    // TODO B3.1
    // Increase volume by 1.
    @Override
    public void volumeUp() {
        volume++;
    }

    // TODO B3.2
    // Decrease volume by 1.
    @Override
    public void volumeDown() {
        volume--;
    }

    // TODO B3.3
    // Return status in format: "Radio -> ON, volume: 6"
    @Override
    public String getStatus() {
        return "Radio -> " + (on ? "ON" : "OFF") + ", volume: " + volume;
    }
}