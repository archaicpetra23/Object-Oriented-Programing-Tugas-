package edu.pradita.oop.session06;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== TUGAS000: Kalkulator 2 Bilangan ===");

        System.out.print("Masukkan bilangan pertama: ");
        double a = scanner.nextDouble();

        System.out.print("Masukkan bilangan kedua: ");
        double b = scanner.nextDouble();

        System.out.println("Pilih operasi:");
        System.out.println("1. Tambah (+)");
        System.out.println("2. Kurang (-)");
        System.out.println("3. Kali   (*)");
        System.out.println("4. Bagi   (/)");
        System.out.print("Pilihan: ");
        int choice = scanner.nextInt();

        try {
            double result = hitung(a, b, choice);
            System.out.println("Hasil: " + result);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        scanner.close();
    }

    public static double hitung(double a, double b, int choice) {
        return switch (choice) {
            case 1 -> a + b;
            case 2 -> a - b;
            case 3 -> a * b;
            case 4 -> {
                if (b == 0) throw new IllegalArgumentException("Tidak bisa bagi 0");
                yield a / b;
            }
            default -> throw new IllegalArgumentException("Pilihan operasi tidak valid");
        };
    }
}
