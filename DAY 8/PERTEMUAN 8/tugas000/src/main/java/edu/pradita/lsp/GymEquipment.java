package edu.pradita.lsp;

public class GymEquipment {
    protected String name;
    protected boolean inUse;

    public GymEquipment(String name) {
        this.name = name;
        this.inUse = false;
    }

    public void reserve() {
        inUse = true;
        System.out.println(name + " has been reserved.");
    }

    public void release() {
        inUse = false;
        System.out.println(name + " is now available.");
    }

    public boolean isInUse() {
        return inUse;
    }
}