package edu.pradita.oop.session14.chain;

/**
 * Request object for the login validation pipeline.
 *
 * WHY THIS CLASS?
 * All handlers in the chain should receive the same request object.
 * Each handler reads only the part it cares about.
 *
 * FIELDS:
 * - authenticated : whether the user passed authentication
 * - role : the user's role
 * - requestCount : how many recent login attempts were made
 */
public class LoginRequest {

    // TODO CH1.1
    // Declare private final fields:
    // authenticated (boolean)
    // role (String)
    // requestCount (int)
    private final boolean authenticated;
    private final String role;
    private final int requestCount;

    // TODO CH1.2
    // Complete constructor assignment.
    public LoginRequest(boolean authenticated, String role, int requestCount) {
        this.authenticated = authenticated;
        this.role = role;
        this.requestCount = requestCount;
    }

    // TODO CH1.3
    // Create getters:
    // isAuthenticated(), getRole(), getRequestCount()
    public boolean isAuthenticated() {
        return authenticated;
    }

    public String getRole() {
        return role;
    }

    public int getRequestCount() {
        return requestCount;
    }
}