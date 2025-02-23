package com.plataforma_digital.gui;

import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.plataforma_digital.database.DatabaseConnection;
import com.plataforma_digital.entities.Publication;
import com.plataforma_digital.entities.Event;

public class Moderation extends JPanel {
    JLabel moderationLabel;
    Home home;
    List<JPanel> publicationPanels = new ArrayList<>();
    List<JPanel> eventPanels = new ArrayList<>();

    public Moderation(Home home) {
        this.home = home;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        initComponents();
    }

    private void initComponents() {
        moderationLabel = new JLabel("Moderation");
        moderationLabel.setAlignmentX(CENTER_ALIGNMENT);
        add(moderationLabel);
        getPublications();
        getEvents();
    }

    public void getPublications() {
        List<Publication> publications = DatabaseConnection.getInstance().getAllPublicationsByState("in moderation");
        for (Publication publication : publications) {
            JPanel publicationPanel = new JPanel();
            publicationPanel.add(new JLabel("Title: " + publication.getTitle()));
            publicationPanel.add(new JLabel("Created At: " + publication.getCreatedAt()));
            JButton viewPublicationButton = new JButton("View Publication");
            viewPublicationButton.addActionListener(e -> {
                ViewPublication viewPublication = new ViewPublication(home, publication);
                home.addAndShowPanel(viewPublication, "viewPublication");
            });
            JButton approvePublicationButton = new JButton("Approve Publication");
            JButton rejectPublicationButton = new JButton("Reject Publication");
            approvePublicationButton.addActionListener(e -> {
                publication.setState("approved");
                DatabaseConnection.getInstance().updatePublication(publication);
                JOptionPane.showMessageDialog(null, "La publicación ha sido aprobada", "Publicación aprobada",
                        JOptionPane.NO_OPTION);
                approvePublicationButton.setEnabled(false);
                rejectPublicationButton.setEnabled(false);
            });
            rejectPublicationButton.addActionListener(e -> {
                publication.setState("rejected");
                DatabaseConnection.getInstance().updatePublication(publication);
                JOptionPane.showMessageDialog(null, "La publicación ha sido rechazada", "Publicación rechazada",
                        JOptionPane.NO_OPTION);
                rejectPublicationButton.setEnabled(false);
                approvePublicationButton.setEnabled(false);

            });
            publicationPanel.add(viewPublicationButton);
            publicationPanel.add(approvePublicationButton);
            publicationPanel.add(rejectPublicationButton);
            publicationPanels.add(publicationPanel);
            add(publicationPanel);
        }
    }

    public void getEvents() {
        List<Event> events = DatabaseConnection.getInstance().getAllEventsByState("in moderation");
        for (Event event : events) {
            JPanel eventPanel = new JPanel();
            eventPanel.add(new JLabel("Title: " + event.getTitle()));
            eventPanel.add(new JLabel("Created At: " + event.getCreatedAt()));
            JButton viewEventButton = new JButton("View Event");
            viewEventButton.addActionListener(e -> {
                ViewEvent viewEvent = new ViewEvent(home, event);
                home.addAndShowPanel(viewEvent, "viewEvent");
            });
            JButton approveEventButton = new JButton("Approve Event");
            JButton rejectEventButton = new JButton("Reject Event");
            approveEventButton.addActionListener(e -> {
                event.setState("approved");
                DatabaseConnection.getInstance().updateEvent(event);
                JOptionPane.showMessageDialog(null, "El evento ha sido aprobado", "Evento aprobado",
                        JOptionPane.NO_OPTION);
                approveEventButton.setEnabled(false);
                rejectEventButton.setEnabled(false);
            });
            rejectEventButton.addActionListener(e -> {
                event.setState("rejected");
                DatabaseConnection.getInstance().updateEvent(event);
                JOptionPane.showMessageDialog(null, "El evento ha sido rechazado", "Evento rechazado",
                        JOptionPane.NO_OPTION);
                rejectEventButton.setEnabled(false);
                approveEventButton.setEnabled(false);

            });
            eventPanel.add(viewEventButton);
            eventPanel.add(approveEventButton);
            eventPanel.add(rejectEventButton);
            eventPanels.add(eventPanel);
            add(eventPanel);
        }
    }

    public void clear() {
        for (JPanel publicationPanel : publicationPanels) {
            remove(publicationPanel);
        }
        for (JPanel eventPanel : eventPanels) {
            remove(eventPanel);
        }
    }
}
