package com.plataforma_digital.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.plataforma_digital.entities.*;

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
                "CREATE TABLE IF NOT EXISTS users (id integer PRIMARY KEY AUTOINCREMENT, username text UNIQUE NOT NULL, first_name text NOT NULL, last_name text NOT NULL, role text CHECK (role IN('Student','Professor','Support Personal')) NOT NULL, password text NOT NULL);");
        executeStatement(
                "CREATE TABLE IF NOT EXISTS publications (id integer PRIMARY KEY AUTOINCREMENT, user_id integer NOT NULL references users (id), title text NOT NULL, description text, state text CHECK(state IN ('approved', 'rejected', 'in moderation')) NOT NULL, created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP);");
        executeStatement(
                "CREATE TABLE IF NOT EXISTS comments (id integer PRIMARY KEY AUTOINCREMENT, user_id integer NOT NULL references users (id), publication_id integer NOT NULL references publications (id),text text NOT NULL, created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP);");
    }

    // Ejecutar Consultas a la base de datos
    private void executeStatement(String sql) {
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

    private void executePreparedStatement(String sql, String... params) {
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

    private ResultSet executePreparedSelectStatement(String sql, String... params) {
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

    private int executePreparedStatementWithGeneratedKeys(String sql, String... params) {
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

    // Métodos CRUD para la tabla users
    public void createUser(User user) {
        String sql = "INSERT INTO users (email, first_name, last_name, role, password) VALUES (?, ?, ?, ?, ?)";
        int generatedId = executePreparedStatementWithGeneratedKeys(sql, user.getEmail(), user.getFirstName(),
                user.getLastName(),
                user.getRole(), user.getPassword());
        if (generatedId != -1) {
            user.setId(generatedId);
        }
    }

    public User getUserById(int id) {
        String sql = "SELECT * FROM users WHERE id = ?";
        User user = null;
        try (ResultSet rs = executePreparedSelectStatement(sql, String.valueOf(id))) {
            if (rs != null && rs.next()) {
                user = new User(rs.getInt("id"), rs.getString("email"), rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("role"), rs.getString("password"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return user;
    }

    public User getUserByEmail(String email) {
        String sql = "SELECT * FROM users WHERE email = ?";
        User user = null;
        try (ResultSet rs = executePreparedSelectStatement(sql, email)) {
            if (rs != null && rs.next()) {
                user = new User(rs.getInt("id"), rs.getString("email"), rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("role"), rs.getString("password"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return user;
    }

    public void updateUser(User user) {
        String sql = "UPDATE users SET email = ?, first_name = ?, last_name = ?, role = ?, password = ? WHERE id = ?";
        executePreparedStatement(sql, user.getEmail(), user.getFirstName(), user.getLastName(), user.getRole(),
                user.getPassword(), String.valueOf(user.getId()));
    }

    public void deleteUserById(int id) {
        String sql = "DELETE FROM users WHERE id = ?";
        executePreparedStatement(sql, String.valueOf(id));
    }

    public User authenticateUser(String email, String password) {
        String sql = "SELECT * FROM users WHERE email = ? AND password = ?";
        User user = null;
        try (ResultSet rs = executePreparedSelectStatement(sql, email, password)) {
            if (rs != null && rs.next()) {
                user = new User(rs.getInt("id"),
                        rs.getString("email"), rs.getString("first_name"), rs.getString("last_name"),
                        rs.getString("role"), rs.getString("password"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return user;
    }

    // Métodos CRUD para la tabla publications
    public void createPublication(Publication publication) {
        String sql = "INSERT INTO publications (user_id, title, description, state) VALUES (?, ?, ?, ?)";
        int generatedId = executePreparedStatementWithGeneratedKeys(sql, String.valueOf(publication.getUserId()),
                publication.getTitle(),
                publication.getDescription(), publication.getState());
        if (generatedId != -1) {
            publication.setId(generatedId);
        }
    }

    public Publication getPublicationById(int id) {
        String sql = "SELECT * FROM publications WHERE id = ?";
        Publication publication = null;
        try (ResultSet rs = executePreparedSelectStatement(sql, String.valueOf(id))) {
            if (rs != null && rs.next()) {
                publication = new Publication(rs.getInt("id"), rs.getInt("user_id"), rs.getString("title"),
                        rs.getString("description"), rs.getString("state"), rs.getString("created_at"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return publication;
    }

    public List<Publication> getAllPublications() {
        String sql = "SELECT * FROM publications";
        List<Publication> publications = new ArrayList<>();
        try (ResultSet rs = executeSelectStatement(sql)) {
            while (rs != null && rs.next()) {
                Publication publication = new Publication(rs.getInt("id"), rs.getInt("user_id"), rs.getString("title"),
                        rs.getString("description"), rs.getString("state"), rs.getString("created_at"));
                publications.add(publication);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return publications;
    }

    public List<Publication> getAllPublicationsByState(String state) {
        String sql = "SELECT * FROM publications WHERE state = ?";
        List<Publication> publications = new ArrayList<>();
        try (ResultSet rs = executePreparedSelectStatement(sql, state)) {
            while (rs != null && rs.next()) {
                Publication publication = new Publication(rs.getInt("id"), rs.getInt("user_id"), rs.getString("title"),
                        rs.getString("description"), rs.getString("state"), rs.getString("created_at"));
                publications.add(publication);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return publications;
    }

    public List<Publication> getAllPublicationsByUserId(int userId) {
        String sql = "SELECT * FROM publications WHERE user_id = ?";
        List<Publication> publications = new ArrayList<>();
        try (ResultSet rs = executePreparedSelectStatement(sql, String.valueOf(userId))) {
            while (rs != null && rs.next()) {
                Publication publication = new Publication(rs.getInt("id"), rs.getInt("user_id"), rs.getString("title"),
                        rs.getString("description"), rs.getString("state"), rs.getString("created_at"));
                publications.add(publication);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return publications;
    }

    public void updatePublication(Publication publication) {
        String sql = "UPDATE publications SET title = ?, description = ?, state = ? WHERE id = ?";
        executePreparedStatement(sql, publication.getTitle(), publication.getDescription(), publication.getState(),
                String.valueOf(publication.getId()));
    }

    public void deletePublicationById(int id) {
        String sql = "DELETE FROM publications WHERE id = ?";
        executePreparedStatement(sql, String.valueOf(id));
    }

    // Métodos CRUD para la tabla comments
    public void createComment(Comment comment) {
        String sql = "INSERT INTO comments (user_id, publication_id, text) VALUES (?, ?, ?)";
        int generatedId = executePreparedStatementWithGeneratedKeys(sql, String.valueOf(comment.getUserId()),
                String.valueOf(comment.getPublicationId()), comment.getText());
        if (generatedId != -1) {
            comment.setId(generatedId);
        }
    }

    public Comment getCommentById(int id) {
        String sql = "SELECT * FROM comments WHERE id = ?";
        Comment comment = null;
        try (ResultSet rs = executePreparedSelectStatement(sql, String.valueOf(id))) {
            if (rs != null && rs.next()) {
                comment = new Comment(rs.getInt("id"), rs.getInt("user_id"), rs.getInt("publication_id"),
                        rs.getString("text"), rs.getString("created_at"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return comment;
    }

    public List<Comment> getAllCommentsByPublicationId(int publicationId) {
        String sql = "SELECT * FROM comments WHERE publication_id = ?";
        List<Comment> comments = new ArrayList<>();
        try (ResultSet rs = executePreparedSelectStatement(sql, String.valueOf(publicationId))) {
            while (rs != null && rs.next()) {
                Comment comment = new Comment(rs.getInt("id"), rs.getInt("user_id"), rs.getInt("publication_id"),
                        rs.getString("text"),
                        rs.getString("created_at"));
                comments.add(comment);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return comments;
    }

    public void updateComment(Comment comment) {
        String sql = "UPDATE comments SET text = ? WHERE id = ?";
        executePreparedStatement(sql, comment.getText(),
                String.valueOf(comment.getId()));
    }

    public void deleteCommentById(int id) {
        String sql = "DELETE FROM comments WHERE id = ?";
        executePreparedStatement(sql, String.valueOf(id));
    }
}
