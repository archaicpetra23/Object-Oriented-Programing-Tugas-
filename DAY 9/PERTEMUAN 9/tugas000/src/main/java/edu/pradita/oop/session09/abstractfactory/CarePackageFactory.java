package edu.pradita.oop.session09.abstractfactory;

public interface CarePackageFactory {

    // TODO 13.1
    // Fixed method names for product family creation.
    Room createRoom();
    Prescription createPrescription();
    Invoice createInvoice();
}