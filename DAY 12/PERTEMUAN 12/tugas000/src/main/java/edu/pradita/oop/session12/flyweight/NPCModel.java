package edu.pradita.oop.session12.flyweight;

/**
 * FLYWEIGHT PATTERN — Shared intrinsic state.
 *
 * WHAT IS INTRINSIC STATE?
 * Intrinsic state is the heavy data that can be SHARED by many objects.
 * In this case, the heavy shared data is the NPC skin / texture name.
 *
 * EXAMPLE:
 * 100 forest goblins may all use the same "GoblinGreen.png" skin.
 * The skin should exist once in memory, not 100 times.
 *
 * DO: Put shared/heavy data here.
 * DO: Reuse the same NPCModel object for many NPC instances.
 * DONT: Put x/y position here — that belongs to each NPC individually.
 */
public class NPCModel {

    // TODO F1.1
    // Declare one private final field:
    // skinName (String)
    // This represents the shared texture/skin for many NPCs.
    private final String skinName;

    // TODO F1.2
    // Complete the constructor.
    // Store the given skinName into the field.
    public NPCModel(String skinName) {
        this.skinName = skinName;
    }

    // TODO F1.3
    // Create a getter for skinName.
    public String getSkinName() {
        return skinName;
    }
}