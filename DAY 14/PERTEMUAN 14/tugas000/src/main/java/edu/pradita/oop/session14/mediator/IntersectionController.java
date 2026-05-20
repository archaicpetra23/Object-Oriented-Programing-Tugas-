package edu.pradita.oop.session14.mediator;

import java.util.ArrayList;
import java.util.List;

/**
 * Concrete mediator.
 *
 * JOB:
 * Only one traffic light should be GREEN at a time.
 * When one light requests GREEN:
 * - it becomes GREEN
 * - all others become RED
 *
 * DO: Centralize coordination here.
 * DONT: Let lights know about each other directly.
 */
public class IntersectionController implements TrafficMediator {

    private final List<TrafficLight> lights = new ArrayList<>();

    // TODO MD3.1
    // Implement addLight(TrafficLight light).
    public void addLight(TrafficLight light) {
        lights.add(light);
    }

    // TODO MD3.2
    // Implement requestGreen(TrafficLight requester).
    //
    // Loop through all lights:
    // - if light == requester -> set GREEN
    // - else -> set RED
    @Override
    public void requestGreen(TrafficLight requester) {
        for (TrafficLight light : lights) {
            if (light == requester) {
                light.setColor("GREEN");
            } else {
                light.setColor("RED");
            }
        }
    }
}