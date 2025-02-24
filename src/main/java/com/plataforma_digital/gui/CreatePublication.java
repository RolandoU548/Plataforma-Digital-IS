package com.plataforma_digital.gui;

import javax.swing.JOptionPane;

import com.plataforma_digital.config.Colors;
import com.plataforma_digital.database.DatabaseConnection;
import com.plataforma_digital.entities.CurrentUser;
import com.plataforma_digital.entities.Publication;
import com.plataforma_digital.gui.components.ProfileButton;;

public class CreatePublication extends javax.swing.JPanel {
        private Home home;
        private javax.swing.JButton backButton;
        private javax.swing.JButton cancelButton;
        private javax.swing.JLabel description;
        private javax.swing.JLabel file;
        private javax.swing.JFileChooser fileChooser;
        private javax.swing.JButton jButton4;
        private javax.swing.JButton jButton5;
        private javax.swing.JPanel jPanel1;
        private javax.swing.JTextField titleTextField;
        private javax.swing.JTextField descriptionTextField;
        private javax.swing.JLabel mainTitle;
        private javax.swing.JButton notification;
        private javax.swing.JButton postButton;
        private ProfileButton profileButton;
        private javax.swing.JLabel title;

        public CreatePublication(Home home) {
                this.home = home;
                initComponents();
        }

        private void initComponents() {
                mainTitle = new javax.swing.JLabel();
                title = new javax.swing.JLabel();
                description = new javax.swing.JLabel();
                file = new javax.swing.JLabel();
                jPanel1 = new javax.swing.JPanel();
                backButton = new javax.swing.JButton();
                jButton4 = new javax.swing.JButton();
                jButton5 = new javax.swing.JButton();
                titleTextField = new javax.swing.JTextField();
                descriptionTextField = new javax.swing.JTextField();
                fileChooser = new javax.swing.JFileChooser();
                cancelButton = new javax.swing.JButton();
                postButton = new javax.swing.JButton();
                notification = new javax.swing.JButton();
                profileButton = new ProfileButton(home);

                mainTitle.setFont(new java.awt.Font("Segoe UI", 1, 30));
                mainTitle.setText("Crear Publicación");

                title.setFont(new java.awt.Font("Segoe UI", 1, 15));
                title.setText("Título de la Publicación");

                description.setFont(new java.awt.Font("Segoe UI", 1, 15));
                description.setText("Descripción");

                file.setFont(new java.awt.Font("Segoe UI", 1, 15));
                file.setText("Agregar Archivo");

                jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

                backButton.setBackground(Colors.BACKGROUND_COLOR);
                backButton.setFont(new java.awt.Font("Segoe UI", 1, 18));
                backButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Arrow.png")));
                backButton.setText("Publicación");
                backButton.setBorder(null);
                backButton.setBorderPainted(false);
                backButton.setIconTextGap(30);

                jButton4.setBackground(Colors.BACKGROUND_COLOR);
                jButton4.setFont(new java.awt.Font("Segoe UI", 1, 14));
                jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/plain.png")));
                jButton4.setText("Crear Publicación");
                jButton4.setBorder(null);
                jButton4.setBorderPainted(false);
                jButton4.setIconTextGap(10);

                jButton5.setBackground(Colors.BACKGROUND_COLOR);
                jButton5.setFont(new java.awt.Font("Segoe UI", 1, 14));
                jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/folder.png")));
                jButton5.setText("Mis Publicaciones");
                jButton5.setBorder(null);
                jButton5.setBorderPainted(false);
                jButton5.setIconTextGap(10);
                jButton5.addActionListener(e -> {
                        ViewAllPublications viewAllPublications = new ViewAllPublications(home);
                        home.viewAllPublications = viewAllPublications;
                        home.addAndShowPanel(viewAllPublications, "viewAllPublications");
                });

                javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
                jPanel1.setLayout(jPanel1Layout);
                jPanel1Layout.setHorizontalGroup(
                                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(backButton,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                190,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(0, 0, Short.MAX_VALUE))
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(jButton4,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                190,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(jButton5,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                190,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addContainerGap(26, Short.MAX_VALUE)));
                jPanel1Layout.setVerticalGroup(
                                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGap(18, 18, 18)
                                                                .addComponent(backButton)
                                                                .addGap(40, 40, 40)
                                                                .addComponent(jButton4)
                                                                .addGap(32, 32, 32)
                                                                .addComponent(jButton5)
                                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)));

                cancelButton.setText("Cancelar");

                postButton.setBackground(new java.awt.Color(0, 0, 0));
                postButton.setForeground(new java.awt.Color(255, 255, 255));
                postButton.setFont(new java.awt.Font("Segoe UI", 1, 14));
                postButton.setText("Publicar");
                postButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
                postButton.addActionListener(e -> {
                        if (validateFields()) {
                                createPublication();
                                clearFields();
                        }
                });

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
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                .addGap(28, 28, 28)
                                                                                                .addGroup(layout
                                                                                                                .createParallelGroup(
                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                .addComponent(title)
                                                                                                                .addComponent(titleTextField,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                350,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                .addComponent(description)
                                                                                                                .addComponent(descriptionTextField,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                350,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                .addComponent(file)
                                                                                                                .addComponent(fileChooser,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                350,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                                                .addComponent(mainTitle)
                                                                                                                                .addPreferredGap(
                                                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                                                                                112,
                                                                                                                                                Short.MAX_VALUE)
                                                                                                                                .addComponent(notification,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                42,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                                .addGap(18, 18, 18)
                                                                                                                                .addComponent(profileButton)
                                                                                                                                .addGap(33, 33, 33))))
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                .addGap(81, 81, 81)
                                                                                                .addComponent(cancelButton,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                100,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addGap(70, 70, 70)
                                                                                                .addComponent(postButton,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                100,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addGap(105, 105,
                                                                                                                105)))));
                layout.setVerticalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(layout.createSequentialGroup()
                                                                .addGap(18, 18, 18)
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                .addComponent(profileButton)
                                                                                                .addContainerGap(
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                Short.MAX_VALUE))
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                .addGroup(layout
                                                                                                                .createParallelGroup(
                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                                                .addGap(1, 1, 1)
                                                                                                                                .addComponent(mainTitle))
                                                                                                                .addComponent(notification))
                                                                                                .addPreferredGap(
                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                                .addComponent(title)
                                                                                                .addPreferredGap(
                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                                .addComponent(titleTextField,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addPreferredGap(
                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                                .addComponent(description)
                                                                                                .addPreferredGap(
                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addComponent(descriptionTextField,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addPreferredGap(
                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                                .addComponent(file)
                                                                                                .addPreferredGap(
                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                                .addComponent(fileChooser,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                145,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addPreferredGap(
                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                                                59,
                                                                                                                Short.MAX_VALUE)
                                                                                                .addGroup(layout
                                                                                                                .createParallelGroup(
                                                                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                                                .addComponent(cancelButton)
                                                                                                                .addComponent(postButton))
                                                                                                .addGap(40, 40, 40)))));
        }

        private void clearFields() {
                titleTextField.setText("");
                descriptionTextField.setText("");
        }

        private boolean validateFields() {
                if (titleTextField.getText().isEmpty() || descriptionTextField.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Todos los campos son requeridos", "Campos requeridos",
                                        JOptionPane.INFORMATION_MESSAGE);
                        return false;
                }
                return true;
        }

        private void createPublication() {
                Publication newPublication = new Publication(0, CurrentUser.getCurrentUser().getId(),
                                titleTextField.getText(),
                                descriptionTextField.getText(), "in moderation", null);
                DatabaseConnection.getInstance().createPublication(newPublication);
                JOptionPane.showMessageDialog(null,
                                "Tu publicación está pendiente de moderación, será publicada en cuanto sea aprobada",
                                "Publicación creada",
                                JOptionPane.INFORMATION_MESSAGE);
        }
}
