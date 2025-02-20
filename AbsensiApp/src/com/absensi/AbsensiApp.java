package com.absensi;

import java.util.List;
import java.util.Scanner;

public class AbsensiApp {
    private static Scanner scanner = new Scanner(System.in);
    private static AbsensiRepository absensiRepository = new AbsensiRepository();

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nAplikasi Absensi");
            System.out.println("1. Tambah Absensi");
            System.out.println("2. Tampilkan Absensi");
            System.out.println("3. Keluar");
            System.out.print("Pilih menu: ");
            int pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1:
                    tambahAbsensi();
                    break;
                case 2:
                    tampilkanAbsensi();
                    break;
                case 3:
                    System.out.println("Terima kasih telah menggunakan aplikasi absensi.");
                    System.exit(0);
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        }
    }

    private static void tambahAbsensi() {
        System.out.print("Masukkan Nama: ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan Tanggal (YYYY-MM-DD): ");
        String tanggal = scanner.nextLine();

        Absensi absensi = new Absensi(nama, tanggal, "");
        absensiRepository.tambahAbsensi(absensi);
    }

    private static void tampilkanAbsensi() {
        List<Absensi> daftarAbsensi = absensiRepository.tampilkanAbsensi();
        for (Absensi absensi : daftarAbsensi) {
            System.out.println(absensi);
        }
    }
}
