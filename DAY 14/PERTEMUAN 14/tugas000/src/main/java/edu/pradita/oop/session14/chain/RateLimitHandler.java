package edu.pradita.oop.session14.chain;

/**
 * Final handler — checks request rate limit.
 *
 * RULE:
 * Reject if requestCount > 5
 */
public class RateLimitHandler extends LoginHandler {

    // TODO CH5.1
    // If requestCount > 5:
    // print "Rate limit failed"
    // return false
    // Otherwise:
    // print "Rate limit passed"
    // return true / continue
    @Override
    public boolean handle(LoginRequest request) {
        if (request.getRequestCount() > 5) {
            System.out.println("Rate limit failed");
            return false;
        }
        System.out.println("Rate limit passed");
        return handleNext(request);
    }
}