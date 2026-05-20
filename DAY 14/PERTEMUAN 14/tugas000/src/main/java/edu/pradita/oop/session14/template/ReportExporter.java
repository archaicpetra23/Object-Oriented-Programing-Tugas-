package edu.pradita.oop.session14.template;

/**
 * TEMPLATE METHOD PATTERN — Base exporter.
 *
 * WHY THIS CLASS?
 * PDF, CSV, and JSON exporters all follow the same overall process:
 * 1. fetch data
 * 2. write header
 * 3. write body
 * 4. save file
 *
 * Only some steps vary by format.
 *
 * DO: Put the fixed workflow in one template method.
 * DO: Let subclasses customize the varying steps.
 * DONT: Duplicate the full export algorithm in every subclass.
 */
public abstract class ReportExporter {

    // TODO TM1.1
    // Implement final template method exportReport(String fileName).
    // Call these steps in order:
    // fetchData();
    // writeHeader();
    // writeBody();
    // saveFile(fileName);
    public final void exportReport(String fileName) {
        fetchData();
        writeHeader();
        writeBody();
        saveFile(fileName);
    }

    // TODO TM1.2
    // Implement fetchData().
    // Print: "Fetching report data..."
    protected void fetchData() {
        System.out.println("Fetching report data...");
    }

    // TODO TM1.3
    // Declare abstract methods:
    // writeHeader()
    // writeBody()
    protected abstract void writeHeader();

    protected abstract void writeBody();

    // TODO TM1.4
    // Implement saveFile(String fileName).
    // Print: "Saving file: " + fileName
    protected void saveFile(String fileName) {
        System.out.println("Saving file: " + fileName);
    }
}