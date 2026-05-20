package edu.pradita.oop.session11.decorator;

public class ChocolateSyrupDecorator extends IceCreamDecorator {

    public ChocolateSyrupDecorator(IceCream wrappedIceCream) {
        super(wrappedIceCream);
    }

    // TODO D7.1
    // Add ", Chocolate Syrup" to the description.
    @Override
    public String getDescription() {
        return wrappedIceCream.getDescription() + ", Chocolate Syrup";
    }

    // TODO D7.2
    // Add 2500 to the total cost.
    @Override
    public double getCost() {
        return wrappedIceCream.getCost() + 2500;
    }
}