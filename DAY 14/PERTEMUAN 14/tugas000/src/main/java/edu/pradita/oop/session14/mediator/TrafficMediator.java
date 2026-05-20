package edu.pradita.oop.session14.mediator;

/**
 * MEDIATOR PATTERN — Common mediator contract.
 *
 * The traffic lights should not directly control one another.
 * Instead, they coordinate through one mediator.
 */
public interface TrafficMediator {

    // TODO MD1.1
    // Declare requestGreen(TrafficLight requester).
    void requestGreen(TrafficLight requester);
}