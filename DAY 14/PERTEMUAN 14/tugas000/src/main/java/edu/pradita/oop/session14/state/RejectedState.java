package edu.pradita.oop.session14.state;

/**
 * Rejected state.
 *
 * RULES:
 * - submit() -> invalid
 * - approve() -> invalid
 * - reject() -> invalid
 */
public class RejectedState implements DocumentState {

    // TODO ST6.1
    // submit -> print "Cannot submit rejected document"
    @Override
    public void submit(Document document) {
        System.out.println("Cannot submit rejected document");
    }

    // TODO ST6.2
    // approve -> print "Cannot approve rejected document"
    @Override
    public void approve(Document document) {
        System.out.println("Cannot approve rejected document");
    }

    // TODO ST6.3
    // reject -> print "Already rejected"
    @Override
    public void reject(Document document) {
        System.out.println("Already rejected");
    }

    // TODO ST6.4
    // Return "Rejected"
    @Override
    public String getStatus() {
        return "Rejected";
    }
}