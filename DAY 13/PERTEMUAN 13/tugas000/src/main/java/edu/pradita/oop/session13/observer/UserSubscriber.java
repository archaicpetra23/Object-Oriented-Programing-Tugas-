package edu.pradita.oop.session13.observer;

/**
 * Concrete observer.
 *
 * A UserSubscriber receives notifications from a Channel.
 */
public class UserSubscriber implements Subscriber {

    private final String username;

    // TODO O3.1
    // Complete constructor assignment.
    public UserSubscriber(String username) {
        this.username = username;
    }

    // TODO O3.2
    // Implement update().
    // Print format:
    // Alice got notified: PraditaChannel uploaded OOP Observer Pattern
    @Override
    public void update(String channelName, String videoTitle) {
        System.out.println(username + " got notified: " + channelName + " uploaded " + videoTitle);
    }

    // TODO O3.3
    // Create getUsername().
    public String getUsername() {
        return username;
    }
}