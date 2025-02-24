package com.plataforma_digital.gui.components;

import java.awt.Dimension;

import com.plataforma_digital.config.Colors;
import com.plataforma_digital.gui.Home;
import com.plataforma_digital.gui.ViewAllPublications;
import com.plataforma_digital.gui.ViewPublication;
import com.plataforma_digital.database.DatabaseConnection;
import com.plataforma_digital.entities.Publication;

public class PublicationListItem extends javax.swing.JPanel {
        private Home home;
        private Publication publication;
        private ViewAllPublications viewAllPublications;
        private javax.swing.JButton jButton_Delete;
        private javax.swing.JButton jButton_Edit;
        private javax.swing.JLabel jLabelDescription;
        private javax.swing.JLabel jLabel_Imagen;
        private javax.swing.JButton jLabel_Titulo;

        public PublicationListItem(Home home, ViewAllPublications viewAllPublications, Publication publication) {
                this.home = home;
                this.viewAllPublications = viewAllPublications;
                this.publication = publication;
                setBorder(javax.swing.BorderFactory.createCompoundBorder(
                                javax.swing.BorderFactory.createLineBorder(java.awt.Color.BLACK, 1, true),
                                javax.swing.BorderFactory.createEmptyBorder(0, 0, 10, 0)));
                setMaximumSize(new Dimension(Integer.MAX_VALUE, 135));
                initComponents();
        }

        private void initComponents() {
                jButton_Edit = new javax.swing.JButton();
                jButton_Delete = new javax.swing.JButton();
                jLabelDescription = new javax.swing.JLabel();
                jLabel_Imagen = new javax.swing.JLabel();
                jLabel_Titulo = new javax.swing.JButton();

                jButton_Edit.setBackground(Colors.BACKGROUND_COLOR);
                jButton_Edit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Edit.png")));
                jButton_Edit.setBorderPainted(false);

                jButton_Delete.setBackground(Colors.BACKGROUND_COLOR);
                jButton_Delete.setIcon(new javax.swing.ImageIcon(getClass()
                                .getResource("/delete-button-trash-can-bin-symbol-delete-web-icon-illustration-free-vector (1).jpg")));
                jButton_Delete.setText("Eliminar");
                jButton_Delete.setBorderPainted(false);
                jButton_Delete.addActionListener(e -> {
                        deletePublication();
                });

                jLabelDescription.setFont(new java.awt.Font("Segoe UI", 1, 14));
                jLabelDescription.setText(publication.getDescription());

                jLabel_Imagen.setIcon(new javax.swing.ImageIcon(
                                getClass().getResource("/Leuctra.inermis.-.lindsey (1).jpg")));
                jLabel_Imagen.setText("jLabel4");

                jLabel_Titulo.setFont(new java.awt.Font("Segoe UI", 1, 18));
                jLabel_Titulo.setText(publication.getTitle());
                jLabel_Titulo.setBackground(Colors.BACKGROUND_COLOR);
                jLabel_Titulo.setBorderPainted(false);
                jLabel_Titulo.addActionListener(e -> {
                        ViewPublication viewPublication = new ViewPublication(home, publication);
                        home.addAndShowPanel(viewPublication, "viewPublication");
                });

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
                this.setLayout(layout);
                layout.setHorizontalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                .addContainerGap()
                                                                                                .addComponent(jLabelDescription)
                                                                                                .addGap(44, 44, 44)
                                                                                                .addPreferredGap(
                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                                                37,
                                                                                                                Short.MAX_VALUE))
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                .addGap(22, 22, 22)
                                                                                                .addPreferredGap(
                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                Short.MAX_VALUE)
                                                                                                .addGap(50)))
                                                                .addComponent(jButton_Delete,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                117,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jButton_Edit,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                38,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(1, 1, 1))
                                                .addGroup(layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(jLabel_Imagen,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                65,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jLabel_Titulo)
                                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)));
                layout.setVerticalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(jLabel_Titulo)
                                                                                .addComponent(jLabel_Imagen,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                Short.MAX_VALUE))
                                                                .addGap(18, 18, 18)
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                                layout
                                                                                                                .createSequentialGroup()
                                                                                                                .addGroup(layout
                                                                                                                                .createParallelGroup(
                                                                                                                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                                                                .addComponent(jLabelDescription))
                                                                                                                .addPreferredGap(
                                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                                .addGroup(layout
                                                                                                                                .createParallelGroup(
                                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING))
                                                                                                                .addContainerGap())
                                                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                                layout
                                                                                                                .createParallelGroup(
                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                .addComponent(jButton_Delete,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                36,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                .addComponent(jButton_Edit,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                34,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)))));
                setVisible(true);
        }

        private void deletePublication() {
                DatabaseConnection.getInstance().deletePublicationById(publication.getId());
                viewAllPublications.getPublications();
        }
}
