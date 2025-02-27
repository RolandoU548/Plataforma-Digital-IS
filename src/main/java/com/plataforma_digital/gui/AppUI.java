package com.plataforma_digital.gui;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.plataforma_digital.database.DatabaseConnection;

public class AppUI extends JFrame {
    public RegisterForm registerForm;
    public LoginForm loginForm;
    public Home home;
    private CardLayout cardLayout;
    private JPanel mainPanel;

    public AppUI() {
        setTitle("Plataforma Digital");
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new CardLayout());
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                DatabaseConnection.getInstance().disconnect();
            }
        });
        initComponents();
    }

    private void initComponents() {
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        registerForm = new RegisterForm(this);
        loginForm = new LoginForm(this);

        mainPanel.add(registerForm, "registerForm");
        addAndShowPanel(loginForm, "loginForm");

        add(mainPanel);
    }

    public void showPanel(String name) {
        cardLayout.show(mainPanel, name);
    }

    public void addAndShowPanel(JPanel panel, String name) {
        mainPanel.remove(panel);
        mainPanel.add(panel, name);
        mainPanel.revalidate();
        cardLayout.show(mainPanel, name);
    }
}
