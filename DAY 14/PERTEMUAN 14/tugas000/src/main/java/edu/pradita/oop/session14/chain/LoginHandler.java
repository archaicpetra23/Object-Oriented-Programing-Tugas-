package edu.pradita.oop.session14.chain;

/**
 * CHAIN OF RESPONSIBILITY — Base handler.
 *
 * WHY THIS CLASS?
 * Every validation handler should:
 * 1. validate its own rule
 * 2. pass the request to the next handler if valid
 *
 * DO: Store the next handler.
 * DO: Delegate when current validation passes.
 * DONT: Hardcode all validation rules into one giant method.
 */
public abstract class LoginHandler {

    protected LoginHandler next;

    // TODO CH2.1
    // Implement setNext(LoginHandler next).
    // Return the next handler so calls can be chained.
    public LoginHandler setNext(LoginHandler next) {
        this.next = next;
        return next;
    }

    // TODO CH2.2
    // Declare abstract handle(LoginRequest request).
    // Return type: boolean
    public abstract boolean handle(LoginRequest request);

    // TODO CH2.3
    // Create protected helper handleNext(LoginRequest request).
    // If next is null, return true.
    // Otherwise delegate to next.handle(request).
    protected boolean handleNext(LoginRequest request) {
        if (next == null) {
            return true;
        }
        return next.handle(request);
    }
}