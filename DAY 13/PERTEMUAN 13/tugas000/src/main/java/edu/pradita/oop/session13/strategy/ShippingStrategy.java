package edu.pradita.oop.session13.strategy;

/**
 * STRATEGY PATTERN — Common shipping algorithm contract.
 *
 * Different shipping methods calculate cost differently,
 * but the calculator should use them through one shared interface.
 */
public interface ShippingStrategy {

    // TODO S1.1
    // Declare calculate(double weight).
    double calculate(double weight);
}