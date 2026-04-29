package edu.pradita.oop.session10.prototype;

/**
 * Orc — heavy, slow enemy. High HP and defence.
 *
 * This class follows the exact same Prototype structure as Goblin.
 * After completing Goblin, try to fill this one with less guidance.
 *
 * Base stats:
 * name = "Orc", hp = 800, attackPower = 150, defence = 100, drop = "Iron Ore"
 */
public class Orc implements EnemyPrototype {

    // TODO 3.1
    // Declare five private fields — same types as Goblin.
    private String name;
    private int hp;
    private int attackPower;
    private int defence;
    private String drop;

    // TODO 3.2
    // Base template constructor — fill in all five Orc base stats.
    public Orc() {
        this.name = "Orc";
        this.hp = 800;
        this.attackPower = 150;
        this.defence = 100;
        this.drop = "Iron Ore";
    }

    // TODO 3.3
    // Private copy constructor — copy all five fields from source.
    // Same pattern as Goblin. Why must this be private?
    private Orc(Orc source) {
        this.name = source.name;
        this.hp = source.hp;
        this.attackPower = source.attackPower;
        this.defence = source.defence;
        this.drop = source.drop;
    }

    // TODO 3.4
    // Implement clone() using the private copy constructor.
    @Override
    public EnemyPrototype clone() {
        return new Orc(this);
    }

    // TODO 3.5
    // Implement four fluent withX() methods, each returning `this`.
    public Orc withName(String name) {
        this.name = name;
        return this;
    }

    public Orc withHp(int hp) {
        this.hp = hp;
        return this;
    }

    public Orc withAttackPower(int atk) {
        this.attackPower = atk;
        return this;
    }

    public Orc withDrop(String drop) {
        this.drop = drop;
        return this;
    }

    // TODO 3.6
    // Implement displayStats() — same format as Goblin.
    @Override
    public void displayStats() {
        System.out.println("--- " + name + " ---");
        System.out.println("  HP   : " + hp);
        System.out.println("  ATK  : " + attackPower);
        System.out.println("  DEF  : " + defence);
        System.out.println("  Drop : " + drop);
    }

    // TODO 3.7
    // Implement all five @Override getters.
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