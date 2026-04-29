package edu.pradita.oop.session09.factorymethod;

public class PediatricFactory extends ConsultationFactory {

    // TODO 9.1
    // Fill in return result.
    @Override
    public Consultation createConsultation() {
        return new PediatricConsultation();
    }
}