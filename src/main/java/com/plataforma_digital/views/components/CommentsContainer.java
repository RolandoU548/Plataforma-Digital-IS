package com.plataforma_digital.views.components;

import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

import com.plataforma_digital.controllers.components.CommentsContainerController;
import com.plataforma_digital.models.Comment;
import com.plataforma_digital.models.Publication;
import java.awt.Dimension;

public class CommentsContainer extends JPanel {
    private Publication publication;
    private CommentsContainerController commentsContainerController;

    public CommentsContainer(Publication publication) {
        this.publication = publication;
        this.commentsContainerController = new CommentsContainerController();
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        getComments();
    }

    public void getComments() {
        List<Comment> comments = commentsContainerController.getComments(publication);
        removeAll();
        for (Comment comment : comments) {
            add(new UserComment(comment));
            add(Box.createRigidArea(new Dimension(0, 10)));
        }
        revalidate();
        repaint();
    }
}