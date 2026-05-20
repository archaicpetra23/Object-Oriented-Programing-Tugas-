package edu.pradita.oop.session14.template;

/**
 * Concrete exporter for PDF.
 */
public class PdfReportExporter extends ReportExporter {

    // TODO TM2.1
    // Print: "Writing PDF header..."
    @Override
    protected void writeHeader() {
        System.out.println("Writing PDF header...");
    }

    // TODO TM2.2
    // Print: "Writing PDF body..."
    @Override
    protected void writeBody() {
        System.out.println("Writing PDF body...");
    }
}