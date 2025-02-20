package com.absensi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/absensi_db"; 
    private static final String USER = "root";  // Sesuaikan dengan MySQL
    private static final String PASSWORD = "";  // Jika ada password, isi di sini

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
