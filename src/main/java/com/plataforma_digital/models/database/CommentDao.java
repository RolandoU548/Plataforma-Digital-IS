package com.plataforma_digital.models.database;

import java.util.List;
import com.plataforma_digital.models.Comment;

public interface CommentDao {
    public void createComment(Comment comment);

    public Comment getCommentById(int id);

    public List<Comment> getAllCommentsByPublicationId(int publicationId);

    public List<Comment> getAllCommentsByEventId(int eventId);

    public void updateComment(Comment comment);

    public void deleteCommentById(int id);
}
