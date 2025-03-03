package com.plataforma_digital.models.database.impl;

import com.plataforma_digital.models.database.DatabaseConnection;
import com.plataforma_digital.models.database.UserDao;
import com.plataforma_digital.models.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao {
    private DatabaseConnection db = DatabaseConnection.getInstance();

    public void createUser(User user) {
        String sql = "INSERT INTO users (email, first_name, last_name, role, password) VALUES (?, ?, ?, ?, ?)";
        int generatedId = db.executePreparedStatementWithGeneratedKeys(sql, user.getEmail(),
                user.getFirstName(),
                user.getLastName(),
                user.getRole(), user.getPassword());
        if (generatedId != -1) {
            user.setId(generatedId);
        }
    }

    public User getUserById(int id) {
        String sql = "SELECT * FROM users WHERE id = ?";
        User user = null;
        try (ResultSet rs = db.executePreparedSelectStatement(sql, String.valueOf(id))) {
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
        try (ResultSet rs = db.executePreparedSelectStatement(sql, email)) {
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
        db.executePreparedStatement(sql, user.getEmail(), user.getFirstName(), user.getLastName(),
                user.getRole(),
                user.getPassword(), String.valueOf(user.getId()));
    }

    public void deleteUserById(int id) {
        String sql = "DELETE FROM users WHERE id = ?";
        db.executePreparedStatement(sql, String.valueOf(id));
    }

    public User authenticateUser(String email, String password) {
        String sql = "SELECT * FROM users WHERE email = ? AND password = ?";
        User user = null;
        try (ResultSet rs = db.executePreparedSelectStatement(sql, email, password)) {
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

}