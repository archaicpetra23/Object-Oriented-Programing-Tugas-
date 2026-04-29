package edu.pradita.ocp;

public class SpinningSessionRefactored implements WorkoutSessionRefactored {
    @Override
    public void start() {
        System.out.println("[OCP] Starting Spinning session");
    }
}