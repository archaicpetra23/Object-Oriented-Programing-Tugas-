package edu.pradita.oop.session14.state;

/**
 * Approved state.
 *
 * RULES:
 * - submit() -> invalid
 * - approve() -> invalid
 * - reject() -> invalid
 */
public class ApprovedState implements DocumentState {

    // TODO ST5.1
    // submit -> print "Already approved"
    @Override
    public void submit(Document document) {
        System.out.println("Already approved");
    }

    // TODO ST5.2
    // approve -> print "Already approved"
    @Override
    public void approve(Document document) {
        System.out.println("Already approved");
    }

    // TODO ST5.3
    // reject -> print "Cannot reject approved document"
    @Override
    public void reject(Document document) {
        System.out.println("Cannot reject approved document");
    }

    // TODO ST5.4
    // Return "Approved"
    @Override
    public String getStatus() {
        return "Approved";
    }
}