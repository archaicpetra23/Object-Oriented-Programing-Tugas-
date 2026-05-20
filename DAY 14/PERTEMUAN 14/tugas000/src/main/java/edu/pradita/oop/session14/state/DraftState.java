package edu.pradita.oop.session14.state;

/**
 * Draft state.
 *
 * RULES:
 * - submit() -> move to ReviewState
 * - approve() -> invalid
 * - reject() -> invalid
 */
public class DraftState implements DocumentState {

    // TODO ST3.1
    // submit -> print "Submitted for review" and set ReviewState
    @Override
    public void submit(Document document) {
        System.out.println("Submitted for review");
        document.setState(new ReviewState());
    }

    // TODO ST3.2
    // approve -> print "Cannot approve draft"
    @Override
    public void approve(Document document) {
        System.out.println("Cannot approve draft");
    }

    // TODO ST3.3
    // reject -> print "Cannot reject draft"
    @Override
    public void reject(Document document) {
        System.out.println("Cannot reject draft");
    }

    // TODO ST3.4
    // Return "Draft"
    @Override
    public String getStatus() {
        return "Draft";
    }
}