package edu.pradita.oop.session11.bridge;

/**
 * Refined abstraction.
 *
 * This class adds behavior without changing TV or Radio classes.
 */
public class AdvancedRemoteControl extends RemoteControl {

    public AdvancedRemoteControl(Device device) {
        super(device);
    }

    // TODO B5.1
    // Mute by calling volumeDown() three times.
    public void mute() {
        volumeDown();
        volumeDown();
        volumeDown();
    }
}