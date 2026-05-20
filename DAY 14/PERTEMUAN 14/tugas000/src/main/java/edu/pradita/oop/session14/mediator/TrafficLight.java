package edu.pradita.oop.session14.mediator;

/**
 * Colleague class.
 *
 * Each traffic light has a direction (e.g. North-South or East-West)
 * and a current color.
 */
public class TrafficLight {

    private final String direction;
    private String color = "RED";
    private final TrafficMediator mediator;

    // TODO MD2.1
    // Complete constructor assignments.
    public TrafficLight(String direction, TrafficMediator mediator) {
        this.direction = direction;
        this.mediator = mediator;
    }

    // TODO MD2.2
    // Implement requestGreen().
    // Delegate to mediator.requestGreen(this).
    public void requestGreen() {
        mediator.requestGreen(this);
    }

    // TODO MD2.3
    // Implement setColor(String color).
    public void setColor(String color) {
        this.color = color;
    }

    // TODO MD2.4
    // Create getters for direction and color.
    public String getDirection() {
        return direction;
    }

    public String getColor() {
        return color;
    }

    // TODO MD2.5
    // Print format:
    // North-South light is GREEN
    public void show() {
        System.out.println(direction + " light is " + color);
    }
}