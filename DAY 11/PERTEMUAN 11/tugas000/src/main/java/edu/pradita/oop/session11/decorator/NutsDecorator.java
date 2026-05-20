package edu.pradita.oop.session11.decorator;

public class NutsDecorator extends IceCreamDecorator {

    public NutsDecorator(IceCream wrappedIceCream) {
        super(wrappedIceCream);
    }

    // TODO D9.1
    // Add ", Nuts" to the description.
    @Override
    public String getDescription() {
        return wrappedIceCream.getDescription() + ", Nuts";
    }

    // TODO D9.2
    // Add 2000 to the total cost.
    @Override
    public double getCost() {
        return wrappedIceCream.getCost() + 2000;
    }
}