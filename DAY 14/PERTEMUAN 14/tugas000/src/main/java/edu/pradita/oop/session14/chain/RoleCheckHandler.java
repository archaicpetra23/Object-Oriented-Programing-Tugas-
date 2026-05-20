package edu.pradita.oop.session14.chain;

/**
 * Second handler — checks whether the role is allowed.
 *
 * RULE:
 * Only "ADMIN" and "USER" are allowed.
 */
public class RoleCheckHandler extends LoginHandler {

    // TODO CH4.1
    // If role is neither "ADMIN" nor "USER":
    // print "Role check failed"
    // return false
    // Otherwise:
    // print "Role check passed"
    // continue
    @Override
    public boolean handle(LoginRequest request) {
        String role = request.getRole();
        if (!role.equals("ADMIN") && !role.equals("USER")) {
            System.out.println("Role check failed");
            return false;
        }
        System.out.println("Role check passed");
        return handleNext(request);
    }
}