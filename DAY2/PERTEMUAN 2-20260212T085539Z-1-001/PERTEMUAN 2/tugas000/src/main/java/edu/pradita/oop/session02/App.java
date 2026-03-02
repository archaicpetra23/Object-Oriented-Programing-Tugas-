package edu.pradita.oop.session02;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.text.WordUtils;

/**
 * TUGAS 000: Maven Basics
 * TODO: Lengkapi method di bawah menggunakan Apache Commons Lang
 */
public class App {
    
    public static void main(String[] args) {
        System.out.println("=== TUGAS 000: Maven Basics ===\n");
        
        App app = new App();
        
        // Test reverse
        String reversed = app.reverseString("Build Tools");
        System.out.println("Reversed: " + reversed);
        
        // Test capitalize
        String capitalized = app.capitalizeWords("hello world from maven");
        System.out.println("Capitalized: " + capitalized);
        
        // Test abbreviate
        String abbrev = app.abbreviateString("This is a very long sentence", 15);
        System.out.println("Abbreviated: " + abbrev);
    }

    // TODO 1: Reverse string menggunakan StringUtils.reverse()
    public String reverseString(String input) {
        // TODO: Implement using StringUtils
        return StringUtils.reverse(input);
    }

    // TODO 2: Capitalize setiap kata menggunakan WordUtils.capitalize() 
    public String capitalizeWords(String input) {
        // TODO: Implement using WordUtils (akan terlihat deprecated atau strikethrough)
        return WordUtils.capitalize(input);
    }

    // TODO 3: Abbreviate string dengan max length
    public String abbreviateString(String input, int maxLength) {
        // TODO: Implement using StringUtils.abbreviate()
        return StringUtils.abbreviate(input, maxLength);
    }
}
