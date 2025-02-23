package com.plataforma_digital.gui.components;

import javax.swing.JButton;

import com.plataforma_digital.gui.Home;
import com.plataforma_digital.config.Colors;
import com.plataforma_digital.gui.EditProfile;

public class ProfileButton extends JButton {
    public ProfileButton(Home home) {
        setBackground(Colors.BACKGROUND_COLOR);
        setIcon(new javax.swing.ImageIcon(
                getClass().getResource("/user2.png")));
        setBorderPainted(false);
        addActionListener(e -> {
            EditProfile editProfile = new EditProfile(home);
            home.editProfile = editProfile;
            home.addAndShowPanel(editProfile, "editProfile");
        });
    }
}
