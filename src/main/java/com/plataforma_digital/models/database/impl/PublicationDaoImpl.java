package com.plataforma_digital.models.database.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.plataforma_digital.models.database.DatabaseConnection;
import com.plataforma_digital.models.database.PublicationDao;
import com.plataforma_digital.models.Publication;

public class PublicationDaoImpl implements PublicationDao {
    private DatabaseConnection db = DatabaseConnection.getInstance();

    public void createPublication(Publication publication) {
        String sql = "INSERT INTO publications (user_id, title, description, state) VALUES (?, ?, ?, ?)";
        int generatedId = db.executePreparedStatementWithGeneratedKeys(sql, String.valueOf(publication.getUserId()),
                publication.getTitle(),
                publication.getDescription(), publication.getState());
        if (generatedId != -1) {
            publication.setId(generatedId);
        }
    }

    public Publication getPublicationById(int id) {
        String sql = "SELECT * FROM publications WHERE id = ?";
        Publication publication = null;
        try (ResultSet rs = db.executePreparedSelectStatement(sql, String.valueOf(id))) {
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
        try (ResultSet rs = db.executeSelectStatement(sql)) {
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
        try (ResultSet rs = db.executePreparedSelectStatement(sql, state)) {
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
        try (ResultSet rs = db.executePreparedSelectStatement(sql, String.valueOf(userId))) {
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
        db.executePreparedStatement(sql, publication.getTitle(), publication.getDescription(), publication.getState(),
                String.valueOf(publication.getId()));
    }

    public void deletePublicationById(int id) {
        String sql = "DELETE FROM publications WHERE id = ?";
        db.executePreparedStatement(sql, String.valueOf(id));
    }
}
