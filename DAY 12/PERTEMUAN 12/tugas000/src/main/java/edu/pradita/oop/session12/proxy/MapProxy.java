package edu.pradita.oop.session12.proxy;

/**
 * PROXY PATTERN — Lazy-loading proxy.
 *
 * JOB:
 * Stand in front of RealWorldMap.
 * Do NOT create the expensive map immediately.
 * Only create it when display() is called for the first time.
 *
 * DO: Delay object creation until necessary.
 * DO: Reuse the same real object after it has been created once.
 * DONT: Create a new RealWorldMap every time display() is called.
 */
public class MapProxy implements MapInterface {

    // TODO P3.1
    // Declare a private field:
    // realMap (RealWorldMap)
    // Initial value should be null.
    private MapInterface realMap;

    // TODO P3.2
    // Implement display().
    //
    // Logic:
    // 1. If realMap is null, create a new RealWorldMap().
    // 2. Then call display() on realMap.
    //
    // This is lazy initialization.
    @Override
    public void display() {
        if (realMap == null) {
            realMap = new RealWorldMap();
        }
        realMap.display();
    }
}