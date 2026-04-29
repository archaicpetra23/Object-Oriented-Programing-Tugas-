package edu.pradita.oop.session09.abstractfactory;

public class PediatricCareFactory implements CarePackageFactory {

    @Override
    public Room createRoom() {
        return new Room() {
            @Override
            public void prepare() {
                System.out.println("Pediatric room is ready.");
            }
        };
    }

    @Override
    public Prescription createPrescription() {
        return new Prescription() {
            @Override
            public void dispense() {
                System.out.println("Pediatric prescription is dispensed.");
            }
        };
    }

    @Override
    public Invoice createInvoice() {
        return new Invoice() {
            @Override
            public void print() {
                // TODO 16.1
                // Fill in the missing method part.
                System.out.println("Pediatric invoice is printed.");
            }
        };
    }
}