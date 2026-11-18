package com.aventra.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class DBConnection {
    private static final String URL = System.getenv().getOrDefault(
            "aventra_DB_URL", "jdbc:mysql://localhost:3306/aventra_tourism?useSSL=false&serverTimezone=UTC");
    private static final String USER = System.getenv().getOrDefault("aventra_DB_USER", "root");
    private static final String PASSWORD = System.getenv().getOrDefault("aventra_DB_PASSWORD", "");

    private DBConnection() {}

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
