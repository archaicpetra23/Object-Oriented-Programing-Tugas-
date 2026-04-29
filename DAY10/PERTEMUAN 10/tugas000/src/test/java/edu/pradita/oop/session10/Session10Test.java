package edu.pradita.oop.session10;

import edu.pradita.oop.session10.builder.CharacterAppearance;
import edu.pradita.oop.session10.builder.EyeConfig;
import edu.pradita.oop.session10.prototype.Dragon;
import edu.pradita.oop.session10.prototype.EnemyPrototype;
import edu.pradita.oop.session10.prototype.EnemyRegistry;
import edu.pradita.oop.session10.prototype.Goblin;
import edu.pradita.oop.session10.prototype.Orc;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Session10Test {

    // ══════════════════════════════════════════════════════════════════
    // EYECONFIG TESTS
    // Verifies that EyeConfig stores color and shape correctly.
    // ══════════════════════════════════════════════════════════════════

    @Test
    void eyeConfig_shouldStoreColor() {
        EyeConfig eyes = new EyeConfig("Blue", "Almond");
        assertEquals("Blue", eyes.getColor());
    }

    @Test
    void eyeConfig_shouldStoreShape() {
        EyeConfig eyes = new EyeConfig("Brown", "Round");
        assertEquals("Round", eyes.getShape());
    }

    @Test
    void eyeConfig_toStringShouldContainBothFields() {
        EyeConfig eyes = new EyeConfig("Green", "Narrow");
        String result = eyes.toString();
        assertTrue(result.contains("Green"));
        assertTrue(result.contains("Narrow"));
    }

    // ══════════════════════════════════════════════════════════════════
    // CHARACTERAPPEARANCE BUILDER TESTS
    // Verifies mandatory fields, optional defaults, full customization,
    // and that two Builder calls produce independent objects.
    // ══════════════════════════════════════════════════════════════════

    @Test
    void builder_shouldSetMandatoryName() {
        // name is mandatory — supplied in Builder constructor
        CharacterAppearance c = new CharacterAppearance.Builder("Andi").build();
        assertEquals("Andi", c.getName());
    }

    @Test
    void builder_shouldApplyDefaultHairStyle() {
        // hairStyle defaults to 1 when not explicitly set
        CharacterAppearance c = new CharacterAppearance.Builder("Budi").build();
        assertEquals(1, c.getHairStyle());
    }

    @Test
    void builder_shouldApplyDefaultUpperBody() {
        CharacterAppearance c = new CharacterAppearance.Builder("Budi").build();
        assertEquals(1, c.getUpperBody());
    }

    @Test
    void builder_shouldApplyDefaultLowerBody() {
        CharacterAppearance c = new CharacterAppearance.Builder("Budi").build();
        assertEquals(1, c.getLowerBody());
    }

    @Test
    void builder_shouldApplyDefaultSkinTone() {
        // skinTone defaults to "Fair"
        CharacterAppearance c = new CharacterAppearance.Builder("Budi").build();
        assertEquals("Fair", c.getSkinTone());
    }

    @Test
    void builder_shouldApplyNullDefaultEyeConfig() {
        // eyeConfig is null by default — player skipped eye customisation
        CharacterAppearance c = new CharacterAppearance.Builder("Budi").build();
        assertNull(c.getEyeConfig());
    }

    @Test
    void builder_shouldSetHairStyle() {
        CharacterAppearance c = new CharacterAppearance.Builder("Cici")
                .hairStyle(4)
                .build();
        assertEquals(4, c.getHairStyle());
    }

    @Test
    void builder_shouldSetUpperBody() {
        CharacterAppearance c = new CharacterAppearance.Builder("Cici")
                .upperBody(3)
                .build();
        assertEquals(3, c.getUpperBody());
    }

    @Test
    void builder_shouldSetLowerBody() {
        CharacterAppearance c = new CharacterAppearance.Builder("Cici")
                .lowerBody(5)
                .build();
        assertEquals(5, c.getLowerBody());
    }

    @Test
    void builder_shouldSetSkinTone() {
        CharacterAppearance c = new CharacterAppearance.Builder("Cici")
                .skinTone("Tan")
                .build();
        assertEquals("Tan", c.getSkinTone());
    }

    @Test
    void builder_shouldSetEyeConfig() {
        EyeConfig eyes = new EyeConfig("Blue", "Almond");
        CharacterAppearance c = new CharacterAppearance.Builder("Cici")
                .eyeConfig(eyes)
                .build();
        assertNotNull(c.getEyeConfig());
        assertEquals("Blue",   c.getEyeConfig().getColor());
        assertEquals("Almond", c.getEyeConfig().getShape());
    }

    @Test
    void builder_shouldApplyAllFieldsTogether() {
        // Full customization — all optional fields set
        CharacterAppearance c = new CharacterAppearance.Builder("Dodi")
                .hairStyle(3)
                .upperBody(2)
                .lowerBody(4)
                .eyeConfig(new EyeConfig("Red", "Sharp"))
                .skinTone("Dark")
                .build();
        assertEquals("Dodi",  c.getName());
        assertEquals(3,       c.getHairStyle());
        assertEquals(2,       c.getUpperBody());
        assertEquals(4,       c.getLowerBody());
        assertEquals("Red",   c.getEyeConfig().getColor());
        assertEquals("Sharp", c.getEyeConfig().getShape());
        assertEquals("Dark",  c.getSkinTone());
    }

    @Test
    void builder_twoBuildsAreIndependentObjects() {
        // Two separate build() calls must produce two separate objects
        CharacterAppearance c1 = new CharacterAppearance.Builder("X").hairStyle(2).build();
        CharacterAppearance c2 = new CharacterAppearance.Builder("Y").hairStyle(5).build();
        assertNotSame(c1, c2);
        assertNotEquals(c1.getHairStyle(), c2.getHairStyle());
        assertNotEquals(c1.getName(),      c2.getName());
    }

    @Test
    void builder_settingOneFieldDoesNotAffectOthers() {
        // Setting only skinTone must leave all other fields at defaults
        CharacterAppearance c = new CharacterAppearance.Builder("Eka")
                .skinTone("Olive")
                .build();
        assertEquals(1,       c.getHairStyle());
        assertEquals(1,       c.getUpperBody());
        assertEquals(1,       c.getLowerBody());
        assertNull(c.getEyeConfig());
        assertEquals("Olive", c.getSkinTone());
    }

    // ══════════════════════════════════════════════════════════════════
    // GOBLIN PROTOTYPE TESTS
    // Verifies base stats, clone independence from template,
    // and clone independence from other clones.
    // ══════════════════════════════════════════════════════════════════

    @Test
    void goblin_cloneShouldHaveBaseName() {
        EnemyPrototype clone = new Goblin().clone();
        assertEquals("Goblin", clone.getName());
    }

    @Test
    void goblin_cloneShouldHaveBaseHp() {
        EnemyPrototype clone = new Goblin().clone();
        assertEquals(300, clone.getHp());
    }

    @Test
    void goblin_cloneShouldHaveBaseAttackPower() {
        EnemyPrototype clone = new Goblin().clone();
        assertEquals(80, clone.getAttackPower());
    }

    @Test
    void goblin_cloneShouldHaveBaseDefence() {
        EnemyPrototype clone = new Goblin().clone();
        assertEquals(30, clone.getDefence());
    }

    @Test
    void goblin_cloneShouldHaveBaseDrop() {
        EnemyPrototype clone = new Goblin().clone();
        assertEquals("Gold Coin", clone.getDrop());
    }

    @Test
    void goblin_modifyingCloneDoesNotAffectTemplate() {
        Goblin template = new Goblin();
        Goblin clone    = (Goblin) template.clone();
        clone.withHp(999).withName("Goblin King");

        // template must be completely unchanged
        assertEquals(300,     template.getHp());
        assertEquals("Goblin",template.getName());
    }

    @Test
    void goblin_modifyingTemplateDoesNotAffectExistingClone() {
        // Simulate: template changes AFTER a clone was made
        // Clone should be unaffected because it is an independent copy
        Goblin template = new Goblin();
        Goblin clone    = (Goblin) template.clone();
        template.withHp(1);  // template gets weakened

        assertEquals(300, clone.getHp());  // clone keeps original value
    }

    @Test
    void goblin_twoClonesAreIndependentOfEachOther() {
        Goblin template = new Goblin();
        Goblin clone1   = (Goblin) template.clone();
        Goblin clone2   = (Goblin) template.clone();
        clone1.withHp(500);

        // clone2 must be unaffected by change to clone1
        assertEquals(300, clone2.getHp());
        assertNotSame(clone1, clone2);
    }

    @Test
    void goblin_cloneIsNotSameObjectAsTemplate() {
        Goblin template = new Goblin();
        Goblin clone    = (Goblin) template.clone();
        assertNotSame(template, clone);
    }

    // ══════════════════════════════════════════════════════════════════
    // ORC PROTOTYPE TESTS
    // Same independence guarantees as Goblin, different base stats.
    // ══════════════════════════════════════════════════════════════════

    @Test
    void orc_cloneShouldHaveBaseName() {
        assertEquals("Orc", new Orc().clone().getName());
    }

    @Test
    void orc_cloneShouldHaveBaseHp() {
        assertEquals(800, new Orc().clone().getHp());
    }

    @Test
    void orc_cloneShouldHaveBaseAttackPower() {
        assertEquals(150, new Orc().clone().getAttackPower());
    }

    @Test
    void orc_cloneShouldHaveBaseDefence() {
        assertEquals(100, new Orc().clone().getDefence());
    }

    @Test
    void orc_cloneShouldHaveBaseDrop() {
        assertEquals("Iron Ore", new Orc().clone().getDrop());
    }

    @Test
    void orc_modifyingCloneDoesNotAffectTemplate() {
        Orc template = new Orc();
        Orc clone    = (Orc) template.clone();
        clone.withHp(9999).withName("Orc Warlord");

        assertEquals(800,   template.getHp());
        assertEquals("Orc", template.getName());
    }

    @Test
    void orc_twoClonesAreIndependent() {
        Orc clone1 = (Orc) new Orc().clone();
        Orc clone2 = (Orc) new Orc().clone();
        clone1.withHp(100);

        assertEquals(800, clone2.getHp());
        assertNotSame(clone1, clone2);
    }

    // ══════════════════════════════════════════════════════════════════
    // DRAGON DEEP COPY TESTS
    // Verifies that the spells array is deep-copied so modifying
    // a clone's array does not affect the template or other clones.
    // ══════════════════════════════════════════════════════════════════

    @Test
    void dragon_cloneShouldHaveBaseHp() {
        assertEquals(5000, new Dragon().clone().getHp());
    }

    @Test
    void dragon_cloneShouldHaveBaseDrop() {
        assertEquals("Dragon Scale", new Dragon().clone().getDrop());
    }

    @Test
    void dragon_cloneShouldHaveBaseSpells() {
        Dragon clone = (Dragon) new Dragon().clone();
        assertEquals("Fire Breath", clone.getSpells()[0]);
        assertEquals("Tail Swipe",  clone.getSpells()[1]);
    }

    @Test
    void dragon_modifyingCloneSpellsDoesNotAffectTemplate() {
        // THE KEY DEEP COPY TEST
        // If deep copy is implemented correctly, changing clone's array
        // must NOT change the template's array.
        Dragon template = new Dragon();
        Dragon clone    = (Dragon) template.clone();
        clone.getSpells()[0] = "Ice Beam";  // mutate clone's array slot

        assertEquals("Fire Breath", template.getSpells()[0]); // template unchanged
    }

    @Test
    void dragon_modifyingTemplateSpellsDoesNotAffectClone() {
        Dragon template = new Dragon();
        Dragon clone    = (Dragon) template.clone();
        template.getSpells()[0] = "Shadow Fire";  // mutate template after cloning

        assertEquals("Fire Breath", clone.getSpells()[0]); // clone unchanged
    }

    @Test
    void dragon_twoClonesHaveIndependentSpellArrays() {
        Dragon clone1 = (Dragon) new Dragon().clone();
        Dragon clone2 = (Dragon) new Dragon().clone();
        clone1.getSpells()[0] = "Blizzard";

        assertEquals("Fire Breath", clone2.getSpells()[0]); // clone2 unaffected
    }

    // ══════════════════════════════════════════════════════════════════
    // ENEMYREGISTRY TESTS
    // Verifies that the registry always returns clones (never the
    // template itself), and handles unknown names gracefully.
    // ══════════════════════════════════════════════════════════════════

    @Test
    void registry_shouldReturnCorrectEnemyType() {
        EnemyRegistry registry = new EnemyRegistry();
        registry.register("goblin", new Goblin());
        EnemyPrototype clone = registry.getClone("goblin");
        assertEquals("Goblin", clone.getName());
    }

    @Test
    void registry_eachCallReturnsANewObject() {
        // getClone() must return a different object instance every time
        EnemyRegistry registry = new EnemyRegistry();
        registry.register("goblin", new Goblin());
        EnemyPrototype c1 = registry.getClone("goblin");
        EnemyPrototype c2 = registry.getClone("goblin");
        assertNotSame(c1, c2);
    }

    @Test
    void registry_clonesAreIndependentFromEachOther() {
        EnemyRegistry registry = new EnemyRegistry();
        registry.register("goblin", new Goblin());
        Goblin c1 = (Goblin) registry.getClone("goblin");
        Goblin c2 = (Goblin) registry.getClone("goblin");
        c1.withHp(1);

        assertEquals(300, c2.getHp()); // c2 completely unaffected
    }

    @Test
    void registry_modifyingCloneDoesNotCorruptTemplate() {
        // This is the most important registry guarantee:
        // a caller modifying their clone must not corrupt the stored template
        EnemyRegistry registry = new EnemyRegistry();
        registry.register("orc", new Orc());
        Orc clone = (Orc) registry.getClone("orc");
        clone.withHp(1).withName("Dead Orc");

        // Get a fresh clone — it must still have original base stats
        EnemyPrototype freshClone = registry.getClone("orc");
        assertEquals(800,   freshClone.getHp());
        assertEquals("Orc", freshClone.getName());
    }

    @Test
    void registry_shouldSupportMultipleEnemyTypes() {
        EnemyRegistry registry = new EnemyRegistry();
        registry.register("goblin", new Goblin());
        registry.register("orc",    new Orc());
        registry.register("dragon", new Dragon());

        assertEquals("Goblin", registry.getClone("goblin").getName());
        assertEquals("Orc",    registry.getClone("orc").getName());
        assertEquals("Dragon", registry.getClone("dragon").getName());
    }

    @Test
    void registry_shouldThrowForUnknownEnemy() {
        EnemyRegistry registry = new EnemyRegistry();
        assertThrows(IllegalArgumentException.class,
                () -> registry.getClone("phoenix"));
    }

    @Test
    void registry_shouldThrowForUnregisteredNameEvenAfterOthersAreAdded() {
        EnemyRegistry registry = new EnemyRegistry();
        registry.register("goblin", new Goblin());
        assertThrows(IllegalArgumentException.class,
                () -> registry.getClone("dragon")); // dragon not registered
    }
}