package edu.pradita.oop.session11.decorator;

/**
 * Concrete component — the base object before toppings are added.
 *
 * USE CASE:
 * This is the plain ice cream cup. Decorators will wrap this object
 * to add extra toppings and price.
 */
public class VanillaIceCream implements IceCream {

    // TODO D2.1
    // Implement getDescription() for the base product.
    // Return: "Vanilla Ice Cream"
    @Override
    public String getDescription() {
        return "Vanilla Ice Cream";
    }

    // TODO D2.2
    // Implement getCost() for the base product.
    // Return: 10000
    @Override
    public double getCost() {
        return 10000;
    }
}