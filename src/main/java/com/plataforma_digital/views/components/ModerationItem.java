package com.plataforma_digital.views.components;

import java.awt.Dimension;

import com.plataforma_digital.config.Colors;
import com.plataforma_digital.controllers.components.ModerationItemController;
import com.plataforma_digital.models.Event;
import com.plataforma_digital.models.Publication;
import com.plataforma_digital.views.Moderation;

import javax.swing.JOptionPane;

public class ModerationItem extends javax.swing.JPanel {
        private Moderation moderation;
        private Publication publication;
        private javax.swing.JButton approveButton;
        private javax.swing.JLabel description;
        private javax.swing.JLabel img;
        private javax.swing.JLabel postTitle;
        private javax.swing.JButton rejectButton;
        private ModerationItemController moderationItemController;

        public ModerationItem(Moderation moderation, Publication publication) {
                this.moderation = moderation;
                this.publication = publication;
                this.moderationItemController = new ModerationItemController();
                setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.BLACK, 1, true));
                setMaximumSize(new Dimension(Integer.MAX_VALUE, 135));
                initComponents();
        }

        private void initComponents() {
                img = new javax.swing.JLabel();
                postTitle = new javax.swing.JLabel();
                description = new javax.swing.JLabel();
                approveButton = new javax.swing.JButton();
                rejectButton = new javax.swing.JButton();

                img.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Agregarimagen (1).png")));

                postTitle.setFont(new java.awt.Font("Segoe UI", 1, 14));
                postTitle.setText(publication.getTitle());

                description.setText(publication.getDescription());

                approveButton.setBackground(Colors.BACKGROUND_COLOR);
                approveButton.setText("Aprobar");
                approveButton.addActionListener(e -> {
                        approvePublication();
                });

                rejectButton.setBackground(Colors.BACKGROUND_COLOR);
                rejectButton.setText("Rechazar");
                rejectButton.addActionListener(e -> {
                        rejectPublication();
                });

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
                this.setLayout(layout);
                layout.setHorizontalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(img)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(postTitle)
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                .addComponent(approveButton)
                                                                                                .addPreferredGap(
                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addComponent(rejectButton))
                                                                                .addComponent(description,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                322,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addContainerGap(14, Short.MAX_VALUE)));
                layout.setVerticalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                                .addGap(14, 14, 14)
                                                                .addComponent(img,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                76,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(0, 0, Short.MAX_VALUE))
                                                .addGroup(layout.createSequentialGroup()
                                                                .addGap(0, 8, Short.MAX_VALUE)
                                                                .addComponent(postTitle,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                22,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(description,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                26,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(5, 5, 5)
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(approveButton)
                                                                                .addComponent(rejectButton))
                                                                .addGap(19, 19, 19)));
        }

        private void approvePublication() {
                moderationItemController.approvePublication(publication);
                if (publication instanceof Event) {
                        JOptionPane.showMessageDialog(null, "El evento ha sido aprobado", "Evento aprobado",
                                        JOptionPane.NO_OPTION);
                        moderation.loadEvents();
                } else {
                        JOptionPane.showMessageDialog(null, "La publicación ha sido aprobada", "Publicación aprobada",
                                        JOptionPane.NO_OPTION);
                        moderation.loadPublications();
                }
        }

        private void rejectPublication() {
                moderationItemController.rejectPublication(publication);
                if (publication instanceof Event) {
                        JOptionPane.showMessageDialog(null, "El evento ha sido rechazado", "Evento rechazado",
                                        JOptionPane.NO_OPTION);
                        moderation.loadEvents();
                } else {
                        JOptionPane.showMessageDialog(null, "La publicación ha sido rechazada", "Publicación rechazada",
                                        JOptionPane.NO_OPTION);
                        moderation.loadPublications();
                }
        }
}