package edu.pradita.oop.session10;

import edu.pradita.oop.session10.builder.CharacterAppearance;
import edu.pradita.oop.session10.builder.EyeConfig;
import edu.pradita.oop.session10.prototype.Dragon;
import edu.pradita.oop.session10.prototype.EnemyPrototype;
import edu.pradita.oop.session10.prototype.EnemyRegistry;
import edu.pradita.oop.session10.prototype.Goblin;
import edu.pradita.oop.session10.prototype.Orc;

public class App {

    public static void main(String[] args) {

        // ══════════════════════════════════════════════════════════
        // BUILDER — Character Creation Screen
        // Use Builder when: building ONE unique object step by step
        //                   with many optional fields.
        // ══════════════════════════════════════════════════════════
        System.out.println("╔══════════════════════════════╗");
        System.out.println("║   CHARACTER CREATION SCREEN  ║");
        System.out.println("╚══════════════════════════════╝");

        // Fully customised character — only set what you want
        CharacterAppearance hero = new CharacterAppearance.Builder("Andi")
                .hairStyle(3)
                .upperBody(2)
                .lowerBody(4)
                .eyeConfig(new EyeConfig("Blue", "Almond"))
                .skinTone("Tan")
                .build();
        hero.display();
        System.out.println();

        // Minimal character — only name, everything else defaults
        CharacterAppearance defaultChar = new CharacterAppearance.Builder("Budi")
                .build();
        defaultChar.display();
        System.out.println();

        // ══════════════════════════════════════════════════════════
        // PROTOTYPE — NPC Enemy Spawner
        // Use Prototype when: creating MANY similar objects from
        //                     one shared base template.
        // ══════════════════════════════════════════════════════════
        System.out.println("╔══════════════════════════════╗");
        System.out.println("║      DUNGEON ENEMY SPAWNER   ║");
        System.out.println("╚══════════════════════════════╝");

        // Register master templates once
        EnemyRegistry registry = new EnemyRegistry();
        registry.register("goblin", new Goblin());
        registry.register("orc",    new Orc());
        registry.register("dragon", new Dragon());

        // Spawn regular goblins — each is an independent clone
        EnemyPrototype goblin1 = registry.getClone("goblin");
        EnemyPrototype goblin2 = registry.getClone("goblin");
        goblin1.displayStats();
        goblin2.displayStats();
        System.out.println();

        // Spawn a boss goblin — clone then customise, template unchanged
        Goblin bossGoblin = (Goblin) registry.getClone("goblin");
        bossGoblin.withName("Goblin King")
                  .withHp(999)
                  .withAttackPower(200)
                  .withDrop("Golden Crown");
        bossGoblin.displayStats();
        System.out.println();

        // Spawn dragon
        EnemyPrototype dragon1 = registry.getClone("dragon");
        dragon1.displayStats();
    }
}
