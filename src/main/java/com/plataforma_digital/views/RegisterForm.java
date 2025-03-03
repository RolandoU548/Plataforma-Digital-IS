package com.plataforma_digital.views;

import com.plataforma_digital.config.Colors;
import com.plataforma_digital.controllers.RegisterController;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JOptionPane;

public class RegisterForm extends JPanel {
        private AppUI appUI;
        private RegisterController registerController;
        private JPanel jPanel1;
        private JLabel emailLabel;
        private JLabel firstNameLabel;
        private JLabel lastNameLabel;
        private JLabel roleLabel;
        private JLabel passwordLabel;
        private JTextField emailTextField;
        private JTextField firstNameTextField;
        private JTextField lastNameTextField;
        private JComboBox<String> roleTextField;
        private JPasswordField passwordTextField;
        private JCheckBox CheckBoxAcceptTerms;
        private JButton registerButton;
        private JButton loginButton;

        public RegisterForm(AppUI appUI) {
                this.appUI = appUI;
                this.registerController = new RegisterController();
                initComponents();
        }

        private void initComponents() {
                jPanel1 = new JPanel();
                firstNameLabel = new JLabel();
                lastNameLabel = new JLabel();
                roleLabel = new JLabel();
                emailLabel = new JLabel();
                passwordLabel = new JLabel();
                firstNameTextField = new JTextField();
                lastNameTextField = new JTextField();
                roleTextField = new JComboBox<>();
                emailTextField = new JTextField();
                passwordTextField = new JPasswordField();
                CheckBoxAcceptTerms = new JCheckBox();
                registerButton = new JButton();
                loginButton = new JButton();

                jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

                firstNameLabel.setFont(new java.awt.Font("Segoe UI", 1, 14));
                firstNameLabel.setText("Nombre");

                lastNameLabel.setFont(new java.awt.Font("Segoe UI", 1, 14));
                lastNameLabel.setText("Apellido");

                roleLabel.setFont(new java.awt.Font("Segoe UI", 1, 14));
                roleLabel.setText("Tipo de usuario");

                emailLabel.setFont(new java.awt.Font("Segoe UI", 1, 14));
                emailLabel.setText("Correo");

                passwordLabel.setFont(new java.awt.Font("Segoe UI", 1, 14));
                passwordLabel.setText("Contraseña");

                firstNameTextField.setForeground(new Color(102, 102, 102));

                lastNameTextField.setForeground(new Color(102, 102, 102));
                lastNameTextField.setHorizontalAlignment(javax.swing.JTextField.LEFT);

                roleTextField.setForeground(new Color(102, 102, 102));
                roleTextField.setModel(new javax.swing.DefaultComboBoxModel<>(
                                new String[] { "Estudiante", "Profesor", "Personal administrativo" }));

                emailTextField.setForeground(new Color(102, 102, 102));

                passwordTextField.setForeground(new Color(102, 102, 102));

                CheckBoxAcceptTerms.setFont(new java.awt.Font("Segoe UI", 0, 14));
                CheckBoxAcceptTerms.setText("Aceptar términos y condiciones");

                registerButton.setBackground(Color.BLACK);
                registerButton.setFont(new java.awt.Font("Segoe UI", 1, 14));
                registerButton.setForeground(new Color(255, 255, 255));
                registerButton.setText("Registrarase");
                registerButton.setBorderPainted(false);
                registerButton.addActionListener(e -> {
                        if (validateFields()) {
                                if (register()) {
                                        clearFields();
                                        appUI.showPanel("loginForm");
                                }
                        }
                });

                loginButton.setBackground(Colors.BACKGROUND_COLOR);
                loginButton.setFont(new java.awt.Font("Segoe UI", 2, 14));
                loginButton.setText("¿Estás registrado? Iniciar sesión");
                loginButton.setBorderPainted(false);
                loginButton.addActionListener(e -> {
                        appUI.showPanel("loginForm");
                        clearFields();
                });

                javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
                jPanel1.setLayout(jPanel1Layout);
                jPanel1Layout.setHorizontalGroup(
                                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGap(22, 22, 22)
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(loginButton)
                                                                                .addGroup(jPanel1Layout
                                                                                                .createParallelGroup(
                                                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                                false)
                                                                                                .addComponent(firstNameLabel)
                                                                                                .addComponent(CheckBoxAcceptTerms,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                Short.MAX_VALUE)
                                                                                                .addComponent(passwordLabel)
                                                                                                .addComponent(emailLabel)
                                                                                                .addComponent(roleLabel)
                                                                                                .addComponent(lastNameLabel)
                                                                                                .addComponent(registerButton,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                Short.MAX_VALUE)
                                                                                                .addComponent(lastNameTextField)
                                                                                                .addComponent(roleTextField,
                                                                                                                0,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                Short.MAX_VALUE)
                                                                                                .addComponent(emailTextField)
                                                                                                .addComponent(firstNameTextField)
                                                                                                .addComponent(passwordTextField)))
                                                                .addContainerGap(24, Short.MAX_VALUE)));
                jPanel1Layout.setVerticalGroup(
                                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(firstNameLabel)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(firstNameTextField,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(lastNameLabel)
                                                                .addGap(4, 4, 4)
                                                                .addComponent(lastNameTextField,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(roleLabel)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(roleTextField,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(emailLabel)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(emailTextField,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(16, 16, 16)
                                                                .addComponent(passwordLabel)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(passwordTextField,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(CheckBoxAcceptTerms)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(registerButton)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                23,
                                                                                Short.MAX_VALUE)
                                                                .addComponent(loginButton)
                                                                .addContainerGap()));
                add(jPanel1);
        }

        private void clearFields() {
                emailTextField.setText("");
                firstNameTextField.setText("");
                lastNameTextField.setText("");
                roleTextField.setSelectedIndex(0);
                passwordTextField.setText("");
                CheckBoxAcceptTerms.setSelected(false);
        }

        private boolean validateFields() {
                if (emailTextField.getText().isEmpty() || firstNameTextField.getText().isEmpty()
                                || lastNameTextField.getText().isEmpty()
                                || passwordTextField.getPassword().length == 0 || !CheckBoxAcceptTerms.isSelected()) {
                        JOptionPane.showMessageDialog(null, "Todos los campos son requeridos", "Campos requeridos",
                                        JOptionPane.INFORMATION_MESSAGE);
                        return false;
                }
                return true;
        }

        private boolean register() {
                String email = emailTextField.getText();
                String firstName = firstNameTextField.getText();
                String lastName = lastNameTextField.getText();
                String password = new String(passwordTextField.getPassword());
                String role = roleTextField.getSelectedItem().toString();
                return registerController.registerUser(email, firstName, lastName, password, role);
        }
}