package edu.pradita.oop.session13.observer;

/**
 * OBSERVER PATTERN — Observer interface.
 *
 * Every subscriber must be able to receive an update
 * when a channel uploads a new video.
 */
public interface Subscriber {

    // TODO O1.1
    // Declare update(String channelName, String videoTitle).
    void update(String channelName, String videoTitle);
}