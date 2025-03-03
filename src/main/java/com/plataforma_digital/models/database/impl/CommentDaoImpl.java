package com.plataforma_digital.models.database.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.plataforma_digital.models.database.CommentDao;
import com.plataforma_digital.models.database.DatabaseConnection;
import com.plataforma_digital.models.Comment;

public class CommentDaoImpl implements CommentDao {
    private DatabaseConnection db = DatabaseConnection.getInstance();

    public void createComment(Comment comment) {
        String sql = "INSERT INTO comments (user_id, publication_id, event_id, text) VALUES (?, ?, ?, ?)";
        int generatedId = db.executePreparedStatementWithGeneratedKeys(sql, String.valueOf(comment.getUserId()),
                String.valueOf(comment.getPublicationId()), String.valueOf(comment.getEventId()), comment.getText());
        if (generatedId != -1) {
            comment.setId(generatedId);
        }
    }

    public Comment getCommentById(int id) {
        String sql = "SELECT * FROM comments WHERE id = ?";
        Comment comment = null;
        try (ResultSet rs = db.executePreparedSelectStatement(sql, String.valueOf(id))) {
            if (rs != null && rs.next()) {
                comment = new Comment(rs.getInt("id"), rs.getInt("user_id"), rs.getInt("publication_id"),
                        rs.getInt("event_id"),
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
        try (ResultSet rs = db.executePreparedSelectStatement(sql, String.valueOf(publicationId))) {
            while (rs != null && rs.next()) {
                Comment comment = new Comment(rs.getInt("id"), rs.getInt("user_id"), rs.getInt("publication_id"),
                        rs.getInt("event_id"),
                        rs.getString("text"),
                        rs.getString("created_at"));
                comments.add(comment);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return comments;
    }

    public List<Comment> getAllCommentsByEventId(int eventId) {
        String sql = "SELECT * FROM comments WHERE event_id = ?";
        List<Comment> comments = new ArrayList<>();
        try (ResultSet rs = db.executePreparedSelectStatement(sql, String.valueOf(eventId))) {
            while (rs != null && rs.next()) {
                Comment comment = new Comment(rs.getInt("id"), rs.getInt("user_id"), rs.getInt("publication_id"),
                        rs.getInt("event_id"),
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
        db.executePreparedStatement(sql, comment.getText(),
                String.valueOf(comment.getId()));
    }

    public void deleteCommentById(int id) {
        String sql = "DELETE FROM comments WHERE id = ?";
        db.executePreparedStatement(sql, String.valueOf(id));
    }
}
