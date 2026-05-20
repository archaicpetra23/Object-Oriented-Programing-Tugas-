package edu.pradita.oop.session14.state;

/**
 * STATE PATTERN — Common state interface.
 *
 * The document behaves differently depending on its current state.
 * Each state decides whether submit, approve, or reject is allowed.
 */
public interface DocumentState {

    // TODO ST1.1
    // Declare:
    // submit(Document document)
    // approve(Document document)
    // reject(Document document)
    // getStatus()
    void submit(Document document);

    void approve(Document document);

    void reject(Document document);

    String getStatus();
}