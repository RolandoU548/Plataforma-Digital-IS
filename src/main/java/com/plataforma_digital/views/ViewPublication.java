package com.plataforma_digital.views;

import com.plataforma_digital.config.Colors;
import com.plataforma_digital.controllers.ViewPublicationController;
import com.plataforma_digital.models.Publication;
import com.plataforma_digital.models.User;
import com.plataforma_digital.views.components.CommentsSection;
import com.plataforma_digital.views.components.ProfileButton;

public class ViewPublication extends javax.swing.JPanel {
        private Home home;
        private Publication publication;
        private ViewPublicationController viewPublicationController;
        private javax.swing.JLabel author;
        private javax.swing.JButton backButton;
        private javax.swing.JButton createPublicationButton;
        private javax.swing.JLabel description;
        private javax.swing.JLabel image;
        private javax.swing.JPanel jPanel1;
        private javax.swing.JScrollPane jScrollPane1;
        private javax.swing.JLabel mainTitle;
        private javax.swing.JButton myPublications;
        private javax.swing.JButton notification;
        private ProfileButton profile;
        private CommentsSection commentsSection;

        public ViewPublication(Home home, Publication publication) {
                this.home = home;
                this.publication = publication;
                this.viewPublicationController = new ViewPublicationController();
                initComponents();
        }

        private void initComponents() {
                mainTitle = new javax.swing.JLabel();
                author = new javax.swing.JLabel();
                description = new javax.swing.JLabel();
                jPanel1 = new javax.swing.JPanel();
                backButton = new javax.swing.JButton();
                createPublicationButton = new javax.swing.JButton();
                myPublications = new javax.swing.JButton();
                notification = new javax.swing.JButton();
                profile = new ProfileButton(home);
                image = new javax.swing.JLabel();

                commentsSection = new CommentsSection(publication);
                jScrollPane1 = new javax.swing.JScrollPane(commentsSection);
                jScrollPane1.setBorder(null);

                mainTitle.setFont(new java.awt.Font("Segoe UI", 1, 30));
                mainTitle.setText(publication.getTitle());

                User authorUser = viewPublicationController.getPublicationAuthor(publication.getUserId());
                author.setFont(new java.awt.Font("Segoe UI", 1, 15));
                author.setText("Autor: " + authorUser.getEmail());

                description.setFont(new java.awt.Font("Segoe UI", 1, 15));
                description.setText("Descripción: " + publication.getDescription());

                jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

                backButton.setBackground(Colors.BACKGROUND_COLOR);
                backButton.setFont(new java.awt.Font("Segoe UI", 1, 18));
                backButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Arrow.png")));
                backButton.setText("Publicaciones");
                backButton.setBorder(null);
                backButton.setBorderPainted(false);
                backButton.setIconTextGap(30);

                createPublicationButton.setBackground(Colors.BACKGROUND_COLOR);
                createPublicationButton.setFont(new java.awt.Font("Segoe UI", 1, 14));
                createPublicationButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/plain.png")));
                createPublicationButton.setText("Crear Publicación");
                createPublicationButton.setBorder(null);
                createPublicationButton.setBorderPainted(false);
                createPublicationButton.setIconTextGap(10);
                createPublicationButton.addActionListener(e -> {
                        CreatePublication createPublication = new CreatePublication(home);
                        home.createPublication = createPublication;
                        home.addAndShowPanel(createPublication, "createPublication");
                });

                myPublications.setBackground(Colors.BACKGROUND_COLOR);
                myPublications.setFont(new java.awt.Font("Segoe UI", 1, 14));
                myPublications.setIcon(new javax.swing.ImageIcon(getClass().getResource("/folder.png")));
                myPublications.setText("Mis Publicaciones");
                myPublications.setBorder(null);
                myPublications.setBorderPainted(false);
                myPublications.setIconTextGap(10);
                myPublications.addActionListener(e -> {
                        ViewAllPublications viewAllPublications = new ViewAllPublications(home);
                        home.viewAllPublications = viewAllPublications;
                        home.addAndShowPanel(viewAllPublications, "viewAllPublications");
                });

                javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
                jPanel1.setLayout(jPanel1Layout);
                jPanel1Layout.setHorizontalGroup(
                                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                false)
                                                                                .addComponent(backButton,
                                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                Short.MAX_VALUE)
                                                                                .addGroup(jPanel1Layout
                                                                                                .createSequentialGroup()
                                                                                                .addContainerGap()
                                                                                                .addGroup(jPanel1Layout
                                                                                                                .createParallelGroup(
                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                                                false)
                                                                                                                .addComponent(createPublicationButton,
                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                Short.MAX_VALUE)
                                                                                                                .addComponent(myPublications,
                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                Short.MAX_VALUE))))
                                                                .addContainerGap(9, Short.MAX_VALUE)));
                jPanel1Layout.setVerticalGroup(
                                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGap(18, 18, 18)
                                                                .addComponent(backButton)
                                                                .addGap(40, 40, 40)
                                                                .addComponent(createPublicationButton)
                                                                .addGap(32, 32, 32)
                                                                .addComponent(myPublications)
                                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)));

                notification.setBackground(Colors.BACKGROUND_COLOR);
                notification.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Bell3.png")));
                notification.setBorder(null);
                notification.setBorderPainted(false);
                notification.setIconTextGap(0);

                image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images.jpg")));

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
                this.setLayout(layout);
                layout.setHorizontalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jPanel1,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                .addGap(44, 44, 44)
                                                                                                .addGroup(layout.createParallelGroup(
                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                                                .addComponent(mainTitle)
                                                                                                                                .addGap(12, 12, 12)
                                                                                                                                .addComponent(notification,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                42,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                                .addPreferredGap(
                                                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                                                                .addComponent(profile))
                                                                                                                .addComponent(author)
                                                                                                                .addComponent(description)
                                                                                                                .addComponent(image)))
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                .addGap(12, 12, 12)
                                                                                                .addComponent(jScrollPane1,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                525,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                .addGap(0, 33, Short.MAX_VALUE)));
                layout.setVerticalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(layout.createSequentialGroup()
                                                                .addGap(19, 19, 19)
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                .addComponent(mainTitle)
                                                                                .addComponent(notification)
                                                                                .addComponent(profile))
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(author)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(description)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(image,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                141,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jScrollPane1,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                122,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addContainerGap(24, Short.MAX_VALUE)));
        }
}