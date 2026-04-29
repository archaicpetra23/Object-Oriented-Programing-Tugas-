package edu.pradita.oop.session09.factorymethod;

public class DentalFactory extends ConsultationFactory {

    // TODO 8.1
    // Return properly.
    @Override
    public Consultation createConsultation() {
        return new DentalConsultation();
    }
}