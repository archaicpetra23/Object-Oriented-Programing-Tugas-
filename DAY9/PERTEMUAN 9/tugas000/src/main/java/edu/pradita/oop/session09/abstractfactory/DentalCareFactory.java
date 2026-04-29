package edu.pradita.oop.session09.abstractfactory;

public class DentalCareFactory implements CarePackageFactory {

    @Override
    public Room createRoom() {
        return new Room() {
            @Override
            public void prepare() {
                System.out.println("Dental room is ready.");
            }
        };
    }

    @Override
    public Prescription createPrescription() {
        return new Prescription() {
            @Override
            public void dispense() {
                // TODO 15.1
                // Fill in the blank.
                System.out.println("Dental prescription is dispensed.");
            }
        };
    }

    @Override
    public Invoice createInvoice() {
        return new Invoice() {
            @Override
            public void print() {
                System.out.println("Dental invoice is printed.");
            }
        };
    }
}