package com.plataforma_digital.gui;

import javax.swing.JPanel;

import java.awt.CardLayout;
import java.awt.BorderLayout;

public class Home extends JPanel {
    public AppUI appUI;
    private CardLayout cardLayout;
    public JPanel mainPanel;
    public Navigation navigation;
    public EditProfile editProfile;

    public Home(AppUI appUI) {
        this.appUI = appUI;
        initComponents();
    }

    private void initComponents() {
        navigation = new Navigation(this);

        editProfile = new EditProfile(this);

        cardLayout = new CardLayout();
        mainPanel = new JPanel();
        mainPanel.setLayout(cardLayout);

        mainPanel.add(editProfile, "editProfile");

        setLayout(new BorderLayout());
        add(navigation, BorderLayout.WEST);
        add(mainPanel, BorderLayout.CENTER);

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
