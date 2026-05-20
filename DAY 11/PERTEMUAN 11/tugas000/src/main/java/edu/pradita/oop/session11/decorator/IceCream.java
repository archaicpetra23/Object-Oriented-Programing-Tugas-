package edu.pradita.oop.session11.decorator;

/**
 * DECORATOR PATTERN — Component interface.
 *
 * WHY AN INTERFACE?
 * Both the base ice cream AND every topping decorator must be usable
 * in exactly the same way by the client.
 *
 * The customer should not care whether they are holding:
 * - a plain VanillaIceCream, or
 * - a VanillaIceCream wrapped by WaferDecorator, SprinklesDecorator, etc.
 *
 * DO: Keep the interface small and stable.
 * DO: Make both concrete components and decorators implement it.
 * DONT: Add topping-specific methods here. The client only needs common
 * behavior.
 */
public interface IceCream {

    // TODO D1.1
    // Declare getDescription().
    // It returns the current ice cream description, including toppings.
    String getDescription();

    // TODO D1.2
    // Declare getCost().
    // It returns the total cost after all decorators are applied.
    double getCost();
}