package edu.pradita.oop.session13.strategy;

/**
 * Context class for Strategy.
 *
 * WHY THIS CLASS?
 * The calculator should not know HOW each shipping method works.
 * It should only delegate to the chosen strategy.
 */
public class ShippingCalculator {

    private ShippingStrategy strategy;

    // TODO S5.1
    // Complete constructor assignment.
    public ShippingCalculator(ShippingStrategy strategy) {
        this.strategy = strategy;
    }

    // TODO S5.2
    // Implement setStrategy(ShippingStrategy strategy).
    public void setStrategy(ShippingStrategy strategy) {
        this.strategy = strategy;
    }

    // TODO S5.3
    // Implement calculateCost(double weight) by delegating to strategy.
    public double calculateCost(double weight) {
        return strategy.calculate(weight);
    }
}