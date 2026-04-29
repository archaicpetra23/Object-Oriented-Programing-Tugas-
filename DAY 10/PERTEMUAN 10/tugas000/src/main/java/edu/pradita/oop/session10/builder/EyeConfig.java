package edu.pradita.oop.session10.builder;

/**
 * Represents detailed eye configuration for a character.
 *
 * WHY A SEPARATE CLASS?
 * Eyes have multiple sub-fields (color + shape).
 * If we put eyeColor and eyeShape directly into CharacterAppearance.Builder,
 * we add two more loose parameters that have no obvious relationship to each
 * other.
 * Grouping them here makes the Builder cleaner and the intent clearer.
 *
 * DO: Group related optional sub-fields into their own small class.
 * DONT: Flatten every sub-field into the parent Builder as separate params.
 */
public class EyeConfig {

    // TODO 1.1
    // Declare two private final fields:
    // - color (String) — e.g. "Blue", "Brown", "Red"
    // - shape (String) — e.g. "Almond", "Round", "Narrow"
    // These are final because EyeConfig is immutable once created.
    private final String color;
    private final String shape;

    // TODO 1.2
    // Complete the constructor.
    // Both color and shape are mandatory for EyeConfig — assign them to fields.
    // Ask yourself: why are there no optional fields here?
    public EyeConfig(String color, String shape) {
        this.color = color;
        this.shape = shape;
    }

    // TODO 1.3
    // Provide getters for both fields.
    // Getters let CharacterAppearance.display() and the tests read the values
    // without exposing the fields directly.
    public String getColor() {
        return color;
    }

    public String getShape() {
        return shape;
    }

    // TODO 1.4
    // Override toString() to return a human-readable description.
    // Example output: "Almond eyes, color: Blue"
    // This is used by CharacterAppearance.display() when printing eye info.
    @Override
    public String toString() {
        return shape + " eyes, color: " + color;
    }
}