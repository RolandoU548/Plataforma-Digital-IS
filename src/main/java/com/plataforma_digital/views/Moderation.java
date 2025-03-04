package com.plataforma_digital.views;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.util.List;

import com.plataforma_digital.config.Colors;
import com.plataforma_digital.controllers.ModerationController;
import com.plataforma_digital.models.Event;
import com.plataforma_digital.models.Publication;
import com.plataforma_digital.views.components.ModerationItem;
import com.plataforma_digital.views.components.ProfileButton;

public class Moderation extends javax.swing.JPanel {
        private Home home;
        private javax.swing.JButton backButton;
        private javax.swing.JPanel jPanel1;
        private javax.swing.JScrollPane jScrollPane1;
        private javax.swing.JToggleButton jToggleButton1;
        private javax.swing.JLabel mainTitle;
        private javax.swing.JButton mod;
        private javax.swing.JButton notification;
        private javax.swing.JLabel pendingPosts;
        private ProfileButton profile;
        private javax.swing.JPanel moderationContainer;
        private JPanel publicationsContainer = new JPanel();
        private JPanel eventsContainer = new JPanel();
        private ModerationController moderationController;

        public Moderation(Home home) {
                this.home = home;
                this.moderationController = new ModerationController();
                initComponents();
                loadPublications();
                loadEvents();
        }

        private void initComponents() {
                jToggleButton1 = new javax.swing.JToggleButton();
                mainTitle = new javax.swing.JLabel();
                pendingPosts = new javax.swing.JLabel();
                jPanel1 = new javax.swing.JPanel();
                backButton = new javax.swing.JButton();
                mod = new javax.swing.JButton();
                notification = new javax.swing.JButton();
                profile = new ProfileButton(home);
                moderationContainer = new javax.swing.JPanel();
                moderationContainer.setLayout(new BoxLayout(moderationContainer, BoxLayout.Y_AXIS));
                moderationContainer.add(publicationsContainer);
                moderationContainer.add(eventsContainer);
                jScrollPane1 = new javax.swing.JScrollPane(moderationContainer);
                jScrollPane1.setBorder(null);

                jToggleButton1.setText("jToggleButton1");

                mainTitle.setFont(new java.awt.Font("Segoe UI", 1, 30));
                mainTitle.setText("Moderación");

                pendingPosts.setFont(new java.awt.Font("Segoe UI", 1, 15));
                pendingPosts.setText("Posts Pendientes");

                jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

                backButton.setBackground(Colors.BACKGROUND_COLOR);
                backButton.setFont(new java.awt.Font("Segoe UI", 1, 18));
                backButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Arrow.png")));
                backButton.setText("Configuración");
                backButton.setBorder(null);
                backButton.setBorderPainted(false);
                backButton.setIconTextGap(20);

                mod.setBackground(Colors.BACKGROUND_COLOR);
                mod.setFont(new java.awt.Font("Segoe UI", 1, 14));
                mod.setIcon(new javax.swing.ImageIcon(getClass().getResource("/plain.png")));
                mod.setText("Moderación");
                mod.setBorder(null);
                mod.setBorderPainted(false);
                mod.setIconTextGap(10);

                javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
                jPanel1.setLayout(jPanel1Layout);
                jPanel1Layout.setHorizontalGroup(
                                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(backButton)
                                                                                .addGroup(jPanel1Layout
                                                                                                .createSequentialGroup()
                                                                                                .addContainerGap()
                                                                                                .addComponent(mod)))
                                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)));
                jPanel1Layout.setVerticalGroup(
                                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGap(18, 18, 18)
                                                                .addComponent(backButton)
                                                                .addGap(39, 39, 39)
                                                                .addComponent(mod)
                                                                .addContainerGap(359, Short.MAX_VALUE)));

                notification.setBackground(Colors.BACKGROUND_COLOR);
                notification.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Bell3.png")));
                notification.setBorder(null);
                notification.setBorderPainted(false);
                notification.setIconTextGap(0);

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
                this.setLayout(layout);
                layout.setHorizontalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jPanel1,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(44, 44, 44)
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                .addComponent(pendingPosts)
                                                                                                .addGap(0, 376, Short.MAX_VALUE))
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                .addComponent(mainTitle)
                                                                                                .addPreferredGap(
                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                Short.MAX_VALUE)
                                                                                                .addComponent(notification,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                42,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addPreferredGap(
                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                                .addComponent(profile))
                                                                                .addComponent(jScrollPane1))
                                                                .addGap(33, 33, 33)));
                layout.setVerticalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                Short.MAX_VALUE)
                                                .addGroup(layout.createSequentialGroup()
                                                                .addGap(19, 19, 19)
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                .addComponent(mainTitle)
                                                                                .addComponent(profile)
                                                                                .addComponent(notification))
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(pendingPosts)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jScrollPane1,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                385,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)));
        }

        public void loadPublications() {
                List<Publication> publications = moderationController.getPublications();
                publicationsContainer.removeAll();
                publicationsContainer.setLayout(new BoxLayout(publicationsContainer, BoxLayout.Y_AXIS));
                if (publications.size() == 0) {
                        JLabel noPosts = new JLabel("No hay publicaciones pendientes");
                        noPosts.setFont(new java.awt.Font("Segoe UI", 1, 15));
                        noPosts.setAlignmentX(CENTER_ALIGNMENT);
                        publicationsContainer.add(noPosts);
                } else {
                        JLabel publicationsLabel = new JLabel("Publicaciones");
                        publicationsLabel.setFont(new java.awt.Font("Segoe UI", 1, 15));
                        publicationsLabel.setAlignmentX(CENTER_ALIGNMENT);
                        publicationsContainer.add(publicationsLabel);
                        for (Publication publication : publications) {
                                publicationsContainer.add(new ModerationItem(this, publication));
                                publicationsContainer.add(Box.createRigidArea(new Dimension(0, 10)));
                        }
                }
                publicationsContainer.revalidate();
                publicationsContainer.repaint();
        }

        public void loadEvents() {
                List<Event> events = moderationController.getEvents();
                eventsContainer.removeAll();
                eventsContainer.setLayout(new BoxLayout(eventsContainer, BoxLayout.Y_AXIS));
                if (events.size() == 0) {
                        JLabel noEvents = new JLabel("No hay eventos pendientes");
                        noEvents.setFont(new java.awt.Font("Segoe UI", 1, 15));
                        noEvents.setAlignmentX(CENTER_ALIGNMENT);
                        eventsContainer.add(noEvents);
                } else {
                        JLabel eventsLabel = new JLabel("Eventos");
                        eventsLabel.setFont(new java.awt.Font("Segoe UI", 1, 15));
                        eventsLabel.setAlignmentX(CENTER_ALIGNMENT);
                        eventsContainer.add(eventsLabel);
                        for (Event event : events) {
                                eventsContainer.add(new ModerationItem(this, event));
                                eventsContainer.add(Box.createRigidArea(new Dimension(0, 10)));
                        }
                }
                eventsContainer.revalidate();
                eventsContainer.repaint();
        }
}