package edu.pradita.oop.session14.state;

/**
 * Review state.
 *
 * RULES:
 * - submit() -> invalid
 * - approve() -> move to ApprovedState
 * - reject() -> move to RejectedState
 */
public class ReviewState implements DocumentState {

    // TODO ST4.1
    // submit -> print "Already under review"
    @Override
    public void submit(Document document) {
        System.out.println("Already under review");
    }

    // TODO ST4.2
    // approve -> print "Document approved" and set ApprovedState
    @Override
    public void approve(Document document) {
        System.out.println("Document approved");
        document.setState(new ApprovedState());
    }

    // TODO ST4.3
    // reject -> print "Document rejected" and set RejectedState
    @Override
    public void reject(Document document) {
        System.out.println("Document rejected");
        document.setState(new RejectedState());
    }

    // TODO ST4.4
    // Return "Review"
    @Override
    public String getStatus() {
        return "Review";
    }
}