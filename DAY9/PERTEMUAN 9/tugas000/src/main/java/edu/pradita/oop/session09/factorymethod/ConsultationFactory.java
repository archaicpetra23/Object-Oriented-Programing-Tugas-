package edu.pradita.oop.session09.factorymethod;

public abstract class ConsultationFactory {

    // TODO 6.1
    // Fill in the blanks using the proper abstraction
    // a. public
    // b. private
    public abstract Consultation createConsultation();

    // TODO 6.2
    // Complete the algorithm.
    public void handleConsultation() {
        Consultation consultation = createConsultation();
        consultation.serve();
    }
}