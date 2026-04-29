package edu.pradita.ocp;

public class CardioSessionRefactored implements WorkoutSessionRefactored {
    @Override
    public void start() {
        System.out.println("[OCP] Starting Cardio session");
    }
}