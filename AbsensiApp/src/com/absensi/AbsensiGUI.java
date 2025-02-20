package com.absensi;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class AbsensiGUI extends JFrame {
    private JTextField namaField, tanggalField;
    private JTextArea outputArea;
    private JButton tambahButton, tampilkanButton, keluarButton;
    private AbsensiRepository repo;

    public AbsensiGUI() {
        repo = new AbsensiRepository();

        setTitle("Aplikasi Absensi");
        setSize(500, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(3, 2, 5, 5));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        namaField = new JTextField();
        tanggalField = new JTextField();

        inputPanel.add(new JLabel("Nama:"));
        inputPanel.add(namaField);
        inputPanel.add(new JLabel("Tanggal (YYYY-MM-DD):"));
        inputPanel.add(tanggalField);

        tambahButton = new JButton("Tambah Absensi");
        tampilkanButton = new JButton("Tampilkan Absensi");
        keluarButton = new JButton("Keluar");

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(tambahButton);
        buttonPanel.add(tampilkanButton);
        buttonPanel.add(keluarButton);
        
        keluarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int confirm = JOptionPane.showConfirmDialog(
                        null,
                        "Yakin ingin keluar?",
                        "Konfirmasi Keluar",
                        JOptionPane.YES_NO_OPTION
                );
                if (confirm == JOptionPane.YES_OPTION) {
                    System.out.println("🚪 Aplikasi ditutup oleh pengguna.");
                    System.exit(0);  // ✅ Pastikan aplikasi benar-benar keluar
                }
            }
        });

        outputArea = new JTextArea(10, 40);
        outputArea.setEditable(false);
        add(new JScrollPane(outputArea), BorderLayout.CENTER);

        add(inputPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.SOUTH);

        tampilkanButton.addActionListener(e -> {
            List<Absensi> daftarAbsensi = repo.tampilkanAbsensi();
            outputArea.setText("");
            for (Absensi absensi : daftarAbsensi) {
                outputArea.append(absensi.getNama() + " - " + absensi.getTanggal() + " " + absensi.getJam() + "\n");
            }
        });

        tambahButton.addActionListener(e -> {
            repo.tambahAbsensi(new Absensi(namaField.getText(), tanggalField.getText(), ""));
            JOptionPane.showMessageDialog(null, "Absensi berhasil ditambahkan!");
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new AbsensiGUI().setVisible(true));
    }
}
