package edu.pradita.ocp;

public class YogaSessionRefactored implements WorkoutSessionRefactored {
    @Override
    public void start() {
        System.out.println("[OCP] Starting Yoga session");
    }
}