package edu.pradita.oop.session12.proxy;

/**
 * Real subject — expensive object.
 *
 * WHY IS THIS "EXPENSIVE"?
 * Imagine this class loads giant image tiles, map data,
 * and route information from disk or network.
 *
 * That means creating this object is costly,
 * so we should delay it until truly needed.
 */
public class RealWorldMap implements MapInterface {

    // TODO P2.1
    // Complete constructor.
    // Print: "Loading heavy real-world map..."
    public RealWorldMap() {
        System.out.println("Loading heavy real-world map...");
    }

    // TODO P2.2
    // Implement display().
    // Print: "Displaying real-world map"
    @Override
    public void display() {
        System.out.println("Displaying real-world map");
    }
}