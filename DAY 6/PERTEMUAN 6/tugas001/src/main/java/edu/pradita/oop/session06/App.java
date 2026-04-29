package edu.pradita.oop.session06;

import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.util.Scanner;

public class App {

    private static final DateTimeFormatter FMT =
            DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public static void main(String[] args) {
        MemberService service = new MemberService();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== GYM PRADITA ===");
            System.out.println("1. Daftar Member Baru");
            System.out.println("2. Login");
            System.out.println("3. Keluar");
            System.out.print("Pilihan: ");
            int choice = Integer.parseInt(scanner.nextLine().trim());

            switch (choice) {
                case 1 -> handleDaftar(service, scanner);
                case 2 -> handleLogin(service, scanner);
                case 3 -> {
                    System.out.println("Terima kasih. Sampai jumpa!");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Pilihan tidak dikenal.");
            }
        }
    }

    private static void handleDaftar(MemberService service, Scanner scanner) {
        System.out.print("Username: ");
        String username = scanner.nextLine().trim();
        System.out.print("Nama lengkap: ");
        String nama = scanner.nextLine().trim();

        System.out.println("\nPilih paket membership:");
        System.out.printf("1. 3 bulan  - Rp %,d%n",
                MembershipPlan.THREE_MONTHS.getPriceIdr());
        System.out.printf("2. 6 bulan  - Rp %,d%n",
                MembershipPlan.SIX_MONTHS.getPriceIdr());
        System.out.printf("3. 9 bulan  - Rp %,d%n",
                MembershipPlan.NINE_MONTHS.getPriceIdr());
        System.out.print("Pilihan: ");
        int paket = Integer.parseInt(scanner.nextLine().trim());

        MembershipPlan plan = switch (paket) {
            case 1 -> MembershipPlan.THREE_MONTHS;
            case 2 -> MembershipPlan.SIX_MONTHS;
            case 3 -> MembershipPlan.NINE_MONTHS;
            default -> throw new IllegalArgumentException("Paket tidak valid");
        };

        System.out.printf("Total pembayaran: Rp %,d%n", plan.getPriceIdr());
        System.out.print("Buat password: ");
        String password = scanner.nextLine().trim();

        try {
            Member m = service.register(username, password, nama, plan);
            System.out.println("Pendaftaran berhasil!");
            System.out.println("Membership berlaku sampai: "
                    + m.getMembershipAkhir().format(FMT));
        } catch (IllegalArgumentException e) {
            System.out.println("Gagal: " + e.getMessage());
        }
    }

    private static void handleLogin(MemberService service, Scanner scanner) {
        System.out.print("Username: ");
        String username = scanner.nextLine().trim();
        System.out.print("Password: ");
        String password = scanner.nextLine().trim();

        try {
            Member m = service.login(username, password);
            System.out.println("\nSelamat datang, " + m.getNamaLengkap() + "!");
            System.out.println("Membership sampai: "
                    + m.getMembershipAkhir().format(FMT));

            System.out.println("\nPilih perpanjang membership:");
            System.out.printf("1. 3 bulan  - Rp %,d%n",
                    MembershipPlan.THREE_MONTHS.getPriceIdr());
            System.out.printf("2. 6 bulan  - Rp %,d%n",
                    MembershipPlan.SIX_MONTHS.getPriceIdr());
            System.out.printf("3. 9 bulan  - Rp %,d%n",
                    MembershipPlan.NINE_MONTHS.getPriceIdr());
            System.out.print("Pilihan: ");
            int p = Integer.parseInt(scanner.nextLine().trim());

            MembershipPlan plan = switch (p) {
                case 1 -> MembershipPlan.THREE_MONTHS;
                case 2 -> MembershipPlan.SIX_MONTHS;
                case 3 -> MembershipPlan.NINE_MONTHS;
                default -> throw new IllegalArgumentException("Paket tidak valid");
            };

            service.extendMembership(m, plan);
            System.out.println("Perpanjang berhasil!");
            System.out.println("Membership baru berakhir: "
                    + m.getMembershipAkhir().format(FMT));

        } catch (IllegalArgumentException e) {
            System.out.println("Gagal: " + e.getMessage());
        }
    }
}
