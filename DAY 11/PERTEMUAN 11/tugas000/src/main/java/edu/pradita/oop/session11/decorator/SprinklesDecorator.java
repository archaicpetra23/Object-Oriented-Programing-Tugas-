package edu.pradita.oop.session11.decorator;

public class SprinklesDecorator extends IceCreamDecorator {

    public SprinklesDecorator(IceCream wrappedIceCream) {
        super(wrappedIceCream);
    }

    // TODO D5.1
    // Add ", Sprinkles" to the description.
    @Override
    public String getDescription() {
        return wrappedIceCream.getDescription() + ", Sprinkles";
    }

    // TODO D5.2
    // Add 1500 to the total cost.
    @Override
    public double getCost() {
        return wrappedIceCream.getCost() + 1500;
    }
}