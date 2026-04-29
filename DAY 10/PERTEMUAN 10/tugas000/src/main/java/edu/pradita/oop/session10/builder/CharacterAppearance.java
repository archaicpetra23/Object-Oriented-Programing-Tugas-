package edu.pradita.oop.session10.builder;

/**
 * BUILDER PATTERN — Product class.
 *
 * WHY BUILDER HERE?
 * A character creation screen has MANY appearance options.
 * Some are mandatory (name), most are optional (hair, body, eyes, skin).
 *
 * WITHOUT Builder the call looks like:
 * new CharacterAppearance("Andi", 3, 2, 4, eyeConfig, "Tan")
 * → what does 3, 2, 4 mean? easy to swap them by accident, can't skip optional
 * fields.
 *
 * WITH Builder:
 * new CharacterAppearance.Builder("Andi")
 * .hairStyle(3)
 * .upperBody(2)
 * .eyeConfig(new EyeConfig("Blue", "Almond"))
 * .build()
 * → each step is named, optional fields can be omitted, order doesn't matter.
 *
 * DO: Use Builder when an object has many optional fields.
 * DO: Put mandatory fields in the Builder constructor.
 * DO: Return `this` from every setter to enable method chaining.
 * DO: Keep the Product constructor private — Builder is the only entry point.
 * DONT: Use Builder for objects with only 1-2 fields — a plain constructor is
 * cleaner.
 * DONT: Use Prototype here — each character is configured uniquely step by
 * step,
 * not copied from a shared base template. Use Prototype when you need many
 * identical copies of a base object.
 */
public class CharacterAppearance {

    // TODO 2.1
    // Declare ALL six fields as private and final.
    // Final means they can only be assigned once — in the constructor.
    // This guarantees the product is immutable after build() is called.
    //
    // name — String, mandatory, the character's display name
    // hairStyle — int, optional, style index 1–5
    // upperBody — int, optional, outfit index 1–5
    // lowerBody — int, optional, outfit index 1–5
    // eyeConfig — EyeConfig, optional, may be null if player skips eye
    // customisation
    // skinTone — String, optional, e.g. "Fair", "Tan", "Dark"
    private final String name;
    private final int hairStyle;
    private final int upperBody;
    private final int lowerBody;
    private final EyeConfig eyeConfig;
    private final String skinTone;

    // TODO 2.2
    // Private constructor — ONLY the inner Builder class may call this.
    // It receives a fully configured Builder and copies every field from it.
    //
    // WHY PRIVATE?
    // Forcing creation through Builder means a CharacterAppearance can never
    // exist in a half-configured state. No one can call new CharacterAppearance()
    // and forget to set the name, for example.
    //
    // Fill in ALL six assignments from builder.
    private CharacterAppearance(Builder builder) {
        this.name = builder.name;
        this.hairStyle = builder.hairStyle;
        this.upperBody = builder.upperBody;
        this.lowerBody = builder.lowerBody;
        this.eyeConfig = builder.eyeConfig;
        this.skinTone = builder.skinTone;
    }

    // TODO 2.3
    // Provide a public getter for every field.
    // Tests and App.java use these to verify the built object.
    // DO NOT add setters — the product is immutable after build().
    public String getName() {
        return name;
    }

    public int getHairStyle() {
        return hairStyle;
    }

    public int getUpperBody() {
        return upperBody;
    }

    public int getLowerBody() {
        return lowerBody;
    }

    public EyeConfig getEyeConfig() {
        return eyeConfig;
    }

    public String getSkinTone() {
        return skinTone;
    }

    // TODO 2.4
    // Implement display() to print all fields in a readable format.
    // For eyeConfig, print the toString() result if it is not null,
    // otherwise print "Default".
    public void display() {
        System.out.println("=== Character: " + name + " ===");
        System.out.println("  Hair Style : " + hairStyle);
        System.out.println("  Upper Body : " + upperBody);
        System.out.println("  Lower Body : " + lowerBody);
        System.out.println("  Eyes       : " + (eyeConfig != null ? eyeConfig : "Default"));
        System.out.println("  Skin Tone  : " + skinTone);
    }

    // ── Inner Builder ────────────────────────────────────────────────────────

    public static class Builder {

        // TODO 3.1
        // Mandatory field — private final, no default value.
        // It goes here (not as an optional setter) because a character
        // MUST always have a name — the Builder cannot be valid without it.
        private final String name;

        // TODO 3.2
        // Optional fields — declare each one with a sensible default.
        // These defaults are used when the player skips that customisation step.
        //
        // hairStyle → default 1 (first available style)
        // upperBody → default 1
        // lowerBody → default 1
        // eyeConfig → default null (no eye customisation chosen)
        // skinTone → default "Fair"
        //
        // Think: why are defaults set HERE in the Builder, not in the Product?
        private int hairStyle = 1;
        private int upperBody = 1;
        private int lowerBody = 1;
        private EyeConfig eyeConfig = null;
        private String skinTone = "Fair";

        // TODO 3.3
        // Builder constructor — receives the mandatory field.
        // Mandatory fields go here so the compiler forces callers to supply them.
        // You cannot create a Builder without providing a name.
        public Builder(String name) {
            this.name = name;
        }

        // TODO 3.4
        // Implement all five optional setters.
        // Each setter must:
        // 1. Assign the parameter to the matching field.
        // 2. Return `this` — so calls can be chained like:
        // .hairStyle(3).upperBody(2).skinTone("Tan")
        //
        // Without `return this`, chaining breaks and the caller
        // must store the Builder in a variable to call each method separately.
        public Builder hairStyle(int hairStyle) {
            this.hairStyle = hairStyle;
            return this;
        }

        public Builder upperBody(int upperBody) {
            this.upperBody = upperBody;
            return this;
        }

        public Builder lowerBody(int lowerBody) {
            this.lowerBody = lowerBody;
            return this;
        }

        public Builder eyeConfig(EyeConfig eyeConfig) {
            this.eyeConfig = eyeConfig;
            return this;
        }

        public Builder skinTone(String skinTone) {
            this.skinTone = skinTone;
            return this;
        }

        // TODO 3.5
        // build() is the FINAL step — it creates the actual CharacterAppearance.
        // It calls the private constructor and passes `this` (the configured Builder).
        //
        // WHY a separate build() method?
        // It makes the end of configuration explicit and intentional.
        // The player has finished making choices — now lock in the result.
        public CharacterAppearance build() {
            return new CharacterAppearance(this);
        }
    }
}