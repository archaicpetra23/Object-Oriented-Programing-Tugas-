package edu.pradita.oop.session09.factorymethod;

public class GeneralFactory extends ConsultationFactory {

    // TODO 7.1
    // Choose the correct concrete product.
    // A. new GeneralConsultation()
    // B. new DentalConsultation()
    // C. new PediatricConsultation()
    @Override
    public Consultation createConsultation() {
        return new GeneralConsultation();
    }
}