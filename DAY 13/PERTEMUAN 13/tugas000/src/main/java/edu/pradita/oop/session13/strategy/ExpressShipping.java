package edu.pradita.oop.session13.strategy;

/**
 * Express shipping:
 * cost = 20000 + (weight * 3500)
 */
public class ExpressShipping implements ShippingStrategy {

    // TODO S3.1
    // Implement the formula above.
    @Override
    public double calculate(double weight) {
        return 20000 + (weight * 3500);
    }
}