package edu.pradita.oop.session14.chain;

/**
 * First handler — checks authentication.
 */
public class AuthCheckHandler extends LoginHandler {

    // TODO CH3.1
    // If request is NOT authenticated:
    // print "Auth failed"
    // return false
    // Otherwise:
    // print "Auth passed"
    // continue to next handler
    @Override
    public boolean handle(LoginRequest request) {
        if (!request.isAuthenticated()) {
            System.out.println("Auth failed");
            return false;
        }
        System.out.println("Auth passed");
        return handleNext(request);
    }
}