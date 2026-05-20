package edu.pradita.oop.session12.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * FLYWEIGHT FACTORY — The manager that shares models.
 *
 * WHY A FACTORY?
 * If every part of the game creates NPCModel directly using `new`,
 * then the same skin will be duplicated many times in memory.
 *
 * The factory ensures:
 * - if a model already exists, reuse it
 * - if not, create it once and store it
 *
 * This is the heart of Flyweight.
 *
 * DO: Use a Map to cache shared flyweight objects.
 * DO: Return existing objects when available.
 * DONT: Always create new NPCModel blindly.
 */
public class NPCFactory {

    // TODO F2.1
    // Declare a private final Map:
    // key = String skin name
    // value = NPCModel
    // Initialize it with new HashMap<>()
    private final Map<String, NPCModel> modelPool = new HashMap<>();

    // TODO F2.2
    // Implement getModel(String skinName).
    //
    // Logic:
    // 1. If modelPool does NOT contain the given skinName,
    // create a new NPCModel and store it.
    // 2. Return the shared model from the pool.
    //
    // HINT:
    // You may use containsKey() + put() + get(),
    // or computeIfAbsent() if you already know it.
    public NPCModel getModel(String skinName) {
        if (!modelPool.containsKey(skinName)) {
            modelPool.put(skinName, new NPCModel(skinName));
        }
        return modelPool.get(skinName);
    }

    // TODO F2.3
    // Add a helper method getTotalSharedModels().
    // This returns how many unique models are currently stored.
    public int getTotalSharedModels() {
        return modelPool.size();
    }
}