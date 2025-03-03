package com.plataforma_digital.models.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {
    private static DatabaseConnection instance;
    private Connection conn;

    private DatabaseConnection() {
        this.connect("database.db");
    }

    public static DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    // Conexión a la base de datos
    public void connect(String databaseUrlString) {
        String url = "jdbc:sqlite:" + databaseUrlString;
        try {
            conn = DriverManager.getConnection(url);
            System.out.println("Connection to SQLite has been established.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void disconnect() {
        if (conn != null) {
            try {
                conn.close();
                System.out.println("Connection to SQLite has been closed.");
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    // Crear Tablas
    public void createTables() {
        executeStatement(
                "CREATE TABLE IF NOT EXISTS users (id integer PRIMARY KEY AUTOINCREMENT, email text UNIQUE NOT NULL, first_name text NOT NULL, last_name text NOT NULL, role text CHECK (role IN('Student','Professor','Support Personal')) NOT NULL, password text NOT NULL);");
        executeStatement(
                "CREATE TABLE IF NOT EXISTS publications (id integer PRIMARY KEY AUTOINCREMENT, user_id integer NOT NULL references users (id), title text NOT NULL, description text, state text CHECK(state IN ('approved', 'rejected', 'in moderation')) NOT NULL, created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP);");
        executeStatement(
                "CREATE TABLE IF NOT EXISTS comments (id integer PRIMARY KEY AUTOINCREMENT, user_id integer NOT NULL references users (id), publication_id integer references publications (id), event_id integer references events (id), text text NOT NULL, created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP);");
        executeStatement(
                "CREATE TABLE IF NOT EXISTS events (id integer PRIMARY KEY AUTOINCREMENT, user_id integer NOT NULL references users (id), title text NOT NULL, description text, state text CHECK(state IN ('approved', 'rejected', 'in moderation')) NOT NULL, created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP, start_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP, end_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP, location text NOT NULL);");
    }

    // Ejecutar Consultas a la base de datos
    public void executeStatement(String sql) {
        if (conn == null) {
            System.out.println("Connection to database is null");
            return;
        }
        try (Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Statement executed");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void executePreparedStatement(String sql, String... params) {
        if (conn == null) {
            System.out.println("Connection to database is null");
            return;
        }
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            for (int i = 0; i < params.length; i++) {
                pstmt.setString(i + 1, params[i]);
            }
            pstmt.executeUpdate();
            System.out.println("PreparedStatement executed");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public ResultSet executeSelectStatement(String sql) {
        ResultSet rs = null;
        if (conn != null) {
            try {
                Statement stmt = conn.createStatement();
                rs = stmt.executeQuery(sql);
                System.out.println("SelectStatement executed");
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        } else {
            System.out.println("Connection to database is null");
        }
        return rs;
    }

    public ResultSet executePreparedSelectStatement(String sql, String... params) {
        ResultSet rs = null;
        if (conn != null) {
            try {
                PreparedStatement pstmt = conn.prepareStatement(sql);
                for (int i = 0; i < params.length; i++) {
                    pstmt.setString(i + 1, params[i]);
                }
                rs = pstmt.executeQuery();
                System.out.println("PreparedSelectStatement executed");
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        } else {
            System.out.println("Connection to database is null");
        }
        return rs;
    }

    public int executePreparedStatementWithGeneratedKeys(String sql, String... params) {
        if (conn != null) {
            try (PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                for (int i = 0; i < params.length; i++) {
                    pstmt.setString(i + 1, params[i]);
                }
                pstmt.executeUpdate();
                System.out.println("PreparedStatementWithGeneratedKeys executed");
                try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        return generatedKeys.getInt(1);
                    }
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        } else {
            System.out.println("Connection to database is null");
        }
        return -1;
    }
}
