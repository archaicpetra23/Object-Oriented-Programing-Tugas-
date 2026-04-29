package edu.pradita.oop.session09.singleton;

public class ClinicSystem {

    // Singleton instance
    private static ClinicSystem instance;

    // Store clinic name.
    private String clinicName;

    // Private constructor
    private ClinicSystem() {
        clinicName = "Pradita Health Clinic";
    }

    // Singleton accessor
    public static ClinicSystem getInstance() {
        if (instance == null) {
            instance = new ClinicSystem();
        }
        return instance;
    }

    // Return the clinic name
    public String getClinicName() {
        return clinicName;
    }

    // Return a queue number.
    public String generateQueueNumber() {
        return "Q-001";
    }
}