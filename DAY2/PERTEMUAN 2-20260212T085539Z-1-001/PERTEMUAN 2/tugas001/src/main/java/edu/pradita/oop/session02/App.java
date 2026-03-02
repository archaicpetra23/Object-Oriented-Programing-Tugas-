package edu.pradita.oop.session02;

import java.util.Date;

/**
 * Demo program untuk test BankAccount
 * JANGAN DIUBAH - hanya untuk visualisasi
 */
public class App {
    
    public static void main(String[] args) {
        System.out.println("=== BANK ACCOUNT SYSTEM ===\n");

        // Test Soal 1 & 2 & 3
        System.out.println("--- Test 1: Valid Currency (ID) ---");
        BankAccount acc1 = new BankAccount("ACC001", "ID", new Date());
        System.out.println("Account: " + acc1.getAccountNumber());
        System.out.println("Currency: " + acc1.getCurrency());
        System.out.println("Opening Date: " + acc1.getCardOpeningDate());
        System.out.println("Initial Balance: " + acc1.getBalance());
        
        acc1.save(1000000);
        System.out.println("After save 1,000,000: " + acc1.getBalance());
        
        acc1.withdraw(250000);
        System.out.println("After withdraw 250,000: " + acc1.getBalance());

        System.out.println("\n--- Test 2: Invalid Currency (EUR) ---");
        BankAccount acc2 = new BankAccount("ACC002", "EUR", new Date());
        // Harus muncul WARNING dan default ke ID
        System.out.println("Currency after warning: " + acc2.getCurrency());

        System.out.println("\n--- Test 3: Set Currency dengan Validasi ---");
        acc1.setCurrency("US");  // Valid
        System.out.println("Changed to: " + acc1.getCurrency());
        
        acc1.setCurrency("JPY");  // Invalid - harus muncul WARNING
        System.out.println("Still: " + acc1.getCurrency());

        System.out.println("\n--- Test 4: Edge Cases ---");
        acc1.withdraw(5000000);  // Insufficient balance
        acc1.save(-100);  // Negative amount

        System.out.println("\n✅ Demo selesai!");
    }
}
