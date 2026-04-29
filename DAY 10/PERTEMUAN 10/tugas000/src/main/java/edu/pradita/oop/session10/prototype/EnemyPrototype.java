package edu.pradita.oop.session10.prototype;

/**
 * PROTOTYPE PATTERN — The clone() contract.
 *
 * WHY AN INTERFACE?
 * The dungeon spawner only needs to know two things about any enemy:
 * 1. It can be cloned → clone()
 * 2. It can display itself → displayStats()
 * It does NOT need to know whether it is a Goblin, Orc, or Dragon.
 * This means you can add a new enemy type without touching the spawner at all.
 *
 * DO: Define clone() here so the spawner depends on the abstraction,
 * not on Goblin, Orc, or Dragon directly.
 * DO: Always return a fully independent copy from clone() —
 * modifying a clone must NEVER affect the original template.
 * DONT: Use Prototype when every object is fundamentally different —
 * just use constructors instead.
 * DONT: Use Prototype when you need step-by-step configuration —
 * use Builder instead (see CharacterAppearance).
 */
public interface EnemyPrototype {

    // TODO 1.1
    // Declare the clone() method.
    // Return type is EnemyPrototype — the caller gets back an interface reference,
    // not a concrete Goblin or Dragon. This keeps the spawner decoupled.
    EnemyPrototype clone();

    // TODO 1.2
    // Declare displayStats() — no parameters, no return value.
    // Every enemy must be able to print its own stats.
    void displayStats();

    // TODO 1.3
    // Declare the five getters below.
    // Tests use these to verify clone values without calling displayStats().
    // Fill in the return types.
    String getName();

    int getHp();

    int getAttackPower();

    int getDefence();

    String getDrop();
}