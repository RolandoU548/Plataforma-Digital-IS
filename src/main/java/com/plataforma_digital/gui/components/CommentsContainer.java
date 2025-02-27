package com.plataforma_digital.gui.components;

import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

import com.plataforma_digital.database.CommentDao;
import com.plataforma_digital.database.impl.CommentDaoImpl;
import com.plataforma_digital.entities.Comment;
import com.plataforma_digital.entities.Publication;
import com.plataforma_digital.entities.Event;

import java.awt.Dimension;

public class CommentsContainer extends JPanel {
    private Publication publication;

    public CommentsContainer(Publication publication) {
        this.publication = publication;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        getComments();
    }

    public void getComments() {
        CommentDao commentDao = new CommentDaoImpl();
        List<Comment> comments = (publication instanceof Event)
                ? commentDao.getAllCommentsByEventId(publication.getId())
                : commentDao.getAllCommentsByPublicationId(publication.getId());
        removeAll();
        for (Comment comment : comments) {
            add(new UserComment(comment));
            add(Box.createRigidArea(new Dimension(0, 10)));
        }
        revalidate();
        repaint();
    }
}