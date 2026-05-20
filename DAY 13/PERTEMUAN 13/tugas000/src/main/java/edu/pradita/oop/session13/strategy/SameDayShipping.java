package edu.pradita.oop.session13.strategy;

/**
 * Same-day shipping:
 * cost = 50000 + (weight * 5000)
 */
public class SameDayShipping implements ShippingStrategy {

    // TODO S4.1
    // Implement the formula above.
    @Override
    public double calculate(double weight) {
        return 50000 + (weight * 5000);
    }
}