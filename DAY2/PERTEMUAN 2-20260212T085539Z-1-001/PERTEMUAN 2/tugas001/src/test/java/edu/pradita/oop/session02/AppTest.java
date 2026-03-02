package edu.pradita.oop.session02;

import org.junit.jupiter.api.Test;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    @Test
    void testConstructorAndGetters() {
        // Soal 1 & 2
        BankAccount acc = new BankAccount("ACC123", "ID", new Date());
        assertEquals("ACC123", acc.getAccountNumber());
        assertEquals(0.0, acc.getBalance());
        assertEquals("ID", acc.getCurrency());
        assertNotNull(acc.getCardOpeningDate());
    }

    @Test
    void testSaveMethod() {
        // Soal 1
        BankAccount acc = new BankAccount("ACC456", "US", new Date());
        acc.save(500000);
        assertEquals(500000.0, acc.getBalance());
    }

    @Test
    void testWithdrawMethod() {
        // Soal 1
        BankAccount acc = new BankAccount("ACC789", "ID", new Date());
        acc.save(1000000);
        acc.withdraw(300000);
        assertEquals(700000.0, acc.getBalance());
    }

    @Test
    void testCurrencyValidation() {
        // Soal 3 - Valid currencies
        BankAccount acc1 = new BankAccount("ACC001", "ID", new Date());
        assertEquals("ID", acc1.getCurrency());

        BankAccount acc2 = new BankAccount("ACC002", "US", new Date());
        assertEquals("US", acc2.getCurrency());

        // Soal 3 - Invalid currency (should default to ID)
        BankAccount acc3 = new BankAccount("ACC003", "EUR", new Date());
        assertEquals("ID", acc3.getCurrency());
    }

    @Test
    void testSetCurrencyValidation() {
        // Soal 2 & 3
        BankAccount acc = new BankAccount("ACC999", "ID", new Date());
        
        acc.setCurrency("US");  // Valid
        assertEquals("US", acc.getCurrency());
        
        acc.setCurrency("JPY");  // Invalid - should not change
        assertEquals("US", acc.getCurrency());  // Still US
    }

    @Test
    void testDateNotNull() {
        // Soal 3 - cardOpeningDate should use today's date
        BankAccount acc = new BankAccount("ACC111", "ID", new Date());
        assertNotNull(acc.getCardOpeningDate());
        
        // Should be today (within 1 second tolerance)
        long timeDiff = Math.abs(new Date().getTime() - acc.getCardOpeningDate().getTime());
        assertTrue(timeDiff < 1000, "Date should be today");
    }
}
