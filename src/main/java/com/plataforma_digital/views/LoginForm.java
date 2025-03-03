package com.plataforma_digital.views;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.plataforma_digital.config.Colors;
import com.plataforma_digital.models.database.UserDao;
import com.plataforma_digital.models.database.impl.UserDaoImpl;
import com.plataforma_digital.models.User;
import com.plataforma_digital.models.CurrentUser;

public class LoginForm extends JPanel {
        private AppUI appUI;
        private JPanel jPanel1;
        private JLabel emailLabel;
        private JLabel passwordLabel;
        private JTextField emailTextField;
        private JPasswordField passwordTextField;
        private JButton loginButton;
        private JButton registerButton;
        private JButton forgottenPasswordButton;

        public LoginForm(AppUI appUI) {
                this.appUI = appUI;
                initComponents();

        }

        private void initComponents() {
                jPanel1 = new JPanel();
                emailLabel = new JLabel();
                passwordLabel = new JLabel();
                emailTextField = new JTextField();
                passwordTextField = new JPasswordField();
                loginButton = new JButton();
                forgottenPasswordButton = new JButton();
                registerButton = new JButton();

                jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

                emailLabel.setFont(new java.awt.Font("Segoe UI", 1, 14));
                emailLabel.setText("Correo");

                passwordLabel.setFont(new java.awt.Font("Segoe UI", 1, 14));
                passwordLabel.setText("Contraseña");

                emailTextField.setForeground(new Color(102, 102, 102));

                passwordTextField.setForeground(new Color(102, 102, 102));

                loginButton.setBackground(Color.BLACK);
                loginButton.setFont(new java.awt.Font("Segoe UI", 1, 14));
                loginButton.setForeground(Color.WHITE);
                loginButton.setText("Iniciar sesión");
                loginButton.setBorderPainted(false);
                loginButton.addActionListener(e -> {
                        if (validateFields()) {
                                login();
                                clearFields();
                        }
                });

                forgottenPasswordButton.setBackground(Colors.BACKGROUND_COLOR);
                forgottenPasswordButton.setFont(new java.awt.Font("Segoe UI", 2, 14));
                forgottenPasswordButton.setText("¿Olvidaste tu contraseña?");
                forgottenPasswordButton.setBorderPainted(false);

                registerButton.setBackground(Colors.BACKGROUND_COLOR);
                registerButton.setFont(new java.awt.Font("Segoe UI", 2, 14));
                registerButton.setText("¿No estás registrado? Regístrate");
                registerButton.setBorderPainted(false);
                registerButton.addActionListener(e -> {
                        appUI.showPanel("registerForm");
                        clearFields();
                });

                javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
                jPanel1.setLayout(jPanel1Layout);
                jPanel1Layout.setHorizontalGroup(
                                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGap(18, 18, 18)
                                                                .addGroup(jPanel1Layout
                                                                                .createParallelGroup(
                                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                false)
                                                                                .addComponent(passwordLabel)
                                                                                .addComponent(emailLabel)
                                                                                .addComponent(forgottenPasswordButton)
                                                                                .addComponent(registerButton,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                241,
                                                                                                Short.MAX_VALUE)
                                                                                .addComponent(loginButton,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                Short.MAX_VALUE)
                                                                                .addComponent(passwordTextField)
                                                                                .addComponent(emailTextField))
                                                                .addContainerGap(14, Short.MAX_VALUE)));
                jPanel1Layout.setVerticalGroup(
                                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGap(15, 15, 15)
                                                                .addComponent(emailLabel)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(emailTextField,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(passwordLabel)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(passwordTextField,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(loginButton)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(forgottenPasswordButton)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(registerButton)
                                                                .addContainerGap(17, Short.MAX_VALUE)));

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
                this.setLayout(layout);
                layout.setHorizontalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                                .addGap(261, 261, 261)
                                                                .addComponent(jPanel1,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addContainerGap(260, Short.MAX_VALUE)));
                layout.setVerticalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                                .addGap(50)
                                                                .addComponent(jPanel1,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addContainerGap(107, Short.MAX_VALUE)));
                add(jPanel1);
        }

        private void clearFields() {
                emailTextField.setText("");
                passwordTextField.setText("");
        }

        private boolean validateFields() {
                if (emailTextField.getText().isEmpty() || passwordTextField.getPassword().length == 0) {
                        JOptionPane.showMessageDialog(null, "Todos los campos son requeridos", "Campos requeridos",
                                        JOptionPane.INFORMATION_MESSAGE);
                        return false;
                }
                return true;
        }

        private void login() {
                String email = emailTextField.getText();
                String password = new String(passwordTextField.getPassword());
                UserDao userDao = new UserDaoImpl();
                User user = userDao.authenticateUser(email, password);

                if (user == null) {
                        JOptionPane.showMessageDialog(null, "Contraseña o correo incorrectos", "Datos incorrectos",
                                        JOptionPane.ERROR_MESSAGE);
                        return;
                }

                CurrentUser.setCurrentUser(user);
                appUI.addAndShowPanel(new Home(appUI), "home");
                System.out.println("User \"" + email + "\" logged in");
                JOptionPane.showMessageDialog(null, "Bienvenido, " + email + "!", "Bienvenido",
                                JOptionPane.INFORMATION_MESSAGE);
        }
}
