package edu.pradita.oop.session10.prototype;

import java.util.Arrays;

/**
 * Dragon — boss enemy. Very high stats, rare drop.
 *
 * DEEP COPY LESSON:
 * Dragon adds a String[] spells field — an array is a reference type.
 *
 * WHY SHALLOW COPY BREAKS HERE:
 * dragon2 = dragon1.clone() // shallow: dragon2.spells points to the SAME array
 * dragon2.getSpells()[0] = "Ice" // also changes dragon1.spells[0] — BUG!
 * → two "independent" enemies now share state. Nightmare to debug.
 *
 * WHY DEEP COPY FIXES IT:
 * this.spells = Arrays.copyOf(source.spells, source.spells.length)
 * → brand new array in memory, fully independent from source.
 *
 * RULE: primitives and Strings are safe with shallow copy.
 * Arrays, Lists, and nested objects ALWAYS need deep copy.
 *
 * DO: Use Arrays.copyOf() or new ArrayList<>(source.list) for reference fields.
 * DONT: Assume this.spells = source.spells is a copy — it is just another
 * pointer.
 */
public class Dragon implements EnemyPrototype {

    // TODO 4.1
    // Declare six private fields:
    // name (String), hp (int), attackPower (int),
    // defence (int), drop (String), spells (String[])
    // spells is the reference field that requires deep copy.
    private String name;
    private int hp;
    private int attackPower;
    private int defence;
    private String drop;
    private String[] spells;

    // TODO 4.2
    // Base template constructor — fill in Dragon's stats and spells array.
    // name = "Dragon", hp = 5000, attackPower = 400,
    // defence = 250, drop = "Dragon Scale"
    // spells = {"Fire Breath", "Tail Swipe"}
    public Dragon() {
        this.name = "Dragon";
        this.hp = 5000;
        this.attackPower = 400;
        this.defence = 250;
        this.drop = "Dragon Scale";
        this.spells = new String[] { "Fire Breath", "Tail Swipe" };
    }

    // TODO 4.3
    // Private deep copy constructor.
    // Primitives and Strings can be copied directly (same as Goblin/Orc).
    // The spells array MUST be deep-copied using Arrays.copyOf().
    //
    // Fill in all six assignments.
    // For spells, use: Arrays.copyOf(source.spells, source.spells.length)
    private Dragon(Dragon source) {
        this.name = source.name;
        this.hp = source.hp;
        this.attackPower = source.attackPower;
        this.defence = source.defence;
        this.drop = source.drop;
        this.spells = Arrays.copyOf(source.spells, source.spells.length); // deep copy here
    }

    // TODO 4.4
    // Implement clone() using the private deep copy constructor.
    @Override
    public EnemyPrototype clone() {
        return new Dragon(this);
    }

    // TODO 4.5
    // Implement four fluent withX() methods.
    // withSpells() must also deep-copy the incoming array —
    // the caller's array should not be shared either.
    public Dragon withName(String name) {
        this.name = name;
        return this;
    }

    public Dragon withHp(int hp) {
        this.hp = hp;
        return this;
    }

    public Dragon withDrop(String drop) {
        this.drop = drop;
        return this;
    }

    public Dragon withSpells(String[] s) {
        this.spells = Arrays.copyOf(s, s.length); // deep copy
        return this;
    }

    // TODO 4.6
    // Implement displayStats() — print all fields including spells.
    // For spells, loop through the array and print each spell on the same line.
    @Override
    public void displayStats() {
        System.out.println("--- " + name + " ---");
        System.out.println("  HP     : " + hp);
        System.out.println("  ATK    : " + attackPower);
        System.out.println("  DEF    : " + defence);
        System.out.println("  Drop   : " + drop);
        System.out.print("  Spells : ");
        for (String s : spells)
            System.out.print(s + "  ");
        System.out.println();
    }

    // TODO 4.7
    // Implement all five @Override getters plus getSpells().
    // getSpells() is NOT in the interface — it is Dragon-specific,
    // used by the deep copy test to verify array independence.
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

    public String[] getSpells() {
        return spells;
    }
}