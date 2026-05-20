package edu.pradita.oop.session14.state;

/**
 * Context class.
 *
 * WHY THIS CLASS?
 * It stores the current state object and delegates behavior to it.
 *
 * Initial state should be DraftState.
 */
public class Document {

    private DocumentState state;

    // TODO ST2.1
    // Set initial state to new DraftState().
    public Document() {
        this.state = new DraftState();
    }

    // TODO ST2.2
    // Implement setState(DocumentState state).
    public void setState(DocumentState state) {
        this.state = state;
    }

    // TODO ST2.3
    // Implement getState().
    public DocumentState getState() {
        return state;
    }

    // TODO ST2.4
    // Delegate submit(), approve(), reject() to current state.
    public void submit() {
        state.submit(this);
    }

    public void approve() {
        state.approve(this);
    }

    public void reject() {
        state.reject(this);
    }

    // TODO ST2.5
    // Create getStatus() that returns current state's status text.
    public String getStatus() {
        return state.getStatus();
    }
}