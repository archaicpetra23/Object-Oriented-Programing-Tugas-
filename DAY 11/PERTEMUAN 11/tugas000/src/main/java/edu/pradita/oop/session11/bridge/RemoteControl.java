package edu.pradita.oop.session11.bridge;

/**
 * Abstraction side of Bridge.
 *
 * WHY BRIDGE?
 * We separate:
 * - abstraction: RemoteControl, AdvancedRemoteControl
 * - implementation: TV, Radio
 *
 * This avoids class explosion like:
 * TVBasicRemote, TVAdvancedRemote, RadioBasicRemote, RadioAdvancedRemote
 */
public class RemoteControl {

    // TODO B4.1
    // Store Device in a protected final field.
    protected final Device device;

    // TODO B4.2
    // Complete constructor assignment.
    public RemoteControl(Device device) {
        this.device = device;
    }

    // TODO B4.3
    // Delegate these methods to the device.
    public void togglePower() {
        device.power();
    }

    public void volumeUp() {
        device.volumeUp();
    }

    public void volumeDown() {
        device.volumeDown();
    }

    public String getStatus() {
        return device.getStatus();
    }
}