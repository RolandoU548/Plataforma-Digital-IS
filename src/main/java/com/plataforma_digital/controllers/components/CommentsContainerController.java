package com.plataforma_digital.controllers.components;

import com.plataforma_digital.models.Comment;
import com.plataforma_digital.models.Event;
import com.plataforma_digital.models.Publication;
import com.plataforma_digital.models.database.CommentDao;
import com.plataforma_digital.models.database.impl.CommentDaoImpl;

import java.util.List;

public class CommentsContainerController {
    private CommentDao commentDao;

    public CommentsContainerController() {
        this.commentDao = new CommentDaoImpl();
    }

    public List<Comment> getComments(Publication publication) {
        if (publication instanceof Event) {
            return commentDao.getAllCommentsByEventId(publication.getId());
        } else {
            return commentDao.getAllCommentsByPublicationId(publication.getId());
        }
    }
}