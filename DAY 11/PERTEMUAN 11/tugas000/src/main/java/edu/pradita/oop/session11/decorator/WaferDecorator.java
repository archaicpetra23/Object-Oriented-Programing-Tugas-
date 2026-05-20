package edu.pradita.oop.session11.decorator;

/**
 * Concrete decorator — adds wafer topping.
 *
 * INTUITION:
 * A decorator does not replace the original object.
 * It wraps it, then adds a little more behavior.
 */
public class WaferDecorator extends IceCreamDecorator {

    public WaferDecorator(IceCream wrappedIceCream) {
        super(wrappedIceCream);
    }

    // TODO D4.1
    // Add ", Wafer" to the wrapped description.
    @Override
    public String getDescription() {
        return wrappedIceCream.getDescription() + ", Wafer";
    }

    // TODO D4.2
    // Add 2000 to the wrapped cost.
    @Override
    public double getCost() {
        return wrappedIceCream.getCost() + 2000;
    }
}