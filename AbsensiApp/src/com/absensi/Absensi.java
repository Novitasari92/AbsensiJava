package com.absensi;

public class Absensi {
    private String nama;
    private String tanggal;
    private String jam;

    public Absensi(String nama, String tanggal, String jam) {
        this.nama = nama;
        this.tanggal = tanggal;
        this.jam = jam;
    }

    public String getNama() { return nama; }
    public String getTanggal() { return tanggal; }
    public String getJam() { return jam; }

    @Override
    public String toString() {
        return "Nama: " + nama + ", Tanggal: " + tanggal + ", Jam: " + jam;
    }
}
