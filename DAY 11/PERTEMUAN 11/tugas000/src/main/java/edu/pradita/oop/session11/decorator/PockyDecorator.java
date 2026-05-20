package edu.pradita.oop.session11.decorator;

public class PockyDecorator extends IceCreamDecorator {

    public PockyDecorator(IceCream wrappedIceCream) {
        super(wrappedIceCream);
    }

    // TODO D6.1
    // Add ", Pocky" to the description.
    @Override
    public String getDescription() {
        return wrappedIceCream.getDescription() + ", Pocky";
    }

    // TODO D6.2
    // Add 3000 to the total cost.
    @Override
    public double getCost() {
        return wrappedIceCream.getCost() + 3000;
    }
}