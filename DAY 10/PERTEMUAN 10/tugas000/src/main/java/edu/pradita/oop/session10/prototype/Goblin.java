package edu.pradita.oop.session10.prototype;

/**
 * Goblin — weak, fast enemy. Common dungeon fodder.
 *
 * PROTOTYPE in action:
 * The dungeon does NOT call `new Goblin()` for every enemy spawn.
 * It holds ONE goblinTemplate and calls goblinTemplate.clone()
 * so every spawned goblin starts from the same guaranteed base stats.
 *
 * If the base HP ever changes, you update it in ONE place (the template
 * constructor)
 * and every future clone automatically gets the new value.
 *
 * SHALLOW COPY is safe here because all fields are primitives (int) or Strings.
 * Strings in Java are immutable — sharing a reference is fine because
 * you can never modify the String object itself, only replace the reference.
 * See Dragon.java for a case where DEEP COPY is required.
 */
public class Goblin implements EnemyPrototype {

    // TODO 2.1
    // Declare five private fields:
    // name (String), hp (int), attackPower (int), defence (int), drop (String)
    // These are NOT final — clones need to be customizable after cloning
    // via the withX() methods below.
    private String name;
    private int hp;
    private int attackPower;
    private int defence;
    private String drop;

    // TODO 2.2
    // Base template constructor — defines the DEFAULT stats every Goblin starts
    // with.
    // This is the single source of truth for Goblin base stats.
    // Fill in all five values:
    // name = "Goblin", hp = 300, attackPower = 80, defence = 30, drop = "Gold Coin"
    //
    // Think: why do we put these defaults here instead of as field initializers?
    public Goblin() {
        this.name = "Goblin";
        this.hp = 300;
        this.attackPower = 80;
        this.defence = 30;
        this.drop = "Gold Coin";
    }

    // TODO 2.3
    // Private copy constructor — ONLY clone() calls this.
    // It receives the source Goblin and copies every field.
    //
    // WHY PRIVATE?
    // No one outside this class should be able to copy a Goblin manually.
    // clone() is the only sanctioned way to produce a copy.
    //
    // Fill in all five assignments from source.
    private Goblin(Goblin source) {
        this.name = source.name;
        this.hp = source.hp;
        this.attackPower = source.attackPower;
        this.defence = source.defence;
        this.drop = source.drop;
    }

    // TODO 2.4
    // Implement clone() — create and return a new Goblin using the copy
    // constructor.
    // The return type is EnemyPrototype (the interface), not Goblin.
    // This keeps the caller decoupled from the concrete class.
    @Override
    public EnemyPrototype clone() {
        return new Goblin(this);
    }

    // TODO 2.5
    // Implement the four fluent customization methods.
    // These are called AFTER cloning to personalize a specific spawn.
    // Example: a boss goblin clones the template then calls withHp(999).
    //
    // Each method must:
    // 1. Assign the parameter to the matching field.
    // 2. Return `this` so calls can be chained:
    // bossGoblin.withName("Goblin King").withHp(999).withDrop("Crown")
    //
    // Fill in the assignments and return statements.
    public Goblin withName(String name) {
        this.name = name;
        return this;
    }

    public Goblin withHp(int hp) {
        this.hp = hp;
        return this;
    }

    public Goblin withAttackPower(int atk) {
        this.attackPower = atk;
        return this;
    }

    public Goblin withDrop(String drop) {
        this.drop = drop;
        return this;
    }

    // TODO 2.6
    // Implement displayStats() — print all five fields in a readable format.
    @Override
    public void displayStats() {
        System.out.println("--- " + name + " ---");
        System.out.println("  HP   : " + hp);
        System.out.println("  ATK  : " + attackPower);
        System.out.println("  DEF  : " + defence);
        System.out.println("  Drop : " + drop);
    }

    // TODO 2.7
    // Implement all five getters from the EnemyPrototype interface.
    // Each must be annotated with @Override.
    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getHp() {
        return hp;
    }

    @Override
    public int getAttackPower() {
        return attackPower;
    }

    @Override
    public int getDefence() {
        return defence;
    }

    @Override
    public String getDrop() {
        return drop;
    }
}