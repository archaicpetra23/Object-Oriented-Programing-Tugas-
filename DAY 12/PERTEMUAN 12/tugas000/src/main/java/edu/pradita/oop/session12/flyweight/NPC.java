package edu.pradita.oop.session12.flyweight;

/**
 * Context object — stores extrinsic state.
 *
 * WHAT IS EXTRINSIC STATE?
 * Extrinsic state is the unique data for each NPC.
 * Here, each NPC has its own x and y coordinates.
 *
 * IMPORTANT:
 * NPC does NOT own the heavy skin data directly.
 * It only holds a reference to the shared NPCModel object.
 *
 * DO: Keep unique per-object data here.
 * DO: Reference the shared model instead of duplicating it.
 * DONT: Copy the skin string again into this class.
 */
public class NPC {

    // TODO F3.1
    // Declare fields:
    // model (NPCModel) — shared flyweight reference
    // x (int) — unique position
    // y (int) — unique position
    private final NPCModel model;
    private final int x;
    private final int y;

    // TODO F3.2
    // Complete constructor assignment.
    public NPC(NPCModel model, int x, int y) {
        this.model = model;
        this.x = x;
        this.y = y;
    }

    // TODO F3.3
    // Create getters for model, x, and y.
    public NPCModel getModel() {
        return model;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    // TODO F3.4
    // Implement render().
    // Print format:
    // NPC at (10, 20) using skin: GoblinGreen.png
    public void render() {
        System.out.println("NPC at (" + x + ", " + y + ") using skin: " + model.getSkinName());
    }
}