package edu.pradita.oop.session13.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Subject / Publisher.
 *
 * WHY OBSERVER FITS HERE:
 * One channel can have many subscribers.
 * When a new video is uploaded, all subscribers should be notified.
 *
 * DO: Store subscribers in a list.
 * DO: Notify all subscribers when uploadVideo() is called.
 * DONT: Hardcode specific user names inside Channel.
 */
public class Channel {

    private final String name;

    // TODO O2.1
    // Declare a private final List<Subscriber> and initialize it.
    private final List<Subscriber> subscribers = new ArrayList<>();

    // TODO O2.2
    // Complete constructor assignment for name.
    public Channel(String name) {
        this.name = name;
    }

    // TODO O2.3
    // Implement subscribe(Subscriber subscriber).
    public void subscribe(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    // TODO O2.4
    // Implement unsubscribe(Subscriber subscriber).
    public void unsubscribe(Subscriber subscriber) {
        subscribers.remove(subscriber);
    }

    // TODO O2.5
    // Implement uploadVideo(String title).
    // Loop through subscribers and call update(name, title).
    public void uploadVideo(String title) {
        for (Subscriber subscriber : subscribers) {
            subscriber.update(name, title);
        }
    }

    // TODO O2.6
    // Create getter for name.
    public String getName() {
        return name;
    }
}