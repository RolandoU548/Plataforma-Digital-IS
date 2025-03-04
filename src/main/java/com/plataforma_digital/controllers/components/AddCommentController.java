package com.plataforma_digital.controllers.components;

import com.plataforma_digital.models.Comment;
import com.plataforma_digital.models.CurrentUser;
import com.plataforma_digital.models.Event;
import com.plataforma_digital.models.Publication;
import com.plataforma_digital.models.database.CommentDao;
import com.plataforma_digital.models.database.impl.CommentDaoImpl;

public class AddCommentController {
    private CommentDao commentDao;

    public AddCommentController() {
        this.commentDao = new CommentDaoImpl();
    }

    public void addComment(Publication publication, String commentText) {
        if (publication instanceof Event) {
            commentDao.createComment(
                    new Comment(0, CurrentUser.getCurrentUser().getId(), 0, publication.getId(), commentText, null));
        } else {
            commentDao.createComment(
                    new Comment(0, CurrentUser.getCurrentUser().getId(), publication.getId(), 0, commentText, null));
        }
    }
}