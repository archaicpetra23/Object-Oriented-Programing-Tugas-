package edu.pradita.oop.session14;

import edu.pradita.oop.session14.chain.*;
import edu.pradita.oop.session14.template.*;
import edu.pradita.oop.session14.state.*;
import edu.pradita.oop.session14.mediator.*;

public class App {

    public static void main(String[] args) {

        System.out.println("=== CHAIN OF RESPONSIBILITY ===");

        // TODO APP1
        // Build the login validation chain:
        // AuthCheckHandler -> RoleCheckHandler -> RateLimitHandler
        LoginHandler auth = new AuthCheckHandler();
        LoginHandler role = new RoleCheckHandler();
        LoginHandler rate = new RateLimitHandler();
        auth.setNext(role).setNext(rate);

        // TODO APP2
        // Create a valid LoginRequest and print the final result.
        LoginRequest request = new LoginRequest(true, "admin", 5);
        System.out.println("Login valid? " + auth.handle(request));

        System.out.println();
        System.out.println("=== TEMPLATE METHOD ===");

        // TODO APP3
        // Create a PdfReportExporter and export "report.pdf".
        ReportExporter exporter = new PdfReportExporter();
        exporter.exportReport("report.pdf");

        System.out.println();
        System.out.println("=== STATE ===");

        // TODO APP4
        // Create Document, submit it, approve it, then print status.
        Document document = new Document();
        document.submit();
        document.approve();
        System.out.println("Current status: " + document.getStatus());

        System.out.println();
        System.out.println("=== MEDIATOR ===");

        // TODO APP5
        // Create IntersectionController and two traffic lights:
        // "North-South" and "East-West"
        IntersectionController controller = new IntersectionController();
        TrafficLight northSouth = new TrafficLight("North-South", controller);
        TrafficLight eastWest = new TrafficLight("East-West", controller);

        controller.addLight(northSouth);
        controller.addLight(eastWest);

        // TODO APP6
        // Request green for North-South, then show both lights.
        northSouth.requestGreen();
        northSouth.show();
        eastWest.show();
    }
}