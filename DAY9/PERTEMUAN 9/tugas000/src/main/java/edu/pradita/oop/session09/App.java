package edu.pradita.oop.session09;

import edu.pradita.oop.session09.singleton.ClinicSystem;
import edu.pradita.oop.session09.factorymethod.ConsultationFactory;
import edu.pradita.oop.session09.factorymethod.GeneralFactory;
import edu.pradita.oop.session09.abstractfactory.CarePackageFactory;
import edu.pradita.oop.session09.abstractfactory.GeneralCareFactory;

public class App {

    public static void main(String[] args) {
        // TODO 17.1
        // Get the singleton instance.
        // Fill in the blank:

        ClinicSystem clinic = ClinicSystem.getInstance();

        // TODO 17.2
        // Complete the print statement.
        System.out.println("Welcome to " + clinic.getClinicName());

        // TODO 17.3
        // Print queue number.
        System.out.println("Queue number: " + clinic.generateQueueNumber());

        // TODO 17.4
        // Choose the correct factory object.
        // Choices:
        // A. consultationFactory
        // B. GeneralFactory
        ConsultationFactory consultationFactory = new GeneralFactory();

        // TODO 17.5
        // Complete the method call below.
        consultationFactory.handleConsultation();

        System.out.println();

        // TODO 17.6
        // Choose the correct abstract factory object.
        // Choices:
        // A. new carePackageFactory
        // B. new GeneralCareFactory
        CarePackageFactory carePackageFactory = new GeneralCareFactory();

        // TODO 17.7
        // Complete all product-family calls.
        carePackageFactory.createRoom().prepare();
        carePackageFactory.createPrescription().dispense();
        carePackageFactory.createInvoice().print();
    }
}