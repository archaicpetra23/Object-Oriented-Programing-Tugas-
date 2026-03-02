package edu.pradita.oop.session02;

import java.util.Currency;
import java.util.Date;

/**
 * TUGAS 001: BankAccount System
 * 
 * Soal 1-3:
 * - Constructor dengan validation
 * - Getter/Setter methods
 * - Currency validation (ID/US only)
 * - Date handling (gunakan new Date() untuk tanggal hari ini)
 */
public class BankAccount {
    
    // TODO 1: Deklarasi atribut private (Soal 1)
    private String accountNumber;
    private double balance;
    
    // TODO 2: Deklarasi atribut tambahan (Soal 2)
    private Date cardOpeningDate;
    private String currency;

    // TODO 3: Constructor Soal 1
    public BankAccount(String accountNumber) {
       this.accountNumber = accountNumber;
       this.balance = 0.0;
       this.currency = "IDR";
       this.cardOpeningDate = new Date();
        // Initialize accountNumber
        // Set balance = 0.0
    }

    // TODO 4: Constructor Soal 2 dengan validasi currency (Soal 3)
    public BankAccount(String accountNumber, String currency, Date cardOpeningDate) {
        this.accountNumber = accountNumber;

        if (cardOpeningDate == null) {
            this.cardOpeningDate = new Date();
        } else {
            this.cardOpeningDate = cardOpeningDate;
        }

        if (currency != null && (currency.equals("IDR") || currency.equals("USD"))) {
            this.currency = currency;
        } else {
                System.out.println("WARNING: The currency available only on ID and US");
                this.currency = "IDR";
            }
            this.balance = 0.0;
        }
        // TODO: Set accountNumber
        // TODO: Set cardOpeningDate (atau gunakan new Date() jika null)
        // TODO: Validasi currency - hanya "ID" atau "US"
        //       Jika tidak valid, print "WARNING: The currency available only on ID and US!"
        //       dan set currency = "ID" (default)
        // TODO: Set balance = 0.0
    

    // TODO 5: Getter accountNumber (Soal 1)
    public String getAccountNumber() {
        return accountNumber;
    }

    // TODO 6: Getter balance (Soal 1)
    public double getBalance() {
        return balance;
    }

    // TODO 7: Method save (Soal 1)
    public void save(double amount) {
        if (amount > 0) {
            balance += amount;
        } else {
            System.out.println("WARNING: Amount must be greater than 0!");
        }
    }
        // TODO: Tambahkan amount ke balance
        // TODO: Validasi amount > 0
    

    // TODO 8: Method withdraw (Soal 1)
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("WARNING: Amount must be greater than 0!");        
        } else if (amount > balance) {
            System.out.println("WARNING: Insufficient balance!");
        } else {
            balance -= amount;
        }
    }
        // TODO: Kurangi balance dengan amount
        // TODO: Validasi amount > 0 dan amount <= balance
    

    // TODO 9: Getter cardOpeningDate (Soal 2)
    public Date getCardOpeningDate() {
        return cardOpeningDate;
    }

    // TODO 10: Getter currency (Soal 2)
    public String getCurrency() {
        return currency;
    }

    // TODO 11: Setter currency dengan validasi (Soal 2 + 3)
    public void setCurrency(String currency) {
        if (currency != null && (currency.equals("IDR") || currency.equals("USD"))) {
            this.currency = currency;
        } else {
            System.out.println("WARNING: The currency available only on ID and US!");
        }
    }
        // TODO: Validasi currency - hanya "ID" atau "US"
        // TODO: Jika tidak valid, print WARNING dan jangan ubah
    



    // Helper method untuk print info (opsional)
    @Override
    public String toString() {
        return "BankAccount{" +
                "accountNumber='" + accountNumber + '\'' +
                ", balance=" + balance +
                ", currency='" + currency + '\'' +
                ", cardOpeningDate=" + cardOpeningDate +
                '}';
    }
}
