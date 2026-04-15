package edu.pradita.lsp;

public class LockedEquipment extends GymEquipment {
    public LockedEquipment(String name) {
        super(name);
    }

    @Override
    public void release() {
        throw new UnsupportedOperationException(name + " is under maintenance and cannot be released.");
    }
}