package edu.pradita.oop.session13.strategy;

/**
 * Regular shipping:
 * cost = 10000 + (weight * 2000)
 */
public class RegularShipping implements ShippingStrategy {

    // TODO S2.1
    // Implement the formula above.
    @Override
    public double calculate(double weight) {
        return 10000 + (weight * 2000);
    }
}