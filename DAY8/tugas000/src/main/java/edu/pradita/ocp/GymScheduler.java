package edu.pradita.ocp;

public class GymScheduler {
    public void startSession(String type) {
        if (type.equals("Yoga")) {
            System.out.println("Starting Yoga session: breathing and stretching...");
        } else if (type.equals("Cardio")) {
            System.out.println("Starting Cardio session: treadmill and jump rope...");
        }
    }
}