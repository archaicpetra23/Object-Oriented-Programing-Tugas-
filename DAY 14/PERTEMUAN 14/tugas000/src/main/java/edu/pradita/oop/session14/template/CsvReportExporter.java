package edu.pradita.oop.session14.template;

/**
 * Concrete exporter for CSV.
 */
public class CsvReportExporter extends ReportExporter {

    // TODO TM3.1
    // Print: "Writing CSV header..."
    @Override
    protected void writeHeader() {
        System.out.println("Writing CSV header...");
    }

    // TODO TM3.2
    // Print: "Writing CSV body..."
    @Override
    protected void writeBody() {
        System.out.println("Writing CSV body...");
    }
}