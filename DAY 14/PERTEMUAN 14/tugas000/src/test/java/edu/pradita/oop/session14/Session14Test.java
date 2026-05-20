package edu.pradita.oop.session14;

import edu.pradita.oop.session14.chain.*;
import edu.pradita.oop.session14.template.*;
import edu.pradita.oop.session14.state.*;
import edu.pradita.oop.session14.mediator.*;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class Session14Test {

    // ══════════════════════════════════════════════════════════════════
    // CHAIN OF RESPONSIBILITY TESTS
    // Checks request data, handler chaining, and pass/fail flow.
    // ══════════════════════════════════════════════════════════════════

    @Test
    void loginRequestShouldStoreAllFields() {
        LoginRequest request = new LoginRequest(true, "ADMIN", 3);

        assertTrue(request.isAuthenticated());
        assertEquals("ADMIN", request.getRole());
        assertEquals(3, request.getRequestCount());
    }

    @Test
    void validRequestShouldPassEntireChain() {
        LoginHandler auth = new AuthCheckHandler();
        LoginHandler role = new RoleCheckHandler();
        LoginHandler rate = new RateLimitHandler();
        auth.setNext(role).setNext(rate);

        LoginRequest request = new LoginRequest(true, "USER", 2);

        assertTrue(auth.handle(request));
    }

    @Test
    void unauthenticatedRequestShouldFailAtAuthCheck() {
        LoginHandler auth = new AuthCheckHandler();
        LoginHandler role = new RoleCheckHandler();
        LoginHandler rate = new RateLimitHandler();
        auth.setNext(role).setNext(rate);

        LoginRequest request = new LoginRequest(false, "ADMIN", 1);

        assertFalse(auth.handle(request));
    }

    @Test
    void invalidRoleShouldFailAtRoleCheck() {
        LoginHandler auth = new AuthCheckHandler();
        LoginHandler role = new RoleCheckHandler();
        LoginHandler rate = new RateLimitHandler();
        auth.setNext(role).setNext(rate);

        LoginRequest request = new LoginRequest(true, "GUEST", 1);

        assertFalse(auth.handle(request));
    }

    @Test
    void tooManyRequestsShouldFailAtRateLimit() {
        LoginHandler auth = new AuthCheckHandler();
        LoginHandler role = new RoleCheckHandler();
        LoginHandler rate = new RateLimitHandler();
        auth.setNext(role).setNext(rate);

        LoginRequest request = new LoginRequest(true, "ADMIN", 10);

        assertFalse(auth.handle(request));
    }

    @Test
    void chainShouldPrintValidationSteps() {
        LoginHandler auth = new AuthCheckHandler();
        LoginHandler role = new RoleCheckHandler();
        LoginHandler rate = new RateLimitHandler();
        auth.setNext(role).setNext(rate);

        LoginRequest request = new LoginRequest(true, "USER", 2);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream original = System.out;
        System.setOut(new PrintStream(out));

        auth.handle(request);

        System.setOut(original);

        String result = out.toString();
        assertTrue(result.contains("Auth passed"));
        assertTrue(result.contains("Role check passed"));
        assertTrue(result.contains("Rate limit passed"));
    }

    // ══════════════════════════════════════════════════════════════════
    // TEMPLATE METHOD TESTS
    // Checks shared export flow and format-specific steps.
    // ══════════════════════════════════════════════════════════════════

    @Test
    void pdfExporterShouldFollowTemplateSteps() {
        ReportExporter exporter = new PdfReportExporter();

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream original = System.out;
        System.setOut(new PrintStream(out));

        exporter.exportReport("report.pdf");

        System.setOut(original);

        String result = out.toString();
        assertTrue(result.contains("Fetching report data..."));
        assertTrue(result.contains("Writing PDF header..."));
        assertTrue(result.contains("Writing PDF body..."));
        assertTrue(result.contains("Saving file: report.pdf"));
    }

    @Test
    void csvExporterShouldFollowTemplateSteps() {
        ReportExporter exporter = new CsvReportExporter();

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream original = System.out;
        System.setOut(new PrintStream(out));

        exporter.exportReport("report.csv");

        System.setOut(original);

        String result = out.toString();
        assertTrue(result.contains("Fetching report data..."));
        assertTrue(result.contains("Writing CSV header..."));
        assertTrue(result.contains("Writing CSV body..."));
        assertTrue(result.contains("Saving file: report.csv"));
    }

    @Test
    void jsonExporterShouldFollowTemplateSteps() {
        ReportExporter exporter = new JsonReportExporter();

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream original = System.out;
        System.setOut(new PrintStream(out));

        exporter.exportReport("report.json");

        System.setOut(original);

        String result = out.toString();
        assertTrue(result.contains("Fetching report data..."));
        assertTrue(result.contains("Writing JSON header..."));
        assertTrue(result.contains("Writing JSON body..."));
        assertTrue(result.contains("Saving file: report.json"));
    }

    @Test
    void templateMethodShouldPreserveStepOrder() {
        ReportExporter exporter = new PdfReportExporter();

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream original = System.out;
        System.setOut(new PrintStream(out));

        exporter.exportReport("report.pdf");

        System.setOut(original);

        String result = out.toString();

        int fetchIndex = result.indexOf("Fetching report data...");
        int headerIndex = result.indexOf("Writing PDF header...");
        int bodyIndex = result.indexOf("Writing PDF body...");
        int saveIndex = result.indexOf("Saving file: report.pdf");

        assertTrue(fetchIndex < headerIndex);
        assertTrue(headerIndex < bodyIndex);
        assertTrue(bodyIndex < saveIndex);
    }

    // ══════════════════════════════════════════════════════════════════
    // STATE TESTS
    // Checks initial state, valid transitions, and invalid actions.
    // ══════════════════════════════════════════════════════════════════

    @Test
    void documentShouldStartInDraftState() {
        Document document = new Document();
        assertEquals("Draft", document.getStatus());
        assertTrue(document.getState() instanceof DraftState);
    }

    @Test
    void draftSubmitShouldMoveToReview() {
        Document document = new Document();
        document.submit();

        assertEquals("Review", document.getStatus());
        assertTrue(document.getState() instanceof ReviewState);
    }

    @Test
    void reviewApproveShouldMoveToApproved() {
        Document document = new Document();
        document.submit();
        document.approve();

        assertEquals("Approved", document.getStatus());
        assertTrue(document.getState() instanceof ApprovedState);
    }

    @Test
    void reviewRejectShouldMoveToRejected() {
        Document document = new Document();
        document.submit();
        document.reject();

        assertEquals("Rejected", document.getStatus());
        assertTrue(document.getState() instanceof RejectedState);
    }

    @Test
    void draftApproveShouldStayDraft() {
        Document document = new Document();
        document.approve();

        assertEquals("Draft", document.getStatus());
        assertTrue(document.getState() instanceof DraftState);
    }

    @Test
    void approvedRejectShouldStayApproved() {
        Document document = new Document();
        document.submit();
        document.approve();
        document.reject();

        assertEquals("Approved", document.getStatus());
        assertTrue(document.getState() instanceof ApprovedState);
    }

    @Test
    void rejectedApproveShouldStayRejected() {
        Document document = new Document();
        document.submit();
        document.reject();
        document.approve();

        assertEquals("Rejected", document.getStatus());
        assertTrue(document.getState() instanceof RejectedState);
    }

    @Test
    void stateMethodsShouldPrintMessages() {
        Document document = new Document();

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream original = System.out;
        System.setOut(new PrintStream(out));

        document.submit();
        document.approve();

        System.setOut(original);

        String result = out.toString();
        assertTrue(result.contains("Submitted for review"));
        assertTrue(result.contains("Document approved"));
    }

    // ══════════════════════════════════════════════════════════════════
    // MEDIATOR TESTS
    // Checks controller coordination and exclusive green light behavior.
    // ══════════════════════════════════════════════════════════════════

    @Test
    void trafficLightShouldStoreDirectionAndDefaultColor() {
        IntersectionController controller = new IntersectionController();
        TrafficLight light = new TrafficLight("North-South", controller);

        assertEquals("North-South", light.getDirection());
        assertEquals("RED", light.getColor());
    }

    @Test
    void requestingGreenShouldTurnRequesterGreen() {
        IntersectionController controller = new IntersectionController();
        TrafficLight northSouth = new TrafficLight("North-South", controller);
        controller.addLight(northSouth);

        northSouth.requestGreen();

        assertEquals("GREEN", northSouth.getColor());
    }

    @Test
    void requestingGreenShouldTurnOtherLightsRed() {
        IntersectionController controller = new IntersectionController();
        TrafficLight northSouth = new TrafficLight("North-South", controller);
        TrafficLight eastWest = new TrafficLight("East-West", controller);

        controller.addLight(northSouth);
        controller.addLight(eastWest);

        northSouth.requestGreen();

        assertEquals("GREEN", northSouth.getColor());
        assertEquals("RED", eastWest.getColor());
    }

    @Test
    void secondLightRequestShouldSwitchGreenControl() {
        IntersectionController controller = new IntersectionController();
        TrafficLight northSouth = new TrafficLight("North-South", controller);
        TrafficLight eastWest = new TrafficLight("East-West", controller);

        controller.addLight(northSouth);
        controller.addLight(eastWest);

        northSouth.requestGreen();
        eastWest.requestGreen();

        assertEquals("RED", northSouth.getColor());
        assertEquals("GREEN", eastWest.getColor());
    }

    @Test
    void trafficLightShowShouldPrintStatus() {
        IntersectionController controller = new IntersectionController();
        TrafficLight light = new TrafficLight("North-South", controller);
        light.setColor("GREEN");

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream original = System.out;
        System.setOut(new PrintStream(out));

        light.show();

        System.setOut(original);

        String result = out.toString();
        assertTrue(result.contains("North-South"));
        assertTrue(result.contains("GREEN"));
    }
}