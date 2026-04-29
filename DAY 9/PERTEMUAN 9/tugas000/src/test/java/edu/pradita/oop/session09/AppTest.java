package edu.pradita.oop.session09;

import edu.pradita.oop.session09.abstractfactory.CarePackageFactory;
import edu.pradita.oop.session09.abstractfactory.DentalCareFactory;
import edu.pradita.oop.session09.abstractfactory.GeneralCareFactory;
import edu.pradita.oop.session09.abstractfactory.Invoice;
import edu.pradita.oop.session09.abstractfactory.PediatricCareFactory;
import edu.pradita.oop.session09.abstractfactory.Prescription;
import edu.pradita.oop.session09.abstractfactory.Room;
import edu.pradita.oop.session09.factorymethod.Consultation;
import edu.pradita.oop.session09.factorymethod.ConsultationFactory;
import edu.pradita.oop.session09.factorymethod.DentalConsultation;
import edu.pradita.oop.session09.factorymethod.DentalFactory;
import edu.pradita.oop.session09.factorymethod.GeneralConsultation;
import edu.pradita.oop.session09.factorymethod.GeneralFactory;
import edu.pradita.oop.session09.factorymethod.PediatricConsultation;
import edu.pradita.oop.session09.factorymethod.PediatricFactory;
import edu.pradita.oop.session09.singleton.ClinicSystem;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class ClinicPatternsTest {

    @Test
    void singletonShouldReturnSameInstance() {
        ClinicSystem first = ClinicSystem.getInstance();
        ClinicSystem second = ClinicSystem.getInstance();

        assertNotNull(first);
        assertSame(first, second);
    }

    @Test
    void singletonShouldHaveExpectedClinicName() {
        ClinicSystem clinic = ClinicSystem.getInstance();

        assertEquals("Pradita Health Clinic", clinic.getClinicName());
    }

    @Test
    void singletonShouldGenerateExpectedQueueNumber() {
        ClinicSystem clinic = ClinicSystem.getInstance();

        assertEquals("Q-001", clinic.generateQueueNumber());
    }

    @Test
    void generalFactoryShouldCreateGeneralConsultation() {
        ConsultationFactory factory = new GeneralFactory();

        Consultation consultation = factory.createConsultation();

        assertNotNull(consultation);
        assertInstanceOf(GeneralConsultation.class, consultation);
    }

    @Test
    void dentalFactoryShouldCreateDentalConsultation() {
        ConsultationFactory factory = new DentalFactory();

        Consultation consultation = factory.createConsultation();

        assertNotNull(consultation);
        assertInstanceOf(DentalConsultation.class, consultation);
    }

    @Test
    void pediatricFactoryShouldCreatePediatricConsultation() {
        ConsultationFactory factory = new PediatricFactory();

        Consultation consultation = factory.createConsultation();

        assertNotNull(consultation);
        assertInstanceOf(PediatricConsultation.class, consultation);
    }

    @Test
    void generalConsultationShouldPrintExpectedMessage() {
        Consultation consultation = new GeneralConsultation();

        String output = captureOutput(consultation::serve);

        assertEquals("General consultation is serving the patient.", output);
    }

    @Test
    void dentalConsultationShouldPrintExpectedMessage() {
        Consultation consultation = new DentalConsultation();

        String output = captureOutput(consultation::serve);

        assertEquals("Dental consultation is serving the patient.", output);
    }

    @Test
    void pediatricConsultationShouldPrintExpectedMessage() {
        Consultation consultation = new PediatricConsultation();

        String output = captureOutput(consultation::serve);

        assertEquals("Pediatric consultation is serving the patient.", output);
    }

    @Test
    void handleConsultationShouldUseFactoryMethodForGeneral() {
        ConsultationFactory factory = new GeneralFactory();

        String output = captureOutput(factory::handleConsultation);

        assertEquals("General consultation is serving the patient.", output);
    }

    @Test
    void handleConsultationShouldUseFactoryMethodForDental() {
        ConsultationFactory factory = new DentalFactory();

        String output = captureOutput(factory::handleConsultation);

        assertEquals("Dental consultation is serving the patient.", output);
    }

    @Test
    void handleConsultationShouldUseFactoryMethodForPediatric() {
        ConsultationFactory factory = new PediatricFactory();

        String output = captureOutput(factory::handleConsultation);

        assertEquals("Pediatric consultation is serving the patient.", output);
    }

    @Test
    void generalCareFactoryShouldCreateAllProducts() {
        CarePackageFactory factory = new GeneralCareFactory();

        Room room = factory.createRoom();
        Prescription prescription = factory.createPrescription();
        Invoice invoice = factory.createInvoice();

        assertNotNull(room);
        assertNotNull(prescription);
        assertNotNull(invoice);
    }

    @Test
    void dentalCareFactoryShouldCreateAllProducts() {
        CarePackageFactory factory = new DentalCareFactory();

        Room room = factory.createRoom();
        Prescription prescription = factory.createPrescription();
        Invoice invoice = factory.createInvoice();

        assertNotNull(room);
        assertNotNull(prescription);
        assertNotNull(invoice);
    }

    @Test
    void pediatricCareFactoryShouldCreateAllProducts() {
        CarePackageFactory factory = new PediatricCareFactory();

        Room room = factory.createRoom();
        Prescription prescription = factory.createPrescription();
        Invoice invoice = factory.createInvoice();

        assertNotNull(room);
        assertNotNull(prescription);
        assertNotNull(invoice);
    }

    @Test
    void generalCareFactoryProductsShouldPrintExpectedMessages() {
        CarePackageFactory factory = new GeneralCareFactory();

        String roomOutput = captureOutput(() -> factory.createRoom().prepare());
        String prescriptionOutput = captureOutput(() -> factory.createPrescription().dispense());
        String invoiceOutput = captureOutput(() -> factory.createInvoice().print());

        assertEquals("General room is ready.", roomOutput);
        assertEquals("General prescription is dispensed.", prescriptionOutput);
        assertEquals("General invoice is printed.", invoiceOutput);
    }

    @Test
    void dentalCareFactoryProductsShouldPrintExpectedMessages() {
        CarePackageFactory factory = new DentalCareFactory();

        String roomOutput = captureOutput(() -> factory.createRoom().prepare());
        String prescriptionOutput = captureOutput(() -> factory.createPrescription().dispense());
        String invoiceOutput = captureOutput(() -> factory.createInvoice().print());

        assertEquals("Dental room is ready.", roomOutput);
        assertEquals("Dental prescription is dispensed.", prescriptionOutput);
        assertEquals("Dental invoice is printed.", invoiceOutput);
    }

    @Test
    void pediatricCareFactoryProductsShouldPrintExpectedMessages() {
        CarePackageFactory factory = new PediatricCareFactory();

        String roomOutput = captureOutput(() -> factory.createRoom().prepare());
        String prescriptionOutput = captureOutput(() -> factory.createPrescription().dispense());
        String invoiceOutput = captureOutput(() -> factory.createInvoice().print());

        assertEquals("Pediatric room is ready.", roomOutput);
        assertEquals("Pediatric prescription is dispensed.", prescriptionOutput);
        assertEquals("Pediatric invoice is printed.", invoiceOutput);
    }

    private String captureOutput(Runnable action) {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream testOut = new PrintStream(outputStream);

        try {
            System.setOut(testOut);
            action.run();
        } finally {
            System.setOut(originalOut);
        }

        return outputStream.toString().trim();
    }
}