package edu.pradita.lsp;

public class StandardEquipmentRefactored implements ReleasableRefactored {
    private String name;

    public StandardEquipmentRefactored(String name) {
        this.name = name;
    }

    @Override
    public void release() {
        System.out.println("[LSP] " + name + " is now available");
    }
}