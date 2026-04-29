package edu.pradita.oop.session03;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== TUGAS 000: Peringkat Lomba Lari ===");
        System.out.print("Masukkan waktu tempuh peserta (dalam detik): ");

        try {
            double time = scanner.nextDouble();

            String rank = getRank(time);
            System.out.println("Peringkat peserta: " + rank);

        } catch (InputMismatchException e) {
            System.out.println("Input tidak valid. Harap masukkan angka (misalnya: 15.5).");
        } finally {
            scanner.close();
        }
    }

    public static String getRank(double timeInSeconds) {

        if (timeInSeconds < 0) {
            return "Waktu tidak boleh negatif";
        } 
        else if (timeInSeconds < 12) {
            return "Kategori Lari Cepat";
        } 
        else if (timeInSeconds <= 20) {
            return "Kategori Lari Menengah";
        } 
        else {
            return "Kategori Lari Jarak Jauh";
        }
    }
}