package edu.pradita.oop.session14.template;

/**
 * Concrete exporter for JSON.
 */
public class JsonReportExporter extends ReportExporter {

    // TODO TM4.1
    // Print: "Writing JSON header..."
    @Override
    protected void writeHeader() {
        System.out.println("Writing JSON header...");
    }

    // TODO TM4.2
    // Print: "Writing JSON body..."
    @Override
    protected void writeBody() {
        System.out.println("Writing JSON body...");
    }
}