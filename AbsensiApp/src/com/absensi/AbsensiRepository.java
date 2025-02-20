package com.absensi;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class AbsensiRepository {
    public void tambahAbsensi(Absensi absensi) {
        String query = "INSERT INTO absensi (nama, tanggal, jam) VALUES (?, ?, ?)";

        // ✅ Ambil waktu sekarang dalam format "yyyy-MM-dd HH:mm:ss"
        String waktuSekarang = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, absensi.getNama());
            pstmt.setString(2, absensi.getTanggal());
            pstmt.setString(3, waktuSekarang);  // ✅ Simpan waktu saat ini ke database

            pstmt.executeUpdate();
            System.out.println("✅ Data berhasil disimpan: " + absensi.getNama() + " - " + absensi.getTanggal() + " " + waktuSekarang);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Absensi> tampilkanAbsensi() {
        List<Absensi> daftarAbsensi = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM absensi")) {

            while (rs.next()) {
                String nama = rs.getString("nama");
                String tanggal = rs.getString("tanggal");
                String jam = rs.getString("jam");  // ✅ Ambil data jam dari database
                daftarAbsensi.add(new Absensi(nama, tanggal, jam));
                System.out.println("📌 Data ditemukan: " + nama + " - " + tanggal + " " + jam);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("🔍 Total Data yang Ditemukan: " + daftarAbsensi.size());
        return daftarAbsensi;
    }
}
