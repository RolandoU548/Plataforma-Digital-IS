package com.plataforma_digital.gui;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import com.plataforma_digital.database.DatabaseConnection;
import com.plataforma_digital.entities.Event;
import com.plataforma_digital.entities.User;

public class ViewEvent extends JPanel {
    Home home;
    JPanel eventPanel;
    JLabel viewEventLabel;
    JLabel eventCreatorLabel;
    JLabel eventTitleLabel;
    JLabel eventDescriptionLabel;
    JLabel eventCreatedAtLabel;
    JTextArea commentTextArea;
    JLabel commentLabel;
    JButton commentButton;
    CreateComment createComment;
    CommentsSection commentsSection;

    public ViewEvent(Home home, Event event) {
        this.home = home;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        initComponents(event);
    }

    private void initComponents(Event event) {
        initEventPanel(event);
        initCommentsSection(event);
        initCreateComment(event);

        add(createComment);
        add(commentsSection);
    }

    private void initEventPanel(Event event) {
        User creator = DatabaseConnection.getInstance().getUserById(event.getUserId());
        eventPanel = new JPanel();
        viewEventLabel = new JLabel("View Event");
        eventCreatorLabel = new JLabel(
                "Created by: " + creator.getEmail());
        eventTitleLabel = new JLabel("Title: " + event.getTitle());
        eventDescriptionLabel = new JLabel("Description: " + event.getDescription());
        eventCreatedAtLabel = new JLabel("Created at: " + event.getCreatedAt());

        JPanel auxPanel = new JPanel();
        auxPanel.setLayout(new BoxLayout(auxPanel, BoxLayout.Y_AXIS));
        auxPanel.add(viewEventLabel);
        auxPanel.add(eventCreatorLabel);
        auxPanel.add(eventTitleLabel);
        auxPanel.add(eventDescriptionLabel);
        auxPanel.add(eventCreatedAtLabel);
        eventPanel.add(auxPanel);
        add(eventPanel);
    }

    private void initCommentsSection(Event event) {
        commentsSection = new CommentsSection(event);
        commentsSection.updateComments();
    }

    private void initCreateComment(Event event) {
        createComment = new CreateComment(commentsSection, event);
    }
}
