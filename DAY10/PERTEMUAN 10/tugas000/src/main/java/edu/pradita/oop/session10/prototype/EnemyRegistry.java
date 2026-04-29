package edu.pradita.oop.session10.prototype;

import java.util.HashMap;
import java.util.Map;

/**
 * EnemyRegistry — stores master templates, hands out clones.
 *
 * WHY A REGISTRY?
 * Without it, every dungeon floor needs a direct reference to every template
 * object.
 * With the registry: register a template once by name, clone it by name from
 * anywhere.
 *
 * Think of it like a stamp collection:
 * register() = add a new stamp design to the collection.
 * getClone() = press the stamp to get a fresh imprint — the stamp itself never
 * changes.
 *
 * DO: Always return a CLONE from getClone(), never the template itself.
 * DO: Throw a clear exception when an unknown name is requested.
 * DONT: Return the raw template — a caller could modify it and corrupt
 * every future clone that is based on that template.
 */
public class EnemyRegistry {

    // TODO 5.1
    // Declare a private final Map that stores templates by name.
    // Key: String (enemy name), Value: EnemyPrototype (the template).
    // Initialize it as a new HashMap.
    private final Map<String, EnemyPrototype> templates = new HashMap<>();

    // TODO 5.2
    // Implement register() — store the prototype under the given name.
    // Use the Map's put() method.
    // After this call, getClone(name) must return clones of this prototype.
    public void register(String name, EnemyPrototype prototype) {
        templates.put(name, prototype);
    }

    // TODO 5.3
    // Implement getClone() — retrieve the template by name and return a CLONE.
    //
    // Steps:
    // 1. Look up the template using templates.get(name).
    // 2. If the result is null, the name was never registered —
    // throw new IllegalArgumentException("Unknown enemy: " + name)
    // 3. Call clone() on the template and return the result.
    //
    // WHY NOT return the template directly?
    // If we returned the template, a caller could call withHp(1) on it,
    // permanently corrupting the base stats for every future spawn.
    public EnemyPrototype getClone(String name) {
        EnemyPrototype template = templates.get(name);
        if (template == null)
            throw new IllegalArgumentException("Unknown enemy: " + name);
        return template.clone();
    }
}