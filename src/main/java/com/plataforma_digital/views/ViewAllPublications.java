package com.plataforma_digital.views;

import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import java.awt.Dimension;

import com.plataforma_digital.config.Colors;
import com.plataforma_digital.controllers.ViewAllPublicationsController;
import com.plataforma_digital.models.Publication;
import com.plataforma_digital.views.components.PublicationListItem;
import com.plataforma_digital.views.components.ProfileButton;

public class ViewAllPublications extends javax.swing.JPanel {
        private Home home;
        private javax.swing.JButton BottonFlechapublicaciones;
        private javax.swing.JButton jButtonCrearPublicacion;
        private javax.swing.JButton jButtonMispublicaciones;
        private javax.swing.JButton jButton_bell;
        private javax.swing.JLabel jLabelCrearpublicacion;
        private javax.swing.JPanel jPanel1;
        private javax.swing.JScrollPane jScrollPane_MisPublicaciones;
        private ProfileButton profileButton;
        private JPanel publicationsContainer = new JPanel();
        private ViewAllPublicationsController viewAllPublicationsController;

        public ViewAllPublications(Home home) {
                this.home = home;
                this.viewAllPublicationsController = new ViewAllPublicationsController();
                initComponents();
                loadPublications();
        }

        private void initComponents() {
                jPanel1 = new javax.swing.JPanel();
                BottonFlechapublicaciones = new javax.swing.JButton();
                jButtonCrearPublicacion = new javax.swing.JButton();
                jButtonMispublicaciones = new javax.swing.JButton();
                jLabelCrearpublicacion = new javax.swing.JLabel();
                profileButton = new ProfileButton(home);
                jButton_bell = new javax.swing.JButton();

                publicationsContainer.setLayout(new BoxLayout(publicationsContainer, BoxLayout.Y_AXIS));
                publicationsContainer.setAlignmentY(TOP_ALIGNMENT);
                jScrollPane_MisPublicaciones = new javax.swing.JScrollPane(publicationsContainer);
                jScrollPane_MisPublicaciones.setBorder(null);

                jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

                BottonFlechapublicaciones.setBackground(Colors.BACKGROUND_COLOR);
                BottonFlechapublicaciones.setFont(new java.awt.Font("Segoe UI", 1, 14));
                BottonFlechapublicaciones.setIcon(new javax.swing.ImageIcon(
                                getClass().getResource("/Arrow.png")));
                BottonFlechapublicaciones.setText("  Publicacion");
                BottonFlechapublicaciones.setBorderPainted(false);

                jButtonCrearPublicacion.setBackground(Colors.BACKGROUND_COLOR);
                jButtonCrearPublicacion.setFont(new java.awt.Font("Segoe UI", 1, 14));
                jButtonCrearPublicacion.setIcon(new javax.swing.ImageIcon(
                                getClass().getResource("/plain.png")));
                jButtonCrearPublicacion.setText("Crear Publicacion");
                jButtonCrearPublicacion.setBorderPainted(false);
                jButtonCrearPublicacion.addActionListener(e -> {
                        CreatePublication createPublication = new CreatePublication(home);
                        home.createPublication = createPublication;
                        home.addAndShowPanel(createPublication, "createPublication");
                });

                jButtonMispublicaciones.setBackground(Colors.BACKGROUND_COLOR);
                jButtonMispublicaciones.setFont(new java.awt.Font("Segoe UI", 1, 14));
                jButtonMispublicaciones.setIcon(new javax.swing.ImageIcon(
                                getClass().getResource("/folder.png")));
                jButtonMispublicaciones.setText("Mis Publicaciones");
                jButtonMispublicaciones.setBorderPainted(false);

                javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
                jPanel1.setLayout(jPanel1Layout);
                jPanel1Layout.setHorizontalGroup(
                                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(BottonFlechapublicaciones)
                                                                .addGap(0, 0, Short.MAX_VALUE))
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(jButtonCrearPublicacion)
                                                                                .addComponent(jButtonMispublicaciones,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                173,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addContainerGap(15, Short.MAX_VALUE)));
                jPanel1Layout.setVerticalGroup(
                                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(BottonFlechapublicaciones)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(jButtonCrearPublicacion,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                60,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jButtonMispublicaciones)
                                                                .addGap(0, 331, Short.MAX_VALUE)));

                jLabelCrearpublicacion.setFont(new java.awt.Font("Segoe UI", 1, 30));
                jLabelCrearpublicacion.setText("Mis Publicaciones");

                jButton_bell.setBackground(Colors.BACKGROUND_COLOR);
                jButton_bell.setIcon(new javax.swing.ImageIcon(
                                getClass().getResource("/Bell3.png")));
                jButton_bell.setBorderPainted(false);

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
                this.setLayout(layout);
                layout.setHorizontalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jPanel1,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                .addComponent(jLabelCrearpublicacion)
                                                                                                .addPreferredGap(
                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                                                224,
                                                                                                                Short.MAX_VALUE)
                                                                                                .addComponent(jButton_bell)
                                                                                                .addPreferredGap(
                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addComponent(profileButton))
                                                                                .addComponent(jScrollPane_MisPublicaciones))
                                                                .addContainerGap()));
                layout.setVerticalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                .addGap(35, 35, 35)
                                                                                                .addComponent(jLabelCrearpublicacion))
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                .addContainerGap()
                                                                                                .addGroup(layout
                                                                                                                .createParallelGroup(
                                                                                                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                                                .addComponent(profileButton,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                32,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                .addComponent(jButton_bell,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                34,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jScrollPane_MisPublicaciones)));
        }

        public void loadPublications() {
                List<Publication> publications = viewAllPublicationsController.getApprovedPublications();
                publicationsContainer.removeAll();
                publicationsContainer.setLayout(new BoxLayout(publicationsContainer, BoxLayout.Y_AXIS));
                for (Publication publication : publications) {
                        publicationsContainer.add(new PublicationListItem(home, this, publication));
                        publicationsContainer.add(Box.createRigidArea(new Dimension(0, 10)));
                }
                publicationsContainer.revalidate();
                publicationsContainer.repaint();
        }
}