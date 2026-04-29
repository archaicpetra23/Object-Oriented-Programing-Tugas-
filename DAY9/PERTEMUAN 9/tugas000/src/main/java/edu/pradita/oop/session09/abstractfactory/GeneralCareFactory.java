package edu.pradita.oop.session09.abstractfactory;

public class GeneralCareFactory implements CarePackageFactory {

    @Override
    public Room createRoom() {
        return new Room() {
            @Override
            public void prepare() {
                System.out.println("General room is ready.");
            }
        };
    }

    @Override
    public Prescription createPrescription() {
        return new Prescription() {
            @Override
            public void dispense() {
                System.out.println("General prescription is dispensed.");
            }
        };
    }

    @Override
    public Invoice createInvoice() {
        return new Invoice() {
            @Override
            public void print() {
                System.out.println("General invoice is printed.");
            }
        };
    }
}