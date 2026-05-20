package edu.pradita.oop.session11.decorator;

public class FruitsDecorator extends IceCreamDecorator {

    public FruitsDecorator(IceCream wrappedIceCream) {
        super(wrappedIceCream);
    }

    // TODO D8.1
    // Add ", Fruits" to the description.
    @Override
    public String getDescription() {
        return wrappedIceCream.getDescription() + ", Fruits";
    }

    // TODO D8.2
    // Add 3500 to the total cost.
    @Override
    public double getCost() {
        return wrappedIceCream.getCost() + 3500;
    }
}