package edu.pradita.oop.session12;

import edu.pradita.oop.session12.facade.ColabFacade;
import edu.pradita.oop.session12.flyweight.NPC;
import edu.pradita.oop.session12.flyweight.NPCFactory;
import edu.pradita.oop.session12.flyweight.NPCModel;
import edu.pradita.oop.session12.proxy.MapInterface;
import edu.pradita.oop.session12.proxy.MapProxy;

/**
 * WEEK 12 SHOWCASE APP
 *
 * This main class demonstrates:
 * 1. Flyweight → shared NPC models
 * 2. Facade → one-button cloud session startup
 * 3. Proxy → lazy map loading
 */
public class App {

    public static void main(String[] args) {

        System.out.println("=== FLYWEIGHT ===");

        // TODO APP1
        // Create NPCFactory.
        NPCFactory factory = new NPCFactory();

        // TODO APP2
        // Request the same shared model twice using skin name "GoblinGreen.png".
        NPCModel goblinModel1 = factory.getModel("GoblinGreen.png");
        NPCModel goblinModel2 = factory.getModel("GoblinGreen.png");

        // TODO APP3
        // Create two NPCs with the same shared model but different coordinates.
        NPC npc1 = new NPC(goblinModel1, 10, 20);
        NPC npc2 = new NPC(goblinModel2, 30, 40);

        npc1.render();
        npc2.render();

        // TODO APP4
        // Print whether both NPCs share the same model object using ==.
        System.out.println("Shared model object? " + (goblinModel1 == goblinModel2));

        // TODO APP5
        // Print total unique shared models from factory.
        System.out.println("Total shared models: " + factory.getTotalSharedModels());

        System.out.println();
        System.out.println("=== FACADE ===");

        // TODO APP6
        // Create ColabFacade and start session using one method call.
        ColabFacade colab = new ColabFacade();
        colab.startSession();

        System.out.println();
        System.out.println("=== PROXY ===");

        // TODO APP7
        // Create MapProxy using the interface type.
        MapInterface map = new MapProxy();

        // TODO APP8
        // Call display() twice.
        // The heavy loading message should appear only once.
        map.display();
        map.display();
    }
}