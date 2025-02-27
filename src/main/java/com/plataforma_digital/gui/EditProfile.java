package com.plataforma_digital.gui;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPanel;

import com.plataforma_digital.config.Colors;
import com.plataforma_digital.database.UserDao;
import com.plataforma_digital.database.impl.UserDaoImpl;
import com.plataforma_digital.entities.CurrentUser;
import com.plataforma_digital.entities.User;
import com.plataforma_digital.utils.StringUtils;

public class EditProfile extends JPanel {
        public Home home;
        JLabel editProfileLabel;
        private JTextField emailTextField;
        private JTextField firstNameTextField;
        private JTextField lastNameTextField;
        private JTextField passwordTextField;
        private JLabel emailLabel;
        private javax.swing.JLabel firstNameLabel;
        private JLabel lastNameLabel;
        private JLabel passwordLabel;
        private JButton saveProfileButton;
        private javax.swing.JButton cancelButton;
        private javax.swing.JButton configButton;
        private javax.swing.JButton editProfileButton;
        private javax.swing.JButton notificationsButton;
        private javax.swing.JButton securityButton;
        private javax.swing.JLabel LabelImgBell;
        private javax.swing.JLabel LabelImgUser1;
        private javax.swing.JLabel jLabelImgUser2;
        private javax.swing.JPanel jPanel2;
        private javax.swing.JPanel jPanel3;

        public EditProfile(Home home) {
                this.home = home;
                initComponents();
                updateCurrentUserInfo();
        }

        private void initComponents() {
                jPanel2 = new javax.swing.JPanel();
                configButton = new javax.swing.JButton();
                editProfileButton = new javax.swing.JButton();
                notificationsButton = new javax.swing.JButton();
                securityButton = new javax.swing.JButton();
                jPanel3 = new javax.swing.JPanel();
                editProfileLabel = new javax.swing.JLabel();
                LabelImgUser1 = new javax.swing.JLabel();
                LabelImgBell = new javax.swing.JLabel();
                jLabelImgUser2 = new javax.swing.JLabel();
                firstNameLabel = new javax.swing.JLabel();
                lastNameLabel = new javax.swing.JLabel();
                emailLabel = new javax.swing.JLabel();
                passwordLabel = new javax.swing.JLabel();
                firstNameTextField = new javax.swing.JTextField();
                lastNameTextField = new javax.swing.JTextField();
                emailTextField = new javax.swing.JTextField();
                passwordTextField = new javax.swing.JPasswordField();
                cancelButton = new javax.swing.JButton();
                saveProfileButton = new javax.swing.JButton();

                jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

                configButton.setBackground(Colors.BACKGROUND_COLOR);
                configButton.setFont(new java.awt.Font("Segoe UI", 1, 14));
                configButton
                                .setIcon(new javax.swing.ImageIcon(
                                                getClass().getResource("/Arrow.png")));
                configButton.setText(" Configuración");
                configButton.setBorderPainted(false);

                editProfileButton.setBackground(Colors.BACKGROUND_COLOR);
                editProfileButton.setFont(new java.awt.Font("Segoe UI", 1, 14));
                editProfileButton
                                .setIcon(new javax.swing.ImageIcon(
                                                getClass().getResource("/Edit.png")));
                editProfileButton.setText(" Editar perfil");
                editProfileButton.setBorderPainted(false);

                notificationsButton.setBackground(Colors.BACKGROUND_COLOR);
                notificationsButton.setFont(new java.awt.Font("Segoe UI", 1, 14));
                notificationsButton
                                .setIcon(new javax.swing.ImageIcon(
                                                getClass().getResource("/Bell2.png")));
                notificationsButton.setText("  Notificaciones");
                notificationsButton.setBorderPainted(false);

                securityButton.setBackground(Colors.BACKGROUND_COLOR);
                securityButton.setFont(new java.awt.Font("Segoe UI", 1, 14));
                securityButton
                                .setIcon(new javax.swing.ImageIcon(
                                                getClass().getResource("/Lock.png")));
                securityButton.setText("  Seguridad");
                securityButton.setBorderPainted(false);

                javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
                jPanel2.setLayout(jPanel2Layout);
                jPanel2Layout.setHorizontalGroup(
                                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel2Layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addGroup(jPanel2Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(securityButton)
                                                                                .addComponent(editProfileButton)
                                                                                .addComponent(notificationsButton)
                                                                                .addComponent(configButton))
                                                                .addContainerGap(14, Short.MAX_VALUE)));
                jPanel2Layout.setVerticalGroup(
                                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel2Layout.createSequentialGroup()
                                                                .addGap(16, 16, 16)
                                                                .addComponent(configButton)
                                                                .addGap(52, 52, 52)
                                                                .addComponent(editProfileButton)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(notificationsButton)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(securityButton)
                                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)));

                editProfileLabel.setFont(new java.awt.Font("Segoe UI", 1, 30));
                editProfileLabel.setText("Editar Perfil");

                LabelImgUser1
                                .setIcon(new javax.swing.ImageIcon(
                                                getClass().getResource("/user1.png")));

                LabelImgBell
                                .setIcon(new javax.swing.ImageIcon(
                                                getClass().getResource("/Bell3.png")));

                jLabelImgUser2
                                .setIcon(new javax.swing.ImageIcon(
                                                getClass().getResource("/user2.png")));

                firstNameLabel.setFont(new java.awt.Font("Segoe UI", 1, 14));
                firstNameLabel.setText("Nombre");

                lastNameLabel.setFont(new java.awt.Font("Segoe UI", 1, 14));
                lastNameLabel.setText("Apellido");

                emailLabel.setFont(new java.awt.Font("Segoe UI", 1, 14));
                emailLabel.setText("Correo");

                passwordLabel.setFont(new java.awt.Font("Segoe UI", 1, 14));
                passwordLabel.setText("Contraseña");

                firstNameTextField.setText("John");

                lastNameTextField.setText("Doe");

                emailTextField.setText("johndoe@gmail.com");

                passwordTextField.setText("jPasswordField1");

                cancelButton.setBackground(new Color(204, 204, 204));
                cancelButton.setFont(new java.awt.Font("Segoe UI", 1, 14));
                cancelButton.setText("Cancelar");

                saveProfileButton.setBackground(Color.BLACK);
                saveProfileButton.setFont(new java.awt.Font("Segoe UI", 1, 14));
                saveProfileButton.setForeground(Color.WHITE);
                saveProfileButton.setText("Guardar");

                javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
                jPanel3.setLayout(jPanel3Layout);
                jPanel3Layout.setHorizontalGroup(
                                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel3Layout.createSequentialGroup()
                                                                .addGap(25, 25, 25)
                                                                .addGroup(jPanel3Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(passwordLabel)
                                                                                .addComponent(emailLabel)
                                                                                .addComponent(lastNameLabel)
                                                                                .addComponent(firstNameLabel)
                                                                                .addGroup(jPanel3Layout
                                                                                                .createParallelGroup(
                                                                                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                                .addGroup(jPanel3Layout
                                                                                                                .createSequentialGroup()
                                                                                                                .addComponent(editProfileLabel)
                                                                                                                .addGap(35, 35, 35)
                                                                                                                .addComponent(LabelImgUser1)
                                                                                                                .addGap(112, 112,
                                                                                                                                112)
                                                                                                                .addComponent(LabelImgBell)
                                                                                                                .addPreferredGap(
                                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                                                .addComponent(jLabelImgUser2))
                                                                                                .addGroup(jPanel3Layout
                                                                                                                .createParallelGroup(
                                                                                                                                javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                                                                false)
                                                                                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                                                jPanel3Layout.createSequentialGroup()
                                                                                                                                                .addGap(36, 36, 36)
                                                                                                                                                .addComponent(cancelButton,
                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                150,
                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                                                .addPreferredGap(
                                                                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                                Short.MAX_VALUE)
                                                                                                                                                .addComponent(saveProfileButton,
                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                150,
                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                                                .addGap(29, 29, 29))
                                                                                                                .addComponent(firstNameTextField,
                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                .addComponent(emailTextField,
                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                .addComponent(passwordTextField,
                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                .addComponent(lastNameTextField,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                460,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                                .addContainerGap(40, Short.MAX_VALUE)));
                jPanel3Layout.setVerticalGroup(
                                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel3Layout.createSequentialGroup()
                                                                .addGroup(jPanel3Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(jPanel3Layout
                                                                                                .createSequentialGroup()
                                                                                                .addGap(29, 29, 29)
                                                                                                .addComponent(editProfileLabel))
                                                                                .addGroup(jPanel3Layout
                                                                                                .createSequentialGroup()
                                                                                                .addGap(22, 22, 22)
                                                                                                .addGroup(jPanel3Layout
                                                                                                                .createParallelGroup(
                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                .addComponent(jLabelImgUser2)
                                                                                                                .addComponent(LabelImgBell)
                                                                                                                .addComponent(LabelImgUser1))))
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                21,
                                                                                Short.MAX_VALUE)
                                                                .addComponent(firstNameLabel)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(firstNameTextField,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                34,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(lastNameLabel)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(lastNameTextField,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                34,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(emailLabel)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(emailTextField,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                34,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(passwordLabel)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(passwordTextField,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                34,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(36, 36, 36)
                                                                .addGroup(jPanel3Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(cancelButton)
                                                                                .addComponent(saveProfileButton))
                                                                .addGap(35, 35, 35)));

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
                this.setLayout(layout);
                layout.setHorizontalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout
                                                                .createSequentialGroup()
                                                                .addComponent(jPanel2,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jPanel3,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                .addContainerGap()));
                layout.setVerticalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                Short.MAX_VALUE)
                                                .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                Short.MAX_VALUE));
                saveProfileButton.addActionListener(e -> {
                        if (validateFields()) {
                                updateProfileInfo();
                        }
                });
                configButton.addActionListener(e -> {
                        home.showPanel("editProfile");
                        home.appUI.showPanel("loginForm");
                        System.out.println("User " + CurrentUser.getCurrentUser().getEmail() + " logged out");
                        CurrentUser.clear();
                });
        }

        private boolean validateFields() {
                if (emailTextField.getText().isEmpty()
                                || firstNameTextField.getText().isEmpty()
                                || lastNameTextField.getText().isEmpty()
                                || passwordTextField.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Todos los campos son requeridos", "Campos requeridos",
                                        JOptionPane.INFORMATION_MESSAGE);
                        return false;
                } else if (emailTextField.getText().equals(CurrentUser.getCurrentUser().getEmail())
                                && StringUtils.capitalize(firstNameTextField.getText())
                                                .equals(CurrentUser.getCurrentUser().getFirstName())
                                && StringUtils.capitalize(lastNameTextField.getText())
                                                .equals(CurrentUser.getCurrentUser().getLastName())
                                && passwordTextField.getText().equals(CurrentUser.getCurrentUser().getPassword())) {
                        JOptionPane.showMessageDialog(null, "Cambia algún dato de tu perfil", "Cambios requeridos",
                                        JOptionPane.INFORMATION_MESSAGE);
                        return false;
                }
                return true;
        }

        public void updateCurrentUserInfo() {
                emailTextField.setText(CurrentUser.getCurrentUser().getEmail());
                firstNameTextField.setText(CurrentUser.getCurrentUser().getFirstName());
                lastNameTextField.setText(CurrentUser.getCurrentUser().getLastName());
                passwordTextField.setText(CurrentUser.getCurrentUser().getPassword());
                this.revalidate();
                this.repaint();
        }

        private void updateProfileInfo() {
                User updatedUser = new User(CurrentUser.getCurrentUser().getId(), emailTextField.getText(),
                                firstNameTextField.getText(),
                                lastNameTextField.getText(), CurrentUser.getCurrentUser().getRole(),
                                passwordTextField.getText());
                UserDao userDao = new UserDaoImpl();
                userDao.updateUser(updatedUser);
                CurrentUser.setCurrentUser(updatedUser);
                System.out.println("User info has been updated");
                JOptionPane.showMessageDialog(null, "Los datos del usuario se han actualizado!", "Datos actualizados",
                                JOptionPane.INFORMATION_MESSAGE);
        }
}
