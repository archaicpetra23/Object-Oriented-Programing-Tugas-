package edu.pradita.oop.session11.decorator;

/**
 * Base decorator class.
 *
 * WHY THIS CLASS EXISTS:
 * Every topping decorator wraps another IceCream object.
 * This abstract class stores that wrapped object once,
 * so each concrete topping decorator can reuse the same structure.
 *
 * DO: Store the wrapped component in a protected field.
 * DO: Let concrete decorators add description/cost on top of it.
 * DONT: Put topping-specific values in this abstract class.
 */
public abstract class IceCreamDecorator implements IceCream {

    // TODO D3.1
    // Declare a protected field named wrappedIceCream of type IceCream.
    protected IceCream wrappedIceCream;

    // TODO D3.2
    // Complete the constructor to store the wrapped object.
    public IceCreamDecorator(IceCream wrappedIceCream) {
        this.wrappedIceCream = wrappedIceCream;
    }
}