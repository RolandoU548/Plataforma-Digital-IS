package com.plataforma_digital.views.components;

import com.plataforma_digital.models.Publication;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class CommentsSection extends JPanel {
    private Publication publication;
    private CommentsContainer commentsContainer;
    private AddComment addComment;

    public CommentsSection(Publication publication) {
        this.publication = publication;
        initComponents();
    }

    private void initComponents() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        commentsContainer = new CommentsContainer(publication);
        addComment = new AddComment(publication, commentsContainer);
        add(addComment);
        add(commentsContainer);
    }
}
