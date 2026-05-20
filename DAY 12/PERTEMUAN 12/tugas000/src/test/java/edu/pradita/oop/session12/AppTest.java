package edu.pradita.oop.session12;

import edu.pradita.oop.session12.facade.ColabFacade;
import edu.pradita.oop.session12.flyweight.NPC;
import edu.pradita.oop.session12.flyweight.NPCFactory;
import edu.pradita.oop.session12.flyweight.NPCModel;
import edu.pradita.oop.session12.proxy.MapInterface;
import edu.pradita.oop.session12.proxy.MapProxy;
import edu.pradita.oop.session12.proxy.RealWorldMap;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

class Session12Test {

    // ══════════════════════════════════════════════════════════════════
    // FLYWEIGHT TESTS
    // Verifies shared intrinsic state, unique extrinsic state,
    // and correct factory pooling behavior.
    // ══════════════════════════════════════════════════════════════════

    @Test
    void npcModelShouldStoreSkinName() {
        NPCModel model = new NPCModel("GoblinGreen.png");
        assertTrue(model.getSkinName().equals("GoblinGreen.png"));
    }

    @Test
    void factoryShouldReuseSameModelForSameSkin() {
        NPCFactory factory = new NPCFactory();

        NPCModel model1 = factory.getModel("GoblinGreen.png");
        NPCModel model2 = factory.getModel("GoblinGreen.png");

        assertTrue(model1 == model2);
    }

    @Test
    void factoryShouldCreateDifferentModelsForDifferentSkins() {
        NPCFactory factory = new NPCFactory();

        NPCModel goblin = factory.getModel("GoblinGreen.png");
        NPCModel orc = factory.getModel("OrcBrown.png");

        assertTrue(goblin != orc);
    }

    @Test
    void factoryShouldCountOnlyUniqueSharedModels() {
        NPCFactory factory = new NPCFactory();

        factory.getModel("GoblinGreen.png");
        factory.getModel("GoblinGreen.png");
        factory.getModel("OrcBrown.png");
        factory.getModel("GoblinGreen.png");
        factory.getModel("ElfBlue.png");

        assertTrue(factory.getTotalSharedModels() == 3);
    }

    @Test
    void npcShouldStoreExtrinsicCoordinates() {
        NPCModel model = new NPCModel("GoblinGreen.png");
        NPC npc = new NPC(model, 10, 20);

        assertTrue(npc.getX() == 10);
        assertTrue(npc.getY() == 20);
    }

    @Test
    void npcShouldReferenceAssignedModel() {
        NPCModel model = new NPCModel("GoblinGreen.png");
        NPC npc = new NPC(model, 5, 15);

        assertTrue(npc.getModel() == model);
    }

    @Test
    void differentNpcsCanShareSameModelButHaveDifferentPositions() {
        NPCFactory factory = new NPCFactory();
        NPCModel sharedModel = factory.getModel("GoblinGreen.png");

        NPC npc1 = new NPC(sharedModel, 10, 20);
        NPC npc2 = new NPC(sharedModel, 99, 77);

        assertTrue(npc1.getModel() == npc2.getModel());
        assertTrue(npc1.getX() != npc2.getX());
        assertTrue(npc1.getY() != npc2.getY());
    }

    @Test
    void npcRenderShouldPrintCoordinatesAndSkin() {
        NPCModel model = new NPCModel("GoblinGreen.png");
        NPC npc = new NPC(model, 10, 20);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream original = System.out;
        System.setOut(new PrintStream(out));

        npc.render();

        System.setOut(original);

        String result = out.toString();
        assertTrue(result.contains("10"));
        assertTrue(result.contains("20"));
        assertTrue(result.contains("GoblinGreen.png"));
    }

    // ══════════════════════════════════════════════════════════════════
    // FACADE TESTS
    // Verifies that the facade hides subsystem complexity and
    // starts the cloud session in the correct orchestration flow.
    // ══════════════════════════════════════════════════════════════════

    @Test
    void colabFacadeShouldBeConstructable() {
        ColabFacade colab = new ColabFacade();
        assertTrue(colab != null);
    }

    @Test
    void startSessionShouldRunWithoutErrors() {
        ColabFacade colab = new ColabFacade();
        colab.startSession();

        assertTrue(true);
    }

    @Test
    void startSessionShouldPrintGpuStorageKernelAndReadyMessages() {
        ColabFacade colab = new ColabFacade();

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream original = System.out;
        System.setOut(new PrintStream(out));

        colab.startSession();

        System.setOut(original);

        String result = out.toString();
        assertTrue(result.contains("GPU allocated"));
        assertTrue(result.contains("Storage mounted"));
        assertTrue(result.contains("Kernel started"));
        assertTrue(result.contains("Cloud session ready"));
    }

    @Test
    void startSessionShouldPrintMessagesInCorrectOrder() {
        ColabFacade colab = new ColabFacade();

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream original = System.out;
        System.setOut(new PrintStream(out));

        colab.startSession();

        System.setOut(original);

        String result = out.toString();

        int gpuIndex = result.indexOf("GPU allocated");
        int storageIndex = result.indexOf("Storage mounted");
        int kernelIndex = result.indexOf("Kernel started");
        int readyIndex = result.indexOf("Cloud session ready");

        assertTrue(gpuIndex != -1);
        assertTrue(storageIndex != -1);
        assertTrue(kernelIndex != -1);
        assertTrue(readyIndex != -1);
        assertTrue(gpuIndex < storageIndex);
        assertTrue(storageIndex < kernelIndex);
        assertTrue(kernelIndex < readyIndex);
    }

    // ══════════════════════════════════════════════════════════════════
    // PROXY TESTS
    // Verifies lazy initialization and reuse of the real heavy object.
    // ══════════════════════════════════════════════════════════════════

    @Test
    void mapProxyShouldBeUsableThroughInterface() {
        MapInterface map = new MapProxy();
        assertTrue(map != null);
    }

    @Test
    void realWorldMapShouldDisplayNormally() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream original = System.out;
        System.setOut(new PrintStream(out));

        RealWorldMap map = new RealWorldMap();
        map.display();

        System.setOut(original);

        String result = out.toString();
        assertTrue(result.contains("Loading heavy real-world map..."));
        assertTrue(result.contains("Displaying real-world map"));
    }

    @Test
    void proxyShouldLoadRealMapOnlyWhenDisplayIsCalled() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream original = System.out;
        System.setOut(new PrintStream(out));

        MapProxy proxy = new MapProxy();

        System.setOut(original);

        String result = out.toString();

        // Constructor of proxy should NOT trigger heavy map loading
        assertTrue(!result.contains("Loading heavy real-world map..."));
    }

    @Test
    void firstDisplayCallShouldLoadAndDisplayRealMap() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream original = System.out;
        System.setOut(new PrintStream(out));

        MapProxy proxy = new MapProxy();
        proxy.display();

        System.setOut(original);

        String result = out.toString();
        assertTrue(result.contains("Loading heavy real-world map..."));
        assertTrue(result.contains("Displaying real-world map"));
    }

    @Test
    void secondDisplayCallShouldNotReloadHeavyMap() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream original = System.out;
        System.setOut(new PrintStream(out));

        MapProxy proxy = new MapProxy();
        proxy.display();
        proxy.display();

        System.setOut(original);

        String result = out.toString();

        int firstLoad = result.indexOf("Loading heavy real-world map...");
        int lastLoad = result.lastIndexOf("Loading heavy real-world map...");

        assertTrue(firstLoad != -1);
        assertTrue(firstLoad == lastLoad);
    }

    @Test
    void proxyShouldDisplayMapEveryTimeAfterInitialization() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream original = System.out;
        System.setOut(new PrintStream(out));

        MapProxy proxy = new MapProxy();
        proxy.display();
        proxy.display();

        System.setOut(original);

        String result = out.toString();

        int firstDisplay = result.indexOf("Displaying real-world map");
        int lastDisplay = result.lastIndexOf("Displaying real-world map");

        assertTrue(firstDisplay != -1);
        assertTrue(lastDisplay != -1);
        assertTrue(firstDisplay != lastDisplay);
    }
}